package fi.hh.DeltaKyselyBack.web;

<<<<<<< HEAD

import DeltaKyselyBack.domain.KysymysRepositorio;
import DeltaKyselyBack.domain.Kysymys;



=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import DeltaKyselyBack.domain.Kysymys;
import DeltaKyselyBack.domain.KysymysRepositorio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
>>>>>>> ba7ca2369d5449b3af30edba078d4b5b3152efc3
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
