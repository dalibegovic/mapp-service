package ch.tamedia.hackdays.mapp.session;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/sessions")
@RequiredArgsConstructor
public class SessionResource {
	private final SessionService service;

	@PostMapping
	public ResponseEntity<SessionRepresentation> create(@RequestBody SessionCreateDto createDto) {
		System.out.println(createDto);
		return ResponseEntity.ok(service.create(createDto));
	}
}
