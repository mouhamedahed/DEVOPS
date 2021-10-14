package tn.esprit.spring.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;

@Service
public class MissionService implements MissionServiceInterface{
	private static final Logger l = Logger.getLogger(EmployeService.class);

@Autowired

MissionRepository rep;
	@Override
	public int ajouterMission(Mission m) {
		// TODO Auto-generated method stub
	
		try{
			l.info("in ajouterMission( )"+m.toString());
			l.debug("Je viens de lancer la Save. " + 	rep.save(m));	
		
		
		}catch(Exception e)
		{ 
			l.error("Erreur dans ajouterMission() : " + e);
			
		}
		return 0;
	}}
