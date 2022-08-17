package com.projetODC.Projet.Controler;

import com.projetODC.Projet.Model.Habitants;
import com.projetODC.Projet.Repo.CRUD_Habitant;
import com.projetODC.Projet.Service.HabitantsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/projet/odk/Habitants",name ="Habitants")
@Api(value = "hello", description = "Les fonctionnalités de mon API de Tourisme : HABITANTS")
public class HabitansControler {

    private HabitantsService habitantsService;

    @Autowired
    public HabitansControler(HabitantsService habitantsService)
    {
        this.habitantsService=habitantsService;
    }

    @ApiOperation(value = "La fonction d'ajout des habitants")
    @PostMapping(path = "/creer")
    public Habitants ajouterHabitant(@RequestBody Habitants habitants)
    {
        return this.habitantsService.ajouterHabitant(habitants);
    }
    @ApiOperation(value = "La fonction permettant de lister mes habitants")
    @GetMapping(path ="/liste", name = "list")

    public List<Habitants> list()
    {
        return this.habitantsService.maListe();
    }


    @ApiOperation(value = "La fonction de modification des habitants")
    @PutMapping(path ="/modifier/{id_habitans}", name = "modifier")
    public Habitants modifierHabitant(@RequestBody Habitants habitants, @PathVariable Long id_habitants)
    {
        return habitantsService.modifierHabitant(habitants, id_habitants);
    }
    @ApiOperation(value = "La fonction de suppression des habitans")
    @DeleteMapping(path ="/supprimer/{id_habitants}", name = "supprimer")
    public void supprimerHabitant(@PathVariable Long id_habitants)
    {
        this.habitantsService.supprimerHabitant(id_habitants);
    }




}
