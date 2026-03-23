package com.example.demo.repos;
import com.example.demo.model.*;
import java.util.List;
import java.util.Optional;


public interface LoanApplicationRepository {

	List<LoanApplication> findByApplicantName(String qryString);

	List<LoanApplication> findAll();

	Optional<LoanApplication> findById(int id);

	boolean save(LoanApplication entity);
	
	
	
}
