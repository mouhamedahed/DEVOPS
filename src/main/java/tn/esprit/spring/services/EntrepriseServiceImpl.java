package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	private static final Logger l = Logger.getLogger(EntrepriseServiceImpl.class);

	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	
	public int ajouterEntreprise(Entreprise entreprise) {
	
			try{
				l.info("in ajouterEntreprise( )"+entreprise.toString());
				l.debug("Je viens de lancer la Save. " + entrepriseRepoistory.save(entreprise));	
			
			
			}catch(Exception e)
			{ 
				l.error("Erreur dans ajouterEntreprise() : " + e);
				
			}

		return entreprise.getId();
	}

	public int ajouterDepartement(Departement dep) {
		deptRepoistory.save(dep);
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter l'entreprise a departement 
				// ==> c'est l'objet departement(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
				Optional<Entreprise> optionalentreprise = entrepriseRepoistory.findById(entrepriseId);
				Optional<Departement> optionaldep = deptRepoistory.findById(depId);
				try {
				if(optionalentreprise.isPresent() && optionaldep.isPresent())
				{
					Departement depManagedEntity = optionaldep.get();
					l.info("in affecterDepartementAEntreprise if  depManagedEntity:"+depManagedEntity.toString());

					
					Entreprise entrepriseManagedEntity = optionalentreprise.get();
					l.info("in affecterDepartementAEntreprise if entrepriseManagedEntity:"+entrepriseManagedEntity.toString());

				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				deptRepoistory.save(depManagedEntity);
				l.debug("Je viens de lancer la Save. "+deptRepoistory.save(depManagedEntity));
				}
				} catch (Exception e) {
					l.error("Erreur dans affecterDepartementAEntreprise() : " + e);

				}
	}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		Optional<Entreprise> optionalentreprise = entrepriseRepoistory.findById(entrepriseId);
		
		
		List<String> depNames = new ArrayList<>();

		if( optionalentreprise.isPresent() )
		{
			
			Entreprise entrepriseManagedEntity = optionalentreprise.get();
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
		}
		
		}
		
		
		
		return depNames;
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		
		
		Optional<Entreprise> optionalentreprise =entrepriseRepoistory.findById(entrepriseId);
		try{
		if(optionalentreprise.isPresent())
		{
		Entreprise entrepriseManagedEntity = optionalentreprise.get();
		l.info("in affecterDepartementAEntreprise if  depManagedEntity:"+entrepriseManagedEntity.toString());

		entrepriseRepoistory.delete(entrepriseManagedEntity);	
		}
		}
		catch (Exception e) {
			l.error("Erreur dans affecterDepartementAEntreprise() : " + e);
		
	}
	}
	@Transactional
	public void deleteDepartementById(int depId) {
		Optional<Departement> optionaldepartement = deptRepoistory.findById(depId);
		try{
		if(optionaldepartement.isPresent())
		{
			Departement departementManagedEntity = optionaldepartement.get();
			l.info("in affecterDepartementAEntreprise if  depManagedEntity:"+departementManagedEntity.toString());

		deptRepoistory.delete(departementManagedEntity);	
		}
		}
		catch (Exception e) {
			l.error("Erreur dans affecterDepartementAEntreprise() : " + e);
		}
	}
	

	public Entreprise getEntrepriseById(int entrepriseId) {
		Optional<Entreprise> optionalentreprise =entrepriseRepoistory.findById(entrepriseId);
		Entreprise entrepriseManagedEntity=new Entreprise();
		
		if(optionalentreprise.isPresent())
		{
			 entrepriseManagedEntity = optionalentreprise.get();
			
		}
		
		return entrepriseManagedEntity ;	
	}

}
