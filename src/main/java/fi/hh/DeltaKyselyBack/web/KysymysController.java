
package fi.hh.DeltaKyselyBack.web;



import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import fi.hh.DeltaKyselyBack.domain.Kysely;
import fi.hh.DeltaKyselyBack.domain.KyselyRepositorio;

import fi.hh.DeltaKyselyBack.domain.Kysymys;
import fi.hh.DeltaKyselyBack.domain.KysymysRepositorio;
import fi.hh.DeltaKyselyBack.domain.Monivalinta;
import fi.hh.DeltaKyselyBack.domain.MonivalintaRepo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class KysymysController {
    @Autowired
    private KysymysRepositorio kysymysRepositorio;

    @Autowired
    private KyselyRepositorio kyselyRepositorio;
    
    @Autowired
    private MonivalintaRepo monivalintaRepo;

    @RequestMapping(value = "/addmonivalinta")
	public String addMonivalinta(Model model) {
		model.addAttribute("monivalinta", new Monivalinta());
		return "addmonivalinta";
	}
    
    
   /* @PostMapping("/savemonivalinnat")
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
   

    private KyselyRepositorio kyselyRepositorio;

    // Kysymyksen lisäys
   /* @GetMapping("/addKysely")
    public String addKysymys(Model model) {
        model.addAttribute("kysymykset", kysymysRepositorio.findAll());
        return "addKysely"; // kysely.html
    }*/


    /*@GetMapping("/addKysymys")
    public String addKysely(Model model) {
        model.addAttribute("kysymys", new Kysymys());
        return "redirect:/kysely"; // kysely.html
    }*/

    
    @GetMapping("/poistaKyssari/{kysymysId}/{kyselyId}")
    public String poistaKysymys(@PathVariable("kysymysId") Long kysymysId, @PathVariable("kyselyId") Long kyselyId) {
        kysymysRepositorio.deleteById(kysymysId);
        return "redirect:/showKysely/" + kyselyId;

        
       
    }
    
<<<<<<< HEAD
=======
    
    @GetMapping("/muokkaa/{id}")
    public String muokkaa(@PathVariable("id") Long kysymysId, @PathVariable("kyselyId") Long kyselyId, Model model) {
    	Kysely kysely = kyselyRepositorio.findById(kyselyId).orElseThrow(() -> new IllegalArgumentException("Invalid kysely Id:" + kyselyId));
	    model.addAttribute("kysely", kysely);
	       return "redirect:/showKysely/" + kyselyId;
        

    }
>>>>>>> aa8e0615dc5a9d7277ec89eb6c50470a113a49ab


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
