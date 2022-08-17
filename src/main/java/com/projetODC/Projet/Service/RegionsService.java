        package com.projetODC.Projet.Service;

        import com.projetODC.Projet.Exception.PaysNotFoundException;
        import com.projetODC.Projet.Model.Pays;
        import com.projetODC.Projet.Model.Regions;
        import com.projetODC.Projet.Repo.PaysRepository;
        import com.projetODC.Projet.Repo.RegionsRepository;
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
        public Regions ajouterRegions(Regions regions)
        {
            return regionsRepository.save(regions);
        }



//Afficher la liste des Regions
        public List<Regions> afficherRegions()
            {
                return regionsRepository.findAll();
            }

// Afficher une seule region
            public Optional<Regions> afficherUneRegion(Long id_regions)
            {
                Optional<Regions> regions = this.regionsRepository.findById(id_regions);

                if (!regions.isPresent()) {
                    throw new PaysNotFoundException(String.format("Le pays avec id %s n'est pas trouvé"+id_regions));
                }
                return this.regionsRepository.findById(id_regions);
            }
 //Modifier un pays
            public Regions modifierRegions(Regions regions, Long id_regions)
            {
                Optional<Regions> regionExistePays = this.regionsRepository.findById(id_regions);
                if (!regionExistePays.isPresent())
                {
                    throw new PaysNotFoundException(String.format("Le pays avec id %s n'est pas trouvé"+id_regions));
                }
                return this.regionsRepository.save(regions);
            }


//Supprimer une region
            public void supprimer(Long id_region)
            {
                Optional<Regions> regions = this.regionsRepository.findById(id_region);
                if (!regions.isPresent())
                {
                    throw new PaysNotFoundException(String.format("Le pays avec id %s n'est pas trouvé"+id_region));
                }
                this.regionsRepository.delete(regions.get());
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
