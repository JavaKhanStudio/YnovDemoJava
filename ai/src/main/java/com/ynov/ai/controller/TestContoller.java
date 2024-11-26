package com.ynov.ai.controller;

import com.ynov.ai.entity.Model;
import com.ynov.ai.entity.Personne;
import com.ynov.ai.repo.ModelRepo;
import com.ynov.ai.repo.PersonneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestContoller {

    @Autowired
    PersonneRepo personneRepo;

    @Autowired
    ModelRepo modelRepo ;

    @GetMapping
    public void fairePlanter() {
        Personne personne = new Personne();
        Model model = new Model();

        personne.setModel(model);

        modelRepo.save(model) ;
        personneRepo.save(personne) ;
    }

}
