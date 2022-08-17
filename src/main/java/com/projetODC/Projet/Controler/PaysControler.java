package com.projetODC.Projet.Controler;

import com.projetODC.Projet.Model.Pays;
import com.projetODC.Projet.Service.PaysService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/projet/odk/Pays",name ="Pays")

@Api(value = "hello", description = "Les fonctionnalités de mon API de Tourisme : PAYS")
public class PaysControler {
    private PaysService paysService;

    // ----------------------------Controller-----------------------------------
    @Autowired
    public  PaysControler(PaysService paysService) {
        this.paysService = paysService;
    }
    // ----------------------------Request Post-----------------------------------
    @ApiOperation(value = "La fonction d'ajout des pays")
    @PostMapping(path ="/creer", name = "create")
    @ResponseStatus(HttpStatus.CREATED)
    public Pays add (@RequestBody Pays pays)
    {
        return this.paysService.ajouterPays(pays);
    }


    // ----------------------------Request Get-----------------------------------
    @ApiOperation(value = "La fonction permettant d'afficher' les pays")
    @GetMapping(path ="/liste", name = "list")
    @ResponseStatus(HttpStatus.OK)
    public List<Pays> list()
    {
        return this.paysService.afficheTout();
    }


    // ----------------------------Request lIRE PAR PAYS-----------------------------------
    @ApiOperation(value = "La fonction permettant de prendre un seul pays")
    @GetMapping(path ="/unPays/{id_pays}", name = "lire")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Pays> lire(@PathVariable Long id_pays)
    {
        return  this.paysService.afficherUn(id_pays);
    }

    // ----------------------------Request modifier-----------------------------------
    @ApiOperation(value = "Modification des pays")
    @PutMapping(path ="/modifier/{id_pays}", name = "modifier")
    @ResponseStatus(HttpStatus.OK)
    public Pays modifier(@RequestBody Pays pays, @PathVariable Long id_pays)
    {

        return  this.paysService.modifierPays(pays, id_pays);
    }

    // ----------------------------Request supprimer-----------------------------------
    @ApiOperation(value = "Faire la suppression d'un pays")
    @DeleteMapping(path ="/supprimer/{id_pays}", name = "supprimer")
   //  @ResponseStatus(HttpStatus.NO_CONTENT)
    public void supprimer(@PathVariable Long id_pays)
    {
         this.paysService.supprimerPays(id_pays);
    }

}
