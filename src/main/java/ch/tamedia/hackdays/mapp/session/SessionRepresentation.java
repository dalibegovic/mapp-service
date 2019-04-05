package ch.tamedia.hackdays.mapp.session;

import ch.tamedia.hackdays.mapp.member.MemberRepresentation;
import ch.tamedia.hackdays.mapp.timeslot.TimeSlotRepresentation;
import lombok.Data;

@Data
public class SessionRepresentation {
	private final MemberRepresentation mentor;
	private final MemberRepresentation mentee;
	private final TimeSlotRepresentation timeSlot;

	public SessionRepresentation(Session s) {
		this.mentor = new MemberRepresentation(s.getParticipants()
			.stream()
			.filter(m -> m.getId() == s.getMentorId())
			.findFirst()
			.orElseThrow(RuntimeException::new));

		this.mentee = new MemberRepresentation(s.getParticipants()
			.stream()
			.filter(m -> m.getId() != s.getMentorId())
			.findFirst()
			.orElseThrow(RuntimeException::new));

		this.timeSlot = new TimeSlotRepresentation(s.getTimeSlot());
	}
}
