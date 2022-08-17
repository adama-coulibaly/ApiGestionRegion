package com.projetODC.Projet.Service;

import com.projetODC.Projet.Exception.PaysNotFoundException;
import com.projetODC.Projet.Model.Pays;
import com.projetODC.Projet.Model.Regions;
import com.projetODC.Projet.Repo.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaysService {
    private PaysRepository paysRepository;


@Autowired
// ----------------------------Controllers-----------------------------------
    public PaysService(PaysRepository paysRepository)
    {
        this.paysRepository = paysRepository;
    }
    // ----------------------------Ajouter un pays-----------------------------------

    public Pays  ajouterPays(Pays pays)
    {
        return this.paysRepository.save(pays);
    }

// ----------------------------Aficher une liste de pays-----------------------------------
    public List<Pays> afficheTout()
    {
        return this.paysRepository.findAll();
    }

// ----------------------------Aficher un pays-----------------------------------

    public Optional<Pays> afficherUn(Long id_pays)
    {
        Optional<Pays> pays = this.paysRepository.findById(id_pays);
        if (!pays.isPresent()) {
            throw new PaysNotFoundException(String.format("Le pays avec id %s n'est pas trouvé"+id_pays));
          }

        return this.paysRepository.findById(id_pays);
    }
    // ----------------------------Modifier un pays-----------------------------------
    public Pays modifierPays(Pays pays, Long id_pays)
    {
        Optional<Pays> paysExistePays = this.paysRepository.findById(id_pays);
        if (!paysExistePays.isPresent())
        {
            throw new PaysNotFoundException(String.format("Le pays avec id %s n'est pas trouvé"+id_pays));
        }

        return this.paysRepository.save(pays);
    }

    // ----------------------------Supprimer un pays-----------------------------------

    public void supprimerPays(Long id_pays)
    {
        Optional<Pays> pays = this.paysRepository.findById(id_pays);
        if (!pays.isPresent())
        {
            throw new PaysNotFoundException(String.format("Le pays avec id %s n'est pas trouvé"+id_pays));
        }

         this.paysRepository.delete(pays.get());
    }

}
