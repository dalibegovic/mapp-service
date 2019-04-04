package ch.tamedia.hackdays.mapp.timeslot;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TimeSlotRepresentation {
	private final long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private final LocalDateTime date;

	public TimeSlotRepresentation(TimeSlot timeSlot) {
		id = timeSlot.getId();
		date = timeSlot.getDate();
	}
}
