package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;

@SpringBootTest
class DevopsApplicationTests {

	@Autowired
	IEntrepriseService serv;
	
	@Test
	void contextLoads() {
		
		
		Entreprise entrep =new Entreprise(
				
			"esprit","facebook"
				
				);
		
		serv.ajouterEntreprise(entrep);
		serv.deleteEntrepriseById(entrep.getId());
		
		entrep.toString();
		
		
	}
	
	
	

}
