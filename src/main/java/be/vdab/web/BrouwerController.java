package be.vdab.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	private final List<String> alfabet = Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
	
	BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
	}
	
	@GetMapping
	ModelAndView findAll() {
		return new ModelAndView(ALLE_BROUWERS_VIEW,"brouwers", brouwerService.findAll());
	}
	
	ModelAndView toonAlfabet() {
		ModelAndView modelAndView = new ModelAndView(BROUWERS_OP_NAAM_VIEW);
		modelAndView.addObject("alfabet", alfabet);
		return modelAndView ;
	}
	
	@GetMapping("beginnaam")
	ModelAndView beginnaam() {
		return toonAlfabet();
	}
	
	@GetMapping("beginnaam/{beginletter}")
	ModelAndView findByBeginnaam(@PathVariable String beginletter) {
		if(beginletter == null || !alfabet.contains(beginletter)) {
			return toonAlfabet();
		}
		else {
			ModelAndView modelAndView = toonAlfabet();
			modelAndView.addObject("brouwers", brouwerService.findByNaam(beginletter));
			return modelAndView;
		}
	}
	
	@GetMapping("toevoegen")
	String createForm() {
		return BROUWERS_TOEVOEGEN_VIEW;
	}
}
