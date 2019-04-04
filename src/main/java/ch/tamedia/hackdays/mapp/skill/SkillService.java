package ch.tamedia.hackdays.mapp.skill;

import ch.tamedia.hackdays.mapp.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SkillService {
	private final SkillRepository repository;

	@Transactional
	public SkillRepresentation create(SkillCreateDto createDto) {
		String name = createDto.getName().toLowerCase();

		var skill = repository.findByName(name)
			.orElseGet(() -> repository.save(new Skill(name)));

		return new SkillRepresentation(skill);
	}

	public Skill get(long id) {
		return repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException(String.format("Skill %s is not found", id)));
	}
}
