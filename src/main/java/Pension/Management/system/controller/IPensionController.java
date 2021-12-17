package Pension.Management.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import 
import Pension.Management.system.model.PensionDetails;
import Pension.Management.system.service.IPensionService;

@RestController
public class IPensionController {
	
	private static final Logger LOG = LoggerFactory.getLogger(IPensionController.class);

	@Autowired
	private IPensionService pensionService;

	@PostMapping("/addpension")
	public ResponseEntity<PensionDetails> addPension(@RequestBody PensionDetails pensionDetails){
		LOG.info("Adding pension Details");
		
		return pensionService.addPensionDetails(pensionDetails);
		
	}
	
	@PutMapping("/updateemp")
	public ResponseEntity<PensionDetails> updatepension(@RequestBody  PensionDetails pensionDetails ){
		LOG.info("update pension");
		return pensionService.updatePensionDetails(pensionDetails);
				
	}
	
	@GetMapping("/getpensiondetailsbyid/{pensionid}")
	public ResponseEntity<PensionDetails> viewPension(@PathVariable (name = "pensionid") int pensionid){
		LOG.info("get pension details");
		return pensionService.viewPensionDetails(pensionid);
		
	}
	
	@DeleteMapping("/deletepensionbyid/{pensionid}")
	public ResponseEntity<PensionDetails> deletePension(@PathVariable int pensionid){
		LOG.info("Delete pension");
		return pensionService.deletePensionDetails(pensionid);
		
	}
}
