package Pension.Management.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Pension.Management.system.service.*;
import io.swagger.annotations.ApiOperation;
@RestController
public class PensionDisbursementModuleController {

	private static Logger logger = LoggerFactory.getLogger(PensionDisbursementModuleController.class);
	
	@Autowired
	private PensionDisbursmentService pensionDisbursementService;
	
	private static final Logger LOG = LoggerFactory.getLogger(PensionDisbursementModuleController.class);
	@PostMapping("/getServiceCharge")
	@ApiOperation(value="Provides the bank service charge")
	public double getBankServiceCharge(@RequestBody String bankName) {
		logger.info("START");
		logger.info("END");
		try {
			return PensionDisbursmentService.getBankServiceCharge(bankName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		

	}
}
