package fi.hh.DeltaKyselyBack.web;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import fi.hh.DeltaKyselyBack.domain.Kysymys;
import fi.hh.DeltaKyselyBack.domain.KysymysRepositorio;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class KysymysController {
    @Autowired
    private KysymysRepositorio kysymysRepositorio;

    // Kysymyksen lisäys
    @GetMapping("/addKysely")
    public String addKysymys(Model model) {
        //model.addAttribute("kysymykset", new ArrayList<>());
        model.addAttribute("kysymykset", kysymysRepositorio.findAll());
        return "addKysely"; // kysely.html
    }

    // kysymyksen tallennus?
    @PostMapping("/savekysymys")
    public String saveKysymys(@RequestParam("kysymykset") ArrayList<String> kysymykset) {
        //kysymysRepositorio.saveAll(kysymykset);
        return "redirect:/addKysely";
    }
    
	/*@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Kysymys kysymys) {
		kysymysRepositorio.save(kysymys);
		return "redirect:addKysely";
	} */
    @PostMapping("/save")
    public String saveQuestions(@RequestParam("kysymysTeksti") List<String> kysymysTekstit, RedirectAttributes redirectAttributes) {
        for (String kysymysTeksti : kysymysTekstit) {
            Kysymys kysymys = new Kysymys();
            kysymys.setKysymysTeksti(kysymysTeksti);
            kysymysRepositorio.save(kysymys);
        }
        redirectAttributes.addFlashAttribute("message", "Questions saved successfully!");
        return "redirect:/addKysely";
    }
    
   /* @PostMapping("/submit")
    public String submitForm(@RequestParam("inputs") List<String> inputs) {
        // Process form submission
        return "redirect:/form";
    } */

}
