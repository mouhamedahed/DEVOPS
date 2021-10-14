package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.MissionServiceInterface;

@SpringBootTest
class DevopsApplicationTests {


	@Autowired
	MissionServiceInterface serv;
	
	@Test
	void contextLoads() {
	
	Mission miss =new Mission(
			
			"zekri aymen", "add a test "
			
			);
	
	serv.ajouterMission(miss);
	
	miss.toString();

}
	
	

}
