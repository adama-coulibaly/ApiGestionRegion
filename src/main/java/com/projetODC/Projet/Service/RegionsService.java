        package com.projetODC.Projet.Service;

        import com.projetODC.Projet.Exception.Message;
        import com.projetODC.Projet.Exception.PaysNotFoundException;
        import com.projetODC.Projet.Message.ReponseMessage;
        import com.projetODC.Projet.Model.Pays;
        import com.projetODC.Projet.Model.Regions;
        import com.projetODC.Projet.Repo.PaysRepository;
        import com.projetODC.Projet.Repo.RegionsRepository;
        import org.springframework.http.HttpStatus;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;
        @Service
        public class RegionsService {
        RegionsRepository regionsRepository;
        PaysRepository paysRepository;
        Pays pays;

//Controllers
        public RegionsService(RegionsRepository regionsRepository)
        {
            this.regionsRepository = regionsRepository;
        }
//Ajouter des Regions
        public ReponseMessage ajouterRegions(Regions regions)
        {
            try {
                 regionsRepository.save(regions);
                 ReponseMessage message = new ReponseMessage("Région ajoutée avec succès",true);
                 return message;
            }
            catch (Exception e)
            {
                ReponseMessage message = new ReponseMessage("Regions existe déja",false);
                return message;
            }


        }
//Afficher la liste des Regions
        public List<Regions> afficherRegions()
            {
                return regionsRepository.findAll();
            }

// Afficher une seule region
            public ReponseMessage afficherUneRegion(Long id_regions)
            {
                Optional<Regions> regions = this.regionsRepository.findById(id_regions);

                if (!regions.isPresent()) {
                    ReponseMessage message = new ReponseMessage("Cette région n'est pas trouvée !", false);
                    return message;
                }
                else {
                    Regions RG =  this.regionsRepository.findById(id_regions).get();
                    ReponseMessage message = new ReponseMessage(" Nom: "+RG.getNomregions()+" Pays: "+RG.getPays().getNompays()+" Activité "+RG.getActiviter_region()+" Code région: "+RG.getCoderegion()+" Langue: "+RG.getLangue_m_region()+" Superficie: "+RG.getSuperficie_region(), true);
                    return message;
                }

            }
 //Modifier un pays
            public ReponseMessage modifierRegions(Regions regions, Long id_regions)
            {
                Optional<Regions> regionExistePays = this.regionsRepository.findById(id_regions);
                if (!regionExistePays.isPresent())
                {
                    ReponseMessage message = new ReponseMessage("Cette région n'est pas trouvée !", false);
                    return message;
                }
                else {
                    Regions regions1 = regionsRepository.findById(id_regions).get();
                    regions1.setActiviter_region(regions.getActiviter_region());
                    regions1.setLangue_m_region(regions.getLangue_m_region());
                    regions1.setSuperficie_region(regions.getSuperficie_region());
                    regions1.setCoderegion(regions.getCoderegion());
                    regions1.setNomregions(regions.getNomregions());
                    regions1.setPays(regions.getPays());
                     this.regionsRepository.save(regions1);
                    ReponseMessage message = new ReponseMessage("Région modifiée avec succès !", true);
                    return message;
                }

            }

//Supprimer une region
            public ReponseMessage supprimer(Long id_region)
            {
                Optional<Regions> regions = this.regionsRepository.findById(id_region);
                if (!regions.isPresent())
                {
                    ReponseMessage message = new ReponseMessage("Région non trouvée !", false);
                    return message;
                }
                else {
                    this.regionsRepository.delete(regions.get());
                    ReponseMessage message = new ReponseMessage("Région supprimé avec succès !", true);
                    return message;
                }

            }


            public Iterable<Object[]> mesRegions() {
                return this.regionsRepository.mesRegions();
            }

            public Iterable<Object[]> mesRegionsAvecPays()
            {
                return this.regionsRepository.mesRegionsAvecPays();
            }
/*
            public Regions Generale(Regions regions)
            {

                          return regionsRepository.save(regions);
            }

 */

        }
