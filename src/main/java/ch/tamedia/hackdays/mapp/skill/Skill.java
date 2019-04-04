package ch.tamedia.hackdays.mapp.skill;

import ch.tamedia.hackdays.mapp.member.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "name")
	private String name;

	@ManyToMany
	private Set<Member> members = new HashSet<>();

	Skill(String name) {
		this.name = name;
	}
}
