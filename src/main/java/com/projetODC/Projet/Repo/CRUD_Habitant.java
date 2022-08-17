package com.projetODC.Projet.Repo;

import com.projetODC.Projet.Model.Habitants;
import com.projetODC.Projet.Model.Regions;

import java.util.List;

public interface CRUD_Habitant {
    Habitants ajouterHabitant(Habitants habitants);
    List<Habitants> maListe();
    Habitants modifierHabitant(Habitants habitants, Long id_habitants);
    void supprimerHabitant(Long id_habitants);
}
