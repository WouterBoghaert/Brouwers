package be.vdab.web;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;

@Controller
@RequestMapping("/brouwers")
class BrouwerController {
	private static final String ALLE_BROUWERS_VIEW = "brouwers/brouwers";
	private static final String BROUWERS_OP_ALFABET_VIEW = "brouwers/alfabet";
	private static final String BROUWERS_OP_NAAM_VIEW = "brouwers/beginnaam";
	private static final String BROUWERS_TOEVOEGEN_VIEW = "brouwers/toevoegen";
	private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/brouwers";
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
		ModelAndView modelAndView = new ModelAndView(BROUWERS_OP_ALFABET_VIEW);
		modelAndView.addObject("alfabet", alfabet);
		return modelAndView ;
	}
	
	@GetMapping("alfabet")
	ModelAndView beginletter() {
		return toonAlfabet();
	}
	
	@GetMapping("alfabet/{beginletter}")
	ModelAndView findByLetter(@PathVariable String beginletter) {
		if(beginletter == null || !alfabet.contains(beginletter)) {
			return toonAlfabet();
		}
		else {
			ModelAndView modelAndView = toonAlfabet();
			modelAndView.addObject("brouwers", brouwerService.findByNaam(beginletter));
			return modelAndView;
		}
	}
	
	@GetMapping("beginnaam")
	ModelAndView findByBrouwerBeginNaam() {
		BrouwerBeginNaam beginnaam = new BrouwerBeginNaam();
		return new ModelAndView(BROUWERS_OP_NAAM_VIEW).addObject(beginnaam);
	}
	
	@GetMapping(path="beginnaam", params="beginnaam")
	ModelAndView findByBrouwerBeginNaam(@Valid BrouwerBeginNaam beginnaam,
		BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(BROUWERS_OP_NAAM_VIEW);
		if(!bindingResult.hasErrors()) {
			List<Brouwer> brouwers = brouwerService.findByNaam(beginnaam.getBeginnaam());
			if(brouwers.isEmpty()) {
				bindingResult.reject("geenBrouwers");
			}
			else {
				modelAndView.addObject("brouwers", brouwers);
			}
		}
		return modelAndView;
	}
	
	@GetMapping("toevoegen")
	ModelAndView createForm() {
		return new ModelAndView(BROUWERS_TOEVOEGEN_VIEW, "brouwer", new Brouwer());
	}
	
	@PostMapping("toevoegen")
	String create(@Valid Brouwer brouwer, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return BROUWERS_TOEVOEGEN_VIEW;
		}
		brouwerService.create(brouwer);
		return REDIRECT_URL_NA_TOEVOEGEN;
	}
	
	@InitBinder("brouwer")
	void initBinderBrouwer(WebDataBinder binder) {
		binder.initDirectFieldAccess();
	}
}
