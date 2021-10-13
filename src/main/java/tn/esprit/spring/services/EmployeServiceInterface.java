package tn.esprit.spring.services;

import tn.esprit.spring.entities.Employe;



public interface EmployeServiceInterface {
	public int ajouterEmploye(Employe employe);
	public String getEmployePrenomById(int employeId);
}
