package ch.tamedia.hackdays.mapp.skill;

import lombok.Data;

@Data
public class SkillRepresentation {
	private final long id;
	private final String name;

	public SkillRepresentation(Skill skill) {
		id = skill.getId();
		name = skill.getName();
	}
}
