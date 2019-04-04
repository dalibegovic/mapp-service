package ch.tamedia.hackdays.mapp.member;

import ch.tamedia.hackdays.mapp.skill.SkillRepresentation;
import ch.tamedia.hackdays.mapp.timeslot.TimeSlotRepresentation;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
class MemberRepresentation {
	private final long id;

	private final String firstName;
	private final String username;
	private final List<SkillRepresentation> skills;
	private final List<TimeSlotRepresentation> timeSlots;

	MemberRepresentation(Member member) {
		id = member.getId();
		firstName = member.getFirstName();
		username = member.getUsername();

		skills = member.getSkills()
			.stream()
			.map(SkillRepresentation::new)
			.collect(Collectors.toList());

		timeSlots = member.getTimeSlots()
			.stream()
			.map(TimeSlotRepresentation::new)
			.collect(Collectors.toList());
	}
}