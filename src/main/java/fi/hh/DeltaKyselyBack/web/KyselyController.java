package fi.hh.DeltaKyselyBack.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import DeltaKyselyBack.domain.KyselyRepositorio;
import DeltaKyselyBack.domain.Kysely;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import DeltaKyselyBack.domain.Kysely;
import DeltaKyselyBack.domain.KyselyRepositorio;
import DeltaKyselyBack.domain.KysymysRepositorio;


@Controller
public class KyselyController {
	
	@Autowired
	private KyselyRepositorio kyselyRepositorio;
	
	@Autowired
	private KysymysRepositorio kysymysRepositorio;
	
	@RequestMapping(value = { "/", "/etusivu" })
    public String kyselyList(Model model) {
		
		List<Kysely> kyselyt = new ArrayList<>();
		for (Kysely kysely : kyselyRepositorio.findAll()) {
			kyselyt.add(kysely);
		}
		
		model.addAttribute("kyselyt", kyselyt);
		
		return "etusivu";
       
    }
	
	@PostMapping("/kysely")
	public String kysely(Model model) {
	    return "kysely";
	}
	@RequestMapping(value = "/tallenna", method = RequestMethod.POST) 
		public String save(Kysely kysely) {
			kyselyRepositorio.save(kysely);
		return "redirect:etusivu";
	}
	

	/*
	 	@RequestMapping(value = { "/", "/players" })
	public String playerList(Model model) {
		
		 List<Player> players = new ArrayList<>();
		    for (Player player : playerRepository.findAll()) {
		        players.add(player);
		    }

		Collections.sort(players, Collections.reverseOrder());

		model.addAttribute("players", players);

		return "players";
	}
	 */
	
@GetMapping("/etusivu")
public String etusivu(Model model) {
	return "etusivu";
   
}

@PostMapping("/addKysely")
public String addKysely(Model model) {
    return "addKysely";
}
}
