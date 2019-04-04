package ch.tamedia.hackdays.mapp.skill;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/skills")
@RequiredArgsConstructor
public class SkillResource {
	private final SkillService service;

	@PostMapping
	public ResponseEntity<SkillRepresentation> create(@RequestBody SkillCreateDto createDto) {
		var skill = service.create(createDto);

		return ResponseEntity.ok(skill);
	}
}
