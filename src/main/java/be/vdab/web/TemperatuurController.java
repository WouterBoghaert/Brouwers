package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.exceptions.KanTemperatuurNietLezenException;
import be.vdab.services.TemperatuurService;

@Controller
@RequestMapping("temperatuur")
class TemperatuurController {
	private final static String VIEW = "temperatuur/temperatuur";
	private final TemperatuurService temperatuurService;
	
	TemperatuurController(TemperatuurService temperatuurService) {
		this.temperatuurService = temperatuurService;
	}
	
	@GetMapping("temperatuur/{gemeente}")
	ModelAndView getTemperatuur(@PathVariable String gemeente) {
		ModelAndView modelAndView = new ModelAndView(VIEW, "gemeente", gemeente);
		try {
			modelAndView.addObject("temperatuur", temperatuurService.temperatuur(gemeente));
		}
		catch(KanTemperatuurNietLezenException ex) {
			modelAndView.addObject("fout", "Kan temperatuur niet lezen");
		}
		return modelAndView;
	}
}
