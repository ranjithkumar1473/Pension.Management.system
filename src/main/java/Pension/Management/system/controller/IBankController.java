package Pension.Management.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import Pension.Management.system.model.BankDetails;
import Pension.Management.system.service.IBankService;

@RestController
public class IBankController {

	private static final Logger LOG = LoggerFactory.getLogger(IBankController.class);
	
	@Autowired
	private IBankService bankService;

	@PostMapping("/addbank")
	public ResponseEntity<BankDetails> addBank(@RequestBody BankDetails bankDetails ){
		LOG.info("AddingBank");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "bank added successfully.");
		return new ResponseEntity<BankDetails>(bankService.addBank(bankDetails), HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/deleteBank")
	public void deleteBank(@PathVariable long  accno) {
		LOG.info("DeleteBank");
		 bankService.deleteBank(accno);
		
	}
}
