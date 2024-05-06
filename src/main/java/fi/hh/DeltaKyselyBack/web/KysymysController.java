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

import jakarta.servlet.http.HttpSession;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KysymysController {
	@Autowired
	private KysymysRepositorio kysymysRepositorio;


	@Autowired
	private KyselyRepositorio kyselyRepositorio;

	@Autowired
	private MonivalintaRepo monivalintaRepo;

	@GetMapping("/addmonivalinta")
	public String addMonivalinta(Model model, HttpSession session) {
	    // Retrieve kyselyId from wherever it's available (e.g., query creation process)
	    Long kyselyId = (Long) session.getAttribute("kyselyId");
	    if (kyselyId == null) {
	        // Handle error: kyselyId not found in session
	    }
	    model.addAttribute("kyselyId", kyselyId);
	    return "addmonivalinta";
	}
	

	
	@PostMapping("/savemonivalinnat")
	public String saveMonivalinnat(@RequestParam("kysymysTeksti") String kysymysTeksti,
	                               @RequestParam("options") List<String> options,
	                               HttpSession session,
	                               Model model) {
	    // Retrieve the kyselyId from session
	    Long kyselyId = (Long) session.getAttribute("kyselyId");

	    // Check if kyselyId is null or invalid
	    if (kyselyId == null) {
	        // Handle error: kyselyId not found in session
	    }

	    // Retrieve the Kysely object using the kyselyId
	    Kysely kysely = kyselyRepositorio.findById(kyselyId).orElse(null);

	    // Check if kysely is null or invalid
	    if (kysely == null) {
	        // Handle error: Kysely not found
	    }

	    // Save the monivalinta options and existing questions
	    Kysymys kysymys = new Kysymys();
	    kysymys.setKysymysTeksti(kysymysTeksti);
	    kysymys.setTyyppi("Monivalinta");
	    kysymys.setKysely(kysely);
	    kysymysRepositorio.save(kysymys);

	    for (String option : options) {
	        Monivalinta monivalinta = new Monivalinta(kysymys, null, option);
	        monivalintaRepo.save(monivalinta);
	    }

	    // Fetch existing questions from your repository
	    Iterable<Kysymys> existingQuestionsIterable = kysymysRepositorio.findAll();

	    // Convert Iterable to List
	    List<Kysymys> existingQuestions = new ArrayList<>();
	    existingQuestionsIterable.forEach(existingQuestions::add);

	    // Add existing questions to the model
	    model.addAttribute("kysymykset", existingQuestions);

	    // Add a dummy attribute to satisfy Thymeleaf's expectations
	    model.addAttribute("kysely", new Kysely()); // You can use any object here

	    // Return the same view to continue adding questions
	    return "addKysely";
	}




	  @GetMapping("/poistaKyssari/{kysymysId}/{kyselyId}")
	    public String poistaKysymys(@PathVariable("kysymysId") Long kysymysId, 
	                                @PathVariable("kyselyId") Long kyselyId) {
	        kysymysRepositorio.deleteById(kysymysId);
	        return "redirect:/muokkaa/" + kyselyId; 
	    }




}