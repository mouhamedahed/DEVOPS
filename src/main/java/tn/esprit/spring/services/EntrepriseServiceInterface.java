package tn.esprit.spring.services;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;

public interface EntrepriseServiceInterface {
		public int ajouterEntreprise(Entreprise entreprise);
		public int ajouterDepartement(Departement dep);
		void affecterDepartementAEntreprise(int depId, int entrepriseId);
}
