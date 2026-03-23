package com.example.demo.impls;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LoanApplication;
import com.example.demo.repos.LoanApplicationRepository;

@Repository
//@Primary
@ConditionalOnProperty(name = "storage.medium", havingValue = "file")
//@Profile("prod")
public class TextFileLoanImpl implements LoanApplicationRepository {


	
	
	
	public TextFileLoanImpl() {
		super();

	}

	@Override
	public Optional<LoanApplication> findById(int id) {
		return Optional.empty();
		}

	@Override
	public List<LoanApplication> findAll() {
		
		return readFromFile(line -> true);
		}

	
	@Override
	public List<LoanApplication> findByApplicantName(String qryString) {
		
	  return readFromFile(lines -> lines.contains(qryString));
	  
	}

	
	@Override
	public boolean save(LoanApplication entity)  {
		
		Path path = Paths.get("loan-apps.txt");
		
		if(Files.notExists(path)) {
        try {
			Files.createFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		boolean result=false;
		
		
		try (BufferedWriter buffer = Files.newBufferedWriter
				(path,StandardCharsets.UTF_8,
				    StandardOpenOption.APPEND );
				
				PrintWriter writer = new PrintWriter(buffer);
				
				){
			
			      writer.println(entity);
			      
			      result =true;
			      
				} catch (IOException e) {
			      e.printStackTrace();
		}
		
		return result;
	}

	
	private  Optional<LoanApplication> mapToObject(String line) {
	   
	    try {
	        String[] values = line.split(",");
	        String id = values[0];
		    String name = values[1];
		    String amount = values[2];
		    String pan = values[3];
		    
		    int applicationNumber = Integer.parseInt(id);
		    
		    double loanAmount = Double.parseDouble(amount);
		    
		    LoanApplication loan = new LoanApplication(applicationNumber,name,loanAmount,pan);
			        return Optional.of(loan);
			        
	    } catch (Exception e) {
	    	
	    	System.out.println(e.getMessage());
	        return Optional.empty(); 
	        
	    }
	
	}
	
	
	private List<LoanApplication> readFromFile(Predicate<String> filter) {
		
	    List<LoanApplication> response = Collections.emptyList();

	    try (Stream<String> lines = Files.lines(Paths.get("loan-apps.txt"))) {
	        response = lines
	            .filter(filter)
	            .map(this::mapToObject)
	            .flatMap(Optional::stream).toList();
	            
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return response;
	}
	
}
