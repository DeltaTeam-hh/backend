package fi.hh.DeltaKyselyBack.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fi.hh.DeltaKyselyBack.domain.Kysely;
import fi.hh.DeltaKyselyBack.domain.KyselyRepositorio;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
// (origins = "http://localhost:5175")

@Controller

public class KyselyRestController {
  @Autowired
  private KyselyRepositorio kRepositorio;

  // Hakee kaikki kyselyt
  @GetMapping("/kyselyt")
  public @ResponseBody List<Kysely> getKyselyRest() {
    return (List<Kysely>) kRepositorio.findAll();
  }

  // Hakee yksittäisen kyselyn
  @GetMapping("/kyselyt/{kyselyId}")
  public @ResponseBody List<Kysely> getKyselyById(@PathVariable("kyselyId") Long kyselyId) {
    return kRepositorio.findByKyselyId(kyselyId);
  }

  @PostMapping("/kyselyt")
  public @ResponseBody Kysely addKysely(@RequestBody Kysely newKysely) {
    return kRepositorio.save(newKysely);
  }

}
/*
 * @PostMapping("/books")
 * public @ResponseBody Book addBook(@RequestBody Book newBook){
 * return repository.save(newBook);
 * }
 */
