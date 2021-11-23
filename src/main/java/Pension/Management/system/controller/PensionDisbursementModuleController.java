package Pension.Management.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PensionDisbursementModuleController {

	private static Logger logger = LoggerFactory.getLogger(PensionDisbursementModuleController.class);
	@Autowired
	private PensionDisbursementService pensionDisbursementService;
	
}
