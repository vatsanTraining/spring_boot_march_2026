package com.example.demo.impls;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LoanApplication;
import com.example.demo.repos.LoanApplicationRepository;


@Repository
//@ConditionalOnProperty(name = "storage.type", havingValue = "memory")
@Profile("dev")
public class InMemoryLoanImpl implements LoanApplicationRepository {


	private List<LoanApplication> LoanApplicationList;
	
	
	
	public InMemoryLoanImpl() {
		super();

		this.LoanApplicationList = new ArrayList<>();
	}

	@Override
	public Optional<LoanApplication> findById(int id) {
	
	return this.LoanApplicationList.stream().
			filter(e -> e.getApplicationNumber() ==id).findFirst();
	}

	@Override
	public List<LoanApplication> findAll() {
		return this.LoanApplicationList;
	}

	
	@Override
	public List<LoanApplication> findByApplicantName(String qryString) {
		
		return this.LoanApplicationList.stream().
				filter(e -> e.getApplicantName().equals(qryString)).toList();

	}

	
	@Override
	public boolean save(LoanApplication entity) {
		return this.LoanApplicationList.add(entity);
	}

}
