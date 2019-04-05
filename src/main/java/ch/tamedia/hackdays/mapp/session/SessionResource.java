package ch.tamedia.hackdays.mapp.session;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/sessions")
@RequiredArgsConstructor
public class SessionResource {
	private final SessionService service;

	@PostMapping
	public ResponseEntity<SessionRepresentation> create(@RequestBody SessionCreateDto createDto) {
		return ResponseEntity.ok(service.create(createDto));
	}

	@GetMapping
	public ResponseEntity<List<SessionRepresentation>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
}
