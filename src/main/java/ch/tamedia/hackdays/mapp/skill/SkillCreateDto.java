package ch.tamedia.hackdays.mapp.skill;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

public class SkillCreateDto {
	@JsonProperty
	private String name;

	public SkillCreateDto(String name) {
		this.name = name;
	}

	public SkillCreateDto() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
