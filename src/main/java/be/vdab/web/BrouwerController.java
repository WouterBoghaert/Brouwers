package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brouwers")
class BrouwerController {
	private static final String ALLE_BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BROUWERS_OP_NAAM_VIEW = "brouwers/beginnaam";
	private static final String BROUWERS_TOEVOEGEN_VIEW = "brouwers/toevoegen";
	
	@GetMapping
	String findAll() {
		return ALLE_BROUWERS_VIEW;
	}
	
	@GetMapping("beginnaam")
	String findByBeginnaam() {
		return BROUWERS_OP_NAAM_VIEW;
	}
	
	@GetMapping("toevoegen")
	String createForm() {
		return BROUWERS_TOEVOEGEN_VIEW;
	}
}
