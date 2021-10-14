package tn.esprit.spring.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeService implements EmployeServiceInterface {
	//private static final Logger l = Logger.getLogger(EmployeService.class);
	@Autowired
	EmployeRepository empRep ;
	@Autowired
	DepartementRepository DepRep;
	@Autowired
	ContratRepository contRep ;
	@Override
	public int ajouterEmploye(Employe employe) {
		try{
			//l.info("in ajouterEmploye( )"+employe.toString());
			//l.debug("Je viens de lancer la Save. " + empRep.save(employe));	
		
		
		}catch(Exception e)
		{ 
			//l.error("Erreur dans getAllPrducts() : " + e);
			
		}
		
		return employe.getId().intValue();
	}




	@Override
	public String getEmployePrenomById(int employeId) {
		Employe e = empRep.findById(employeId);
	return	e.getPrenom() ;
	
	}


	


}
