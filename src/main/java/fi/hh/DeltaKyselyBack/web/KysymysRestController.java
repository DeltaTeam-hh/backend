package fi.hh.DeltaKyselyBack.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fi.hh.DeltaKyselyBack.domain.KysymysRepositorio;

@Controller
public class KysymysRestController {
    @Autowired
    private KysymysRepositorio kysymysRepository;

    

}
