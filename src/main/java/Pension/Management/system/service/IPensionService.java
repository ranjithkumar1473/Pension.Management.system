package Pension.Management.system.service;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.exception.EmployeeNotFoundException;
import com.cg.spring.boot.demo.model.Employee;

import Pension.Management.repository.IPensionRepository;
import Pension.Management.system.exception.PensionDetailsNotFoundException;
import Pension.Management.system.model.PensionDetails;
import Pension.Management.system.service.*;

@Service
public class IPensionService {

	private static final Logger LOG = LoggerFactory.getLogger(IPensionService.class);
	@Autowired
	private IPensionRepository pensionRepository;
	
	public ResponseEntity<PensionDetails> addPensionDetails(PensionDetails pensionDetails) {
		
		LOG.info("Service Addpension");
		if (!pensionRepository.existsById(pensionDetails.getDid()))
			return pensionRepository.save(pensionDetails);
		System.out.println(pensionDetails.getDid() + " already exists.");
		return null;
	}
	
	public ResponseEntity<PensionDetails> updatePensionDetails(PensionDetails pensionDetails) {
		LOG.info("Service update");
		if (pensionRepository.existsById(pensionDetails.getEid()))

			return pensionRepository.save(pensionDetails);
		LOG.info(pensionDetails.getEid() + " does not exist.");
		return null;
	}
	
	public ResponseEntity<PensionDetails> viewPensionDetails(int pensionerId) {
		LOG.info("Service View pension details");
		Optional<PensionDetails> empOpt = pensionRepository.findById(pensionerId);
		if(empOpt.isPresent()) {
			LOG.info("pension deatils present");
			return empOpt.get();
		} else {
			LOG.info("pension details is NOT available.");
			throw new PensionDetailsNotFoundException(pensionerId + " this employee is not found.");
		}
	}
	public ResponseEntity<PensionDetails> deletePensionDetails(int pensionerId) {
		LOG.info("service delete pension details");
		Optional<PensionDetails> empOpt = pensionRepository.findById(pensionerId);
		if (empOpt.isPresent()) {
			pensionRepository.deleteById(pensionerId);
			return empOpt.get();
		} else {
			throw new PensionDetailsNotFoundException(pensionerId + " this employee does not exist.");
		}
	}
}

