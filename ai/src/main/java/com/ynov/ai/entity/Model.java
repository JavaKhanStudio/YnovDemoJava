package com.ynov.ai.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ynov.ai.enums.TypeModelEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    String name ;
    String version ;
    String api_key ;

    @JsonIgnore
    @OneToMany(mappedBy = "model")
    List<Personne> personnes;

    @Enumerated(EnumType.STRING)
    TypeModelEnum typeModelEnum ;

}
