
package fi.hh.DeltaKyselyBack.web;



import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

// import fi.hh.DeltaKyselyBack.domain.KyselyRepositorio;
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
    private MonivalintaRepo monivalintaRepo;

    @RequestMapping(value = "/addmonivalinta")
	public String addMonivalinta(Model model) {
		model.addAttribute("monivalinta", new Monivalinta());
		return "addmonivalinta";
	}
    
    @GetMapping("/poistaKyssari/{kysymysId}/{kyselyId}")
    public String poistaKysymys(@PathVariable("kysymysId") Long kysymysId, @PathVariable("kyselyId") Long kyselyId) {
        kysymysRepositorio.deleteById(kysymysId);
        return "redirect:/showKysely/" + kyselyId;
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
