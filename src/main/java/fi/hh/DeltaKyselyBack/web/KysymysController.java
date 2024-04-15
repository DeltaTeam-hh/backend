package fi.hh.DeltaKyselyBack.web;


import fi.hh.DeltaKyselyBack.domain.KysymysRepositorio;

import fi.hh.DeltaKyselyBack.domain.Kysymys;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;



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
        model.addAttribute("kysymykset", kysymysRepositorio.findAll());
        return "addKysely"; // kysely.html
    }


    @GetMapping("/addKysymys")
    public String addKysely(Model model) {
        model.addAttribute("kysymys", new Kysymys());
        return "redirect:/kysely"; // kysely.html
    }


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
    

}