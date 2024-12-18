package com.ynov.ai.controller;

import com.ynov.ai.dto.PersonneDTO;
import com.ynov.ai.entity.Model;
import com.ynov.ai.entity.Personne;
import com.ynov.ai.enums.TypeModelEnum;
import com.ynov.ai.repo.ModelRepo;
import com.ynov.ai.repo.PersonneRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/personne")
@RequiredArgsConstructor
public class PersonneController {

    private final PersonneRepo personneRepo;
    private final ModelRepo modelRepo ;


    @GetMapping(path = "/{id}")
    public PersonneDTO getPersonne(@PathVariable long id) {

        Personne personne = personneRepo.findById(id).orElse(null) ;
        PersonneDTO dto = null ;
        if(personne != null) {
            dto = new PersonneDTO(personne.getNom(), personne.getModel() !=null ? personne.getModel().getName() : null) ;
        }

        return dto;
    }

    @PostMapping()
    public Personne addPersonne(@RequestBody PersonneDTO personneDTO) {
        Personne personne = Personne
                .builder()
                .nom(personneDTO.nom())
                .build() ;

        personneRepo.save(personne) ;
        return personne ;
    }

    @PostMapping(path="/{idModel}")
    public Personne addPersonneOnModel(@RequestBody PersonneDTO personneDTO, @PathVariable long idModel) {
        Model model = modelRepo.findById(idModel).orElse(null) ;

        if(model == null) {
            return null ;
        }

        Personne personne = Personne
                .builder()
                .nom(personneDTO.nom())
                .model(model)
                .build() ;

        personneRepo.save(personne) ;
        return personne ;
    }

    @PostMapping(path = "/link/{idModel}/{idPersonne}")
    public String linkPersonneToModel(@PathVariable long idModel, @PathVariable long idPersonne) {
        Personne personne = personneRepo.findById(idPersonne).orElse(null);
        Model model = modelRepo.findById(idModel).orElse(null) ;

        if(personne != null && model != null) {
            personne.setModel(model) ;
            personneRepo.save(personne) ;
            return "C'est bien" ;
        }
        else if(personne == null) {
            return "personne null" ;
        }
        else if(model == null) {
            return "model null" ;
        } else {
            return null ;
        }


    }



}
