package com.projetODC.Projet.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Regions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id_regions;
    private String nom_regions;

    @Column(unique = true)
    private String code_region;
    private String activiter_region;
    private String superficie_region;
    private String langue_m_region;

    @JsonIgnore
    @ManyToOne
    private Pays pays;


}
