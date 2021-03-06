package ch.tamedia.hackdays.mapp.session;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SessionCreateDto {
	@JsonProperty
	private int mentorId;

	@JsonProperty
	private Integer menteeId;

	@JsonProperty
	private String menteeUsername;

	@JsonProperty
	private int mentorTimeSlotId;

	@JsonProperty
	private int skillId;
}
