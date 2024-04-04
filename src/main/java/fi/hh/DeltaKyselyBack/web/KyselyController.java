package fi.hh.DeltaKyselyBack.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KyselyController {
	
	@GetMapping("/etusivu")
    public String etusivu(Model model) {
		return "etusivu";
       
    }
	
	@PostMapping("/addKysely")
	public String addKysely(Model model) {
	    return "addKysely";
	}

}
