package com.projetODC.Projet.Repo;

import com.projetODC.Projet.Model.Habitants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitantsRepository extends JpaRepository<Habitants, Long> {
}
