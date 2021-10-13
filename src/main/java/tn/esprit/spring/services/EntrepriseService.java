package tn.esprit.spring.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseService implements EntrepriseServiceInterface  {
	
	@Autowired
	EntrepriseRepository repEntre ;
	@Autowired
	DepartementRepository DepRep ;
	@Override
	public int ajouterEntreprise(Entreprise entre) {
		repEntre.save(entre);
		return entre.getId().intValue();
	}
	
	@Override
	public int ajouterDepartement(Departement dep) {
			DepRep.save(dep);
			return dep.getId().intValue();
	}
	
	@Override
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
			
			Departement dep =DepRep.findById(depId);
			Entreprise entreprise =repEntre.findById(entrepriseId);
			dep.setEntreprise(entreprise);
			DepRep.save(dep);		
		}



}
