package ch.tamedia.hackdays.mapp.timeslot;

import ch.tamedia.hackdays.mapp.member.Member;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "time_slot")
@Data
public class TimeSlot {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "date")
	private LocalDateTime date;

	@ManyToMany
	private Set<Member> members = new HashSet<>();
}
