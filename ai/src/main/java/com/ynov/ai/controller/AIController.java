package com.ynov.ai.controller;

import com.ynov.ai.dto.ModelDTO;
import com.ynov.ai.dto.ReponseAIDTO;
import com.ynov.ai.dto.ReponseAIDTO2;
import com.ynov.ai.entity.Model;
import com.ynov.ai.repo.ModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping(path = "/ai")
public class AIController {

    @Autowired
    ModelRepo modelRepo;


    @GetMapping()
    public String index() {
        return "index";
    }

    @GetMapping(path = "/model")
    public String getModel() {
        return "Mon Modele est le plus meilleur ";
    }

    @GetMapping(path="/plusGrandQue")
    public List<Model> listModels(@RequestParam String nom, @RequestParam int version) {
        return modelRepo.findAllModelOverVersionX(nom, version);
    }

    @GetMapping(path="/model/trouver/{name}")
    public List<Model> listModels(@PathVariable String name) {

        return modelRepo.findByName(name) ;

    }


    @PostMapping(path = "/model")
    public Model postModel(@RequestBody ModelDTO modelDTO) {

        Random random = new Random();

        Model model = Model
                .builder()
                .name(modelDTO.name())
                .version(modelDTO.version())
                .api_key(random.nextInt(0,10) + "")
                .build();

        modelRepo.save(model) ;

        return model;
    }

    @PutMapping(path = "/model/{id}")
    public Model PUTModel(@PathVariable Long id, @RequestBody ModelDTO modelDTO) {

        Optional<Model> modelOptional = modelRepo.findById(id) ;

        if(modelOptional.isPresent()) {
            Model model = modelOptional.get();
            if(modelDTO.name() != null) {
                model.setName(modelDTO.name());
            }
            if(modelDTO.version() != null) {
                model.setVersion(modelDTO.version());
            }

            modelRepo.save(model) ;
            return model;
        } else {
            System.out.println("Pas trouver");
            return null;
        }


    }



    @GetMapping(path = "/model/{id}")
    public Model getModel(@PathVariable() Long id) {
        Optional<Model> modelOptional = modelRepo.findById(id) ;
        if(modelOptional.isPresent()) {
            return modelOptional.get();
        } else {
            System.out.println("Pas trouver");
            return null;
        }
    }

    @GetMapping(path = "/reponse")
    public ReponseAIDTO getReponse() {
        return new ReponseAIDTO(22, "Bonjour");
    }

    @GetMapping(path = "/reponse/2")
    public ReponseAIDTO2 getReponse2(@RequestParam String question) {
        return ReponseAIDTO2
                .builder()
                .reponse(question + " Bonsoir")
                .code(23)
                .build() ;
    }



}
