package ch.tamedia.hackdays.mapp.timeslot;

import java.time.LocalDateTime;

public class TimeSlotCreateDto {
	private LocalDateTime date;

	public TimeSlotCreateDto(LocalDateTime date) {
		this.date = date;
	}

	public TimeSlotCreateDto() {
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
}
