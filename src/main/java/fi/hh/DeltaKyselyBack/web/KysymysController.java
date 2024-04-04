package fi.hh.DeltaKyselyBack.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import fi.hh.DeltaKyselyBack.domain.Kysymys;
import fi.hh.DeltaKyselyBack.domain.KysymysRepositorio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KysymysController {
    @Autowired
    private KysymysRepositorio kysymysRepositorio;

    // Kysymyksen lisäys
    @GetMapping("/addkysymys")
    public String addKysely(Model model) {
        model.addAttribute("kysymys", new Kysymys());
        return "redirect:/kysely"; // kysely.html
    }

    // kysymyksen tallennus?
    @PostMapping("/savekysymys")
    public String saveKysymys(Kysymys kysymys) {
        kysymysRepositorio.save(kysymys);
        return "redirect:/kysely";
    }

}
