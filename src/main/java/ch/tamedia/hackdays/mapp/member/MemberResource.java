package ch.tamedia.hackdays.mapp.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/members")
@RequiredArgsConstructor
public class MemberResource {
	private final MemberService service;

	@GetMapping("/{id}")
	public ResponseEntity<MemberRepresentation> get(@PathVariable long id) {
		return ResponseEntity.ok().body(service.getMember(id));
	}

	@GetMapping
	public ResponseEntity<List<MemberRepresentation>> getAll() {
		return ResponseEntity.ok().body(service.getAll());
	}
}
