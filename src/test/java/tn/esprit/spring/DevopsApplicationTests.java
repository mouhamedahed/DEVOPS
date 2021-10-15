package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.IEmployeService;

@SpringBootTest
class DevopsApplicationTests {

	@Autowired
	IEmployeService serv;
	
	@Test
	void contextLoads() {
		
		
		Employe emp =new Employe(
				"ahed", "mouhamed", "mouhamed.ahed@esprit.tn",true
				);

		serv.ajouterEmploye(emp);
		emp.toString();
		serv.deleteEmployeById(emp.getId());
		 
		
	}
	
	
	

}
