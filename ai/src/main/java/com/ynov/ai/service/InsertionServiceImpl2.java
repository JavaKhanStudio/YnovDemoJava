package com.ynov.ai.service;

import com.ynov.ai.entity.Model;
import com.ynov.ai.entity.Personne;
import com.ynov.ai.enums.TypeModelEnum;
import com.ynov.ai.repo.ModelRepo;
import com.ynov.ai.repo.PersonneRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Qualifier("service2")
public class InsertionServiceImpl2 implements InsertionService {

    private final PersonneRepo personneRepo;

    private final ModelRepo modelRepo ;

    @Override
    public String ajoutMultiple() {

        Personne personne = new Personne();
        Model model = Model
                .builder()
                .name("GPT")
                .typeModelEnum(TypeModelEnum.LLM)
                .build();

        Model model2 = Model
                .builder()
                .name("STABLE")
                .typeModelEnum(TypeModelEnum.STABLE_DIFFUSION)
                .build();

        Model model3 = Model
                .builder()
                .name("ALGO")
                .typeModelEnum(TypeModelEnum.ALGO)
                .build();

        personne.setModel(model);

        modelRepo.save(model) ;
        modelRepo.save(model2) ;
        modelRepo.save(model3) ;
        personneRepo.save(personne) ;

        return "OK";
    }

    @Override
    public String ajoutSimple() {
        Personne personne = new Personne();
        Model model = Model
                .builder()
                .name("GPT")
                .typeModelEnum(TypeModelEnum.LLM)
                .build();

        modelRepo.save(model) ;
        personneRepo.save(personne) ;
        return "OK";
    }
}
