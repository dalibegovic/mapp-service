package ch.tamedia.hackdays.mapp.timeslot;

import ch.tamedia.hackdays.mapp.exception.ResourceNotFoundException;
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

	public TimeSlot get(long id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException(String.format("TimeSlot %s not found.", id)));
	}
}
