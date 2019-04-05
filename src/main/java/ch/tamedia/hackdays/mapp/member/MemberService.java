package ch.tamedia.hackdays.mapp.member;

import ch.tamedia.hackdays.mapp.exception.ResourceNotFoundException;
import ch.tamedia.hackdays.mapp.skill.SkillService;
import ch.tamedia.hackdays.mapp.timeslot.TimeSlotCreateDto;
import ch.tamedia.hackdays.mapp.timeslot.TimeSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository repository;

	private final SkillService skillService;
	private final TimeSlotService timeSlotService;

	MemberRepresentation getMember(long id) {
		var member = getMemberFromRepository(id);

		return new MemberRepresentation(member);
	}

	List<MemberRepresentation> getAll() {
		return repository.findAll()
			.stream()
			.map(MemberRepresentation::new)
			.collect(Collectors.toList());
	}

	List<MemberRepresentation> getAll(String skill) {
		return repository.findAll()
			.stream()
			.filter(m -> m.getSkills().stream().anyMatch(s -> s.getName().equals(skill)))
			.map(MemberRepresentation::new)
			.collect(Collectors.toList());
	}

	public MemberRepresentation addTimeSlot(long id, TimeSlotCreateDto createDto) {
		var timeSlot = timeSlotService.create(createDto);
		var member = getMemberFromRepository(id);

		member.getTimeSlots().add(timeSlot);
		member = repository.save(member);

		return new MemberRepresentation(member);
	}

	public Member getMemberFromRepository(long id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException(String.format("Member with id: %s does not exist.", id)));
	}

	public Member getMemberFromRepositoryByUsernameName(String username) {
		return repository.findByUsername(username)
			.orElseThrow(() -> new ResourceNotFoundException(String.format("Member with name: %s does not exist.", username)));
	}

	public Member update(Member member) {
		return repository.save(member);
	}
}
