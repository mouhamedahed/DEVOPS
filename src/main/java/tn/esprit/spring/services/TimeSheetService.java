package tn.esprit.spring.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.entities.TimesheetPK;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.TimesheetRepository;
@Service
public class TimeSheetService implements TimeSheetInterface  {
	@Autowired
	TimesheetRepository tsRep ;
	@Autowired
	MissionRepository missRep ;
	@Autowired
	DepartementRepository depRep ;
	@Override
	public int ajouterMission(Mission mission) {
	
		return 5;
	}

	@Override
	public void affecterMissionADepartement(int missionId, int depId) {
		Mission miss = missRep.findById(missionId);
		Departement dep = depRep.findById(depId);
		miss.setDepartement(dep);
		missRep.save(miss);
		
	}

	@Override
	public void ajouterTimesheet(long missionId, long employeId, Date dateDebut, Date dateFin) {
		TimesheetPK p = new TimesheetPK(employeId,missionId,dateDebut,dateFin);
		Timesheet ts = new Timesheet();
		tsRep.save(ts);
	}

}
