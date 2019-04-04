package ch.tamedia.hackdays.mapp.member;

import ch.tamedia.hackdays.mapp.skill.Skill;
import ch.tamedia.hackdays.mapp.timeslot.TimeSlot;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "username")
	private String username;

	@ManyToMany
	@JoinTable(
		name = "member_skill",
		joinColumns = @JoinColumn(name = "member_id"),
		inverseJoinColumns = @JoinColumn(name = "skill_id"))
	private final Set<Skill> skills = new HashSet<>();

	@ManyToMany
	@JoinTable(
		name = "member_time_slots",
		joinColumns = @JoinColumn(name = "member_id"),
		inverseJoinColumns = @JoinColumn(name = "time_slot_id"))
	private final Set<TimeSlot> timeSlots = new HashSet<>();
}
