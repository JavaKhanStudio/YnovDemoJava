package com.ynov.ai.controller;

import com.ynov.ai.entity.Model;
import com.ynov.ai.entity.Personne;
import com.ynov.ai.enums.TypeModelEnum;
import com.ynov.ai.repo.ModelRepo;
import com.ynov.ai.repo.PersonneRepo;
import com.ynov.ai.service.InsertionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestContoller {

    private final InsertionService insertionService;

    public TestContoller(@Qualifier("service1") InsertionService insertionService) {
        this.insertionService = insertionService;
    }

    @GetMapping
    public String generateBase() {
        insertionService.ajoutMultiple() ;
        return "coucou" ;
    }

}
