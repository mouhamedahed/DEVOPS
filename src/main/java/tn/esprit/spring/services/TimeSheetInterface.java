package tn.esprit.spring.services;

import java.util.Date;

import tn.esprit.spring.entities.Mission;

public interface TimeSheetInterface {
	public int ajouterMission(Mission mission);
	public void affecterMissionADepartement(int missionId, int depId);
	public void ajouterTimesheet(long missionId, long employeId, Date
	dateDebut, Date dateFin);
}
