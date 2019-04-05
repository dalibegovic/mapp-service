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
		Member mentee = memberService.getMemberFromRepository(createDto.getMenteeId());
		TimeSlot timeSlot = timeSlotService.get(createDto.getMentorTimeSlotId());
		Skill skill = skillService.get(createDto.getSkillId());

		mentor.getTimeSlots().remove(timeSlot);
		mentor = memberService.update(mentor);

		return new SessionRepresentation(sessionRepository.save(new Session(mentor, mentee, timeSlot, skill)));
	}
}
