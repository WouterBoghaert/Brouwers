package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
class BrouwerController {
	private static final String ALLE_BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BROUWERS_OP_NAAM_VIEW = "brouwers/beginnaam";
	private static final String BROUWERS_TOEVOEGEN_VIEW = "brouwers/toevoegen";
	private final BrouwerService brouwerService;
	
	BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
	}
	
	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView(ALLE_BROUWERS_VIEW,"brouwers", brouwerService.findAll());
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
