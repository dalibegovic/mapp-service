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
}
