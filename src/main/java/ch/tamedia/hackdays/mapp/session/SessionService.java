package ch.tamedia.hackdays.mapp.session;

import ch.tamedia.hackdays.mapp.member.Member;
import ch.tamedia.hackdays.mapp.member.MemberService;
import ch.tamedia.hackdays.mapp.skill.Skill;
import ch.tamedia.hackdays.mapp.skill.SkillService;
import ch.tamedia.hackdays.mapp.timeslot.TimeSlot;
import ch.tamedia.hackdays.mapp.timeslot.TimeSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SessionService {
	private final MemberService memberService;
	private final TimeSlotService timeSlotService;
	private final SkillService skillService;
	private final SessionRepository sessionRepository;

	@Transactional
	public SessionRepresentation create(SessionCreateDto createDto) {
		Member mentor = memberService.getMemberFromRepository(createDto.getMentorId());
		Member mentee;
		if (createDto.getMenteeId() != null)
			mentee = memberService.getMemberFromRepository(createDto.getMenteeId());
		else {
			mentee = memberService.getMemberFromRepositoryByUsernameName(createDto.getMenteeUsername());
		}

		if (mentee == null) {
			throw new RuntimeException("Mentee cannot be null");
		}

		TimeSlot timeSlot = timeSlotService.get(createDto.getMentorTimeSlotId());
		Skill skill = skillService.get(createDto.getSkillId());

		mentor.getTimeSlots().remove(timeSlot);
		mentor = memberService.update(mentor);

		var session = sessionRepository.save(new Session(mentor, mentee, timeSlot, skill));
		if (session.getParticipants().size() != 2) {
			throw new RuntimeException("There must be 2 participants");
		}

		return new SessionRepresentation(sessionRepository.save(new Session(mentor, mentee, timeSlot, skill)));
	}

	public List<SessionRepresentation> getAll() {
		return sessionRepository.findAll()
			.stream()
			.map(SessionRepresentation::new)
			.collect(Collectors.toList());
	}
}
