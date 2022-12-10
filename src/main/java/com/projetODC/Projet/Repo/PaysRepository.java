package com.projetODC.Projet.Repo;

import com.projetODC.Projet.Model.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaysRepository extends JpaRepository<Pays, Long> {
   /* @Query(value =" SELECT * FROM `pays` WHERE pays.nom_pays=:nomPays",nativeQuery = true)
    List<String> VerifierPay(String nomPays);

    */

    public Pays findByNompays(String pays);
}
