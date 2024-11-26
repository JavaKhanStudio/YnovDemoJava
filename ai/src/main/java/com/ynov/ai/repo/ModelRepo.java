package com.ynov.ai.repo;

import com.ynov.ai.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ModelRepo extends CrudRepository<Model, Long> {
}
