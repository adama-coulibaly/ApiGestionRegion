package com.projetODC.Projet.Repo;

import com.projetODC.Projet.Model.Pays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysRepository extends JpaRepository<Pays, Long> {


}
