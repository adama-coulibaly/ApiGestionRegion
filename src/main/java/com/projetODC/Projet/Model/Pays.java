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
public class Pays {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pays;
    private String nompays;

   // @JsonIgnore // Il nous permet d'optimiser notre base de données. Donc de ne pas voir les relations non utilisées
  //  @OneToMany(mappedBy = "pays")
  //  private List<Regions> regions;

}
