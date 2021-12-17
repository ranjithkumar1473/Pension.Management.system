package Pension.Management.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Pension.Management.system.model.BankDetails;

import Pension.Management.system.service.IUserService;

@RestController
public class IUserController {

private static final Logger LOG = LoggerFactory.getLogger(IBankController.class);
	
	@Autowired
	private IUserService userService;

	@PostMapping("/adduser")
	public ResponseEntity<AddUser> addUser(@RequestBody AddUser addUser ){
		LOG.info("AddingUser");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "user added successfully.");
		return new ResponseEntity<BankDetails>(userService.addBank(addUser), HttpStatus.CREATED);
		
	}
}
