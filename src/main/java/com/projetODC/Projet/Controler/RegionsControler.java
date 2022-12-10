        package com.projetODC.Projet.Controler;

        import com.projetODC.Projet.Message.ReponseMessage;
        import com.projetODC.Projet.Model.Pays;
        import com.projetODC.Projet.Model.Regions;
        import com.projetODC.Projet.Repo.RegionsRepository;
        import com.projetODC.Projet.Service.RegionsService;
        import io.swagger.annotations.Api;
        import io.swagger.annotations.ApiOperation;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Optional;

        @RestController
        @Api(value = "hello", description = "Les fonctionnalités de mon API de Tourisme : REGIONS")

        @RequestMapping(path = "/projet/odk/Regions",name ="Regions")
        public class RegionsControler {

             RegionsService regionsService;
 //Controller
            @Autowired
            public RegionsControler(RegionsService regionsService)
            {
                this.regionsService=regionsService;
            }
//Classe d'ajout des regions
            @ApiOperation(value = "Crée une Region")
            @PostMapping(path ="/creer", name = "create")
            @ResponseStatus(HttpStatus.CREATED)
            public ReponseMessage add(Regions regions)
            {
                return this.regionsService.ajouterRegions(regions);
            }
//Classe afficher toute les regions

            @ApiOperation(value = "Voir la liste des Regions")
            @GetMapping(path ="/liste", name = "list")
            @ResponseStatus(HttpStatus.OK) //Permet de monter l'etat de notre requete
            public List<Regions> list()
            {
                return this.regionsService.afficherRegions();
            }
//Classe afficher une regions




            @ApiOperation(value = "Afficher une seule regions")
            @GetMapping(path ="/uneRegion/{id_regions}", name = "lire")
            @ResponseStatus(HttpStatus.OK)
        public ReponseMessage lire(@PathVariable Long id_regions)
        {
            return  this.regionsService.afficherUneRegion(id_regions);
        }
//Classe permettant de modifier les regions
@ApiOperation(value = "La fonction permettant de modifier une region")
            @PutMapping(path ="/modifier/{id_regions}", name = "modifier")
        @ResponseStatus(HttpStatus.OK)
        public ReponseMessage modifier(@RequestBody Regions regions, @PathVariable Long id_regions)
         {
            return  this.regionsService.modifierRegions(regions, id_regions);
         }
//Classe permettant de supprimer une region
@ApiOperation(value = "La fonction permettant de supprimer une region")
            @DeleteMapping(path ="/supprimer/{id_regions}", name = "supprimer")
            //  @ResponseStatus(HttpStatus.NO_CONTENT)
            public void supprimer(@PathVariable Long id_regions)
            {
                this.regionsService.supprimer(id_regions);
            }

    // La liste des regions sans pays

         @ApiOperation(value = "Afficher une region sans PAYS")
         @GetMapping(path="/regionssansPays")
         public Iterable<Object[]> mesRegions() {
             return this.regionsService.mesRegions();
         }


            // La liste des regions avec pays

            @ApiOperation(value = "Afficher une region avec PAYS")
            @GetMapping(path="/regionsavecPays")
            public Iterable<Object[]> mesRegionsAvecPays() {
                return this.regionsService.mesRegionsAvecPays();
            }
/*
            // Generale
            @ApiOperation(value = "Crée une Region en generale")
            @PostMapping(path ="/ajouter", name = "create")
            public Regions Generale(Regions regions) {
                return this.regionsService.Generale(regions);
            }

 */


         }

