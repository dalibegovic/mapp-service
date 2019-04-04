package ch.tamedia.hackdays.mapp.member;

import ch.tamedia.hackdays.mapp.exception.ResourceNotFoundException;
import ch.tamedia.hackdays.mapp.skill.SkillCreateDto;
import ch.tamedia.hackdays.mapp.skill.SkillService;
import ch.tamedia.hackdays.mapp.timeslot.TimeSlot;
import ch.tamedia.hackdays.mapp.timeslot.TimeSlotCreateDto;
import ch.tamedia.hackdays.mapp.timeslot.TimeSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
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

	private Member getMemberFromRepository(long id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException(String.format("Member with id: %s does not exist.", id)));
	}

	private Member create() {
		var member = new Member();
		member.setFirstName("Petar");
		member.setUsername("ppan");
		var javaSkill = skillService.create(new SkillCreateDto("Java"));
		var scalaSkill = skillService.create(new SkillCreateDto("Scala"));

		member.getSkills().add(skillService.get(javaSkill.getId()));
		member.getSkills().add(skillService.get(scalaSkill.getId()));

		TimeSlot t1 = new TimeSlot();
		TimeSlot t2 = new TimeSlot();
		t1.setDate(LocalDateTime.of(2019, Month.JANUARY, 5, 10, 0));
		t2.setDate(LocalDateTime.of(2019, Month.JANUARY, 5, 12, 0));
		t1 = timeSlotService.create(t1);
		t2 = timeSlotService.create(t2);
		member.getTimeSlots().add(t1);
		member.getTimeSlots().add(t2);

		return repository.save(member);
	}
}
