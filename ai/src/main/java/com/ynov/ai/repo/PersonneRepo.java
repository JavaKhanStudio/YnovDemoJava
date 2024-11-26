package com.ynov.ai.repo;

import com.ynov.ai.entity.Model;
import com.ynov.ai.entity.Personne;
import org.springframework.data.repository.CrudRepository;

public interface PersonneRepo extends CrudRepository<Personne, Long> {
}
