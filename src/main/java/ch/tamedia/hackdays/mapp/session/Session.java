package ch.tamedia.hackdays.mapp.session;

import ch.tamedia.hackdays.mapp.member.Member;
import ch.tamedia.hackdays.mapp.skill.Skill;
import ch.tamedia.hackdays.mapp.timeslot.TimeSlot;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@OneToMany
	@JoinColumn(name = "member_id")
	private List<Member> participants = new ArrayList<>();

	@Column(name = "mentor_id")
	private long mentorId;

	@OneToOne
	@JoinColumn(name = "time_slot_id")
	private TimeSlot timeSlot;

	@OneToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;

	public Session(Member mentor, Member mentee, TimeSlot timeSlot, Skill skill) {
		participants.add(mentor);
		participants.add(mentee);
		mentorId = mentor.getId();
		this.timeSlot = timeSlot;
		this.skill = skill;
	}
}
