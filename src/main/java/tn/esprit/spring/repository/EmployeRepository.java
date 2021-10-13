package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Employe;


public interface EmployeRepository extends CrudRepository<Employe,Long> {
	   @Query("SELECT COUNT(*) FROM Employe")
	    Long getNombreEmployeJPQL();
	   
	   Employe   findById(int b);
//	   @Query( "SELECT E FROM Employe  E.nom ")
//	   List<String> getAllEmployeNamesJPQL();
	  // @Query("update Employe E set E.email = :email where E.employeId = :employeId")
//	   public void mettreAjourEmailByEmployeIdJPQL(@Param("email") String email,@Param("employeId")  Long employeId);
//	   
//	   @Query("SELECT salaire FROM Timesheet E WHERE E.employeId = :employeId ")
//	   public float getSalaireByEmployeIdJPQL(@Param("employeId") Long employeId);
	   
	

}

