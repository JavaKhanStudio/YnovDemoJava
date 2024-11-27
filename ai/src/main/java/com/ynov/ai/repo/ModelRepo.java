package com.ynov.ai.repo;

import com.ynov.ai.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public interface ModelRepo extends CrudRepository<Model, Long> {

    @Query(value = "SELECT * FROM Model model WHERE " +
            "model.name = ?1 and version > ?2  ", nativeQuery = true)
    public List<Model> findAllModelOverVersionX(String name, int versionPlusGrandQue) ;

    List<Model> findByName(String name);


}
