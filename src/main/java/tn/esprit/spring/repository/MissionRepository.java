package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Mission;

public interface MissionRepository extends CrudRepository<Mission,Long>{
	Mission findById(int b);
}
