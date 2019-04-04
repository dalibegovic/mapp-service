package ch.tamedia.hackdays.mapp.hello;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloResource {
	@PostMapping("/{message}")
	public ResponseEntity<String> post(@PathVariable String message) {
		return ResponseEntity.ok(message);
	}
}
