package fi.hh.DeltaKyselyBack.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import fi.hh.DeltaKyselyBack.domain.KysymysRepositorio;

@CrossOrigin
// (origins = "http://localhost:5175")

@Controller
public class KysymysRestController {
    @Autowired
    private KysymysRepositorio kysymysRepository;

}
