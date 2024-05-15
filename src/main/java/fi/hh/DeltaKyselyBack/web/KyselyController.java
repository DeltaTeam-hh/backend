package fi.hh.DeltaKyselyBack.web;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;




import fi.hh.DeltaKyselyBack.domain.Kysely;
import fi.hh.DeltaKyselyBack.domain.KyselyRepositorio;
import fi.hh.DeltaKyselyBack.domain.Kysymys;
import fi.hh.DeltaKyselyBack.domain.KysymysRepositorio;
import jakarta.servlet.http.HttpSession;





@Controller
public class KyselyController {
	
	@Autowired
	private KyselyRepositorio kyselyRepositorio;
	
	@Autowired
	private KysymysRepositorio kysymysRepositorio;
	
	@RequestMapping(value = { "/", "/etusivu" })
    public String kyselyList(Model model) {

		
		model.addAttribute("kyselyt", kyselyRepositorio.findAll());
		
		return "etusivu";
       
    }
	

	
	@GetMapping("/addKysely")
	public String getAddKysely(Model model, HttpSession session) {
	    Kysely kysely = new Kysely(); // Create a new Kysely object
	    kysely = kyselyRepositorio.save(kysely);
	    model.addAttribute("kysely", kysely); // Add it to the model
	    
	 // Set the kyselyId in the session
	    session.setAttribute("kyselyId", kysely.getKyselyId());
	    
	    return "addKysely"; // Return the view name
	}
	
	@PostMapping("/addKysely")
	public String addKysely(Model model) {
	    model.addAttribute("kysely", new Kysely());
	    return "addKysely";
	}
	

	@GetMapping("/muokkaa/{id}")
	public String muokkaa(@PathVariable("id") Long kyselyId, Model model) {
	    Optional<Kysely> kyselyOptional = kyselyRepositorio.findById(kyselyId);
	    
	    if (!kyselyOptional.isPresent()) {
	        return "redirect:/etusivu"; 
	    }
	    
	    Kysely kysely = kyselyOptional.get();
	    model.addAttribute("kysely", kysely);

	    List<Kysymys> kysymykset = kysymysRepositorio.findByKysely(kysely);
	    
	    if (kysymykset.isEmpty()) {
	        model.addAttribute("noQuestions", true);
	    }
	    
	    model.addAttribute("kysymykset", kysymykset);

	    return "muokkaa"; 
	}


	
	@PostMapping("/savekysely")
	public String saveKysely(
	    Kysely kysely,
	    @RequestParam(value = "kysymysId", required = false) List<Long> kysymysIds,
	    @RequestParam(value = "kysymysTeksti", required = true) List<String> kysymysTekstit, HttpSession session
	) {
		Long kyselyId = (Long) session.getAttribute("kyselyId");
		kysely.setKyselyId(kyselyId);
		
	    Kysely savedKysely = kyselyRepositorio.save(kysely);

	    if (kysymysTekstit != null) {
	        for (int i = 0; i < kysymysTekstit.size(); i++) {
	            Long kysymysId = (kysymysIds != null && i < kysymysIds.size()) ? kysymysIds.get(i) : null;
	            String kysymysTeksti = kysymysTekstit.get(i);

	            if (kysymysId != null && kysymysRepositorio.existsById(kysymysId)) {
	                Kysymys existingKysymys = kysymysRepositorio.findById(kysymysId).get();
	                existingKysymys.setKysymysTeksti(kysymysTeksti);
	                existingKysymys.setTyyppi("Tekstikysymys");
	                kysymysRepositorio.save(existingKysymys);
	            } else {
	                Kysymys newKysymys = new Kysymys();
	                newKysymys.setKysymysTeksti(kysymysTeksti);
	                newKysymys.setTyyppi("Tekstikysymys");
	                newKysymys.setKysely(savedKysely);
	                kysymysRepositorio.save(newKysymys);
	            }
	        }
	    }

	    return "redirect:/etusivu";
	}


	
	   
	
	 @GetMapping("/showKysely/{id}")
	 public String showKysely(@PathVariable Long id, Model model) {
	     Optional<Kysely> kyselyOptional = kyselyRepositorio.findById(id);
	     if (kyselyOptional.isPresent()) {
	         Kysely kysely = kyselyOptional.get();
	         List<Kysymys> kysymykset = kysymysRepositorio.findByKyselyId(kysely.getKyselyId()); // Assuming Kysymys has a kyselyId field
	         model.addAttribute("kysely", kysely);
	         model.addAttribute("kysymykset", kysymykset);
	         return "showKysely"; 
	     } else {
	         return "redirect:/etusivu";
	     }
	 }
	
		@GetMapping("/poistaKysely/{id}")
		public String poistaKysely(@PathVariable("id") Long kyselyId, Model model) {
		    kyselyRepositorio.deleteById(kyselyId);
		    return "redirect:/etusivu";
		}



}
