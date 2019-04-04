package ch.tamedia.hackdays.mapp.timeslot;

import ch.tamedia.hackdays.mapp.member.Member;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("v1/")
@AllArgsConstructor
public class TimeSlotResource {
	private final TimeSlotService service;


}
