package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.services.EmployeService;




@RestController
public class EmployeRestController {

	@Autowired EmployeService empSer ;
	
//AddEmploye http://localhost:8081/TimeSheet/servlet/add-employe
	@PostMapping("/add-employe")
	@ResponseBody
	public int addEmploye(@RequestBody Employe e){
		int emp = empSer.ajouterEmploye(e);
				return emp ;
						
				
	}


	//getPrenomEmployeByID	http://localhost:8081/TimeSheet/servlet/getPrenomEmpById/{id}
	@GetMapping("/getPrenomEmpById/{id-emp}")
	@ResponseBody
	public String getPrenomEmplById(@PathVariable("id-emp")Integer idemp){
		return empSer.getEmployePrenomById(idemp);
	}
	


}
