package fi.hh.DeltaKyselyBack.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import fi.hh.DeltaKyselyBack.domain.Vastaus;
import fi.hh.DeltaKyselyBack.domain.VastausRepositorio;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
// (origins = "http://localhost:5175")

@RestController
public class VastausRestController {

    @Autowired
    private VastausRepositorio vRepositorio;

    // Haetaan kaikki vastaukset
    @GetMapping("/vastaukset")
    public @ResponseBody List<Vastaus> getVastausRest() {
        return (List<Vastaus>) vRepositorio.findAll();
    }

    @PostMapping("/vastaukset")
    public @ResponseBody List<Vastaus> addVastaus(@RequestBody List<Vastaus> newVastaukset) {
        return (List<Vastaus>) vRepositorio.saveAll(newVastaukset);
    }
}
