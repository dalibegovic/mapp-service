package ch.tamedia.hackdays.mapp.timeslot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeSlotService {
	private final TimeSlotRepository repository;

	public TimeSlot create(TimeSlot timeSlot) {
		return repository.save(timeSlot);
	}

	public TimeSlot create(TimeSlotCreateDto createDto) {
		var timeSlot = new TimeSlot();
		timeSlot.setDate(createDto.getDate());

		return repository.save(timeSlot);
	}
}
