package fi.hh.DeltaKyselyBack.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import DeltaKyselyBack.domain.KyselyRepositorio;
import DeltaKyselyBack.domain.Kysely;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class KyselyController {
	
	@GetMapping("/etusivu")
    public String etusivu(Model model) {
		return "etusivu";
       
    }
	
	@PostMapping("/kysely")
	public String kysely(Model model) {
	    return "kysely";
	}
	@RequestMapping(value = "/tallenna", method = RequestMethod.POST) 
		public String save(Kysely kysely) {
		repository.save(kysely);
		return "redirect:etusivu";
	}
	

}
