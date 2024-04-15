package fi.hh.DeltaKyselyBack.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class VastausRestController {

    @Autowired
    private VastausRepositorio vRepositorio;

    //Haetaan kaikki vastaukset
    @GetMapping("/vastaukset")
    public @ResponseBody List <Vastaus> getVastausRest() {
        return (List <Vastaus>) vRepositorio.findAll();
    }

    @PostMapping("/vastaukset")
        public @ResponseBody Vastaus addVastaus(@RequestBody Vastaus newVastaus){
            return vRepositorio.save(newVastaus);
        }
    }
    
    
    

