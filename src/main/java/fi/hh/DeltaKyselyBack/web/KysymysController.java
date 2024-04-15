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
import org.springframework.web.bind.annotation.RequestParam;


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


    @PostMapping("/savekysymykset")
    public String saveQuestions(@RequestParam("kysymysTeksti") List<String> kysymysTekstit, Model model) {
        for (String kysymysTeksti : kysymysTekstit) {
            Kysymys kysymys = new Kysymys();
            kysymys.setKysymysTeksti(kysymysTeksti);
            kysymysRepositorio.save(kysymys);
        }
        
        Iterable<Kysymys> savedKysymyksetIterable = kysymysRepositorio.findAll();
        List<Kysymys> savedKysymykset = new ArrayList<>();
        savedKysymyksetIterable.forEach(savedKysymykset::add);
        
        model.addAttribute("kysymykset", savedKysymykset);
        
        return "redirect:/addKysely";
    }
    

}