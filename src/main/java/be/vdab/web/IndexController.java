package be.vdab.web;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class IndexController {
	private static final String VIEW = "index";
	
	@GetMapping
	ModelAndView index() {
		String begroeting;
		LocalTime nu = LocalTime.now();
		if(nu.getHour() >= 0 && nu.getHour() <= 5) {
			begroeting = "goede_nacht";
		}
		else {
			if(nu.getHour() >=6 && nu.getHour() <= 11) {
				begroeting = "goede_morgen";
			}
			else {
				if(nu.getHour() >= 12 && nu.getHour() <= 17 ) {
					begroeting = "goede_middag";
				}
				else {
					begroeting = "goede_avond";
				}
			}
		}
		return new ModelAndView(VIEW, "begroeting", begroeting);
	}
}
