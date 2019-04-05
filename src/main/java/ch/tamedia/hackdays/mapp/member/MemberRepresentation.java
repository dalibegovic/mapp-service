package ch.tamedia.hackdays.mapp.member;

import ch.tamedia.hackdays.mapp.skill.SkillRepresentation;
import ch.tamedia.hackdays.mapp.timeslot.TimeSlotRepresentation;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class MemberRepresentation {
	private final long id;

	private final String firstName;
	private final String lastName;
	private final String username;
	private final String profilePictureLink;
	private final List<SkillRepresentation> skills;
	private final List<TimeSlotRepresentation> timeSlots;

	public MemberRepresentation(Member member) {
		id = member.getId();
		firstName = member.getFirstName();
		lastName = member.getLastName();
		username = member.getUsername();
		profilePictureLink = member.getImageLink();

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
