package Pension.Management.system.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pension.Management.repository.IBankRepository;
import Pension.Management.repository.IPensionRepository;

@Service
public class PensionDisbursmentService {
	private static Logger logger = LoggerFactory.getLogger(PensionDisbursmentService.class);

	@Autowired
	IPensionRepository iPensionerRepository;
	
	@Autowired
	IBankRepository iBankRepository;
	private static final Map<String, Double> banks = createMap();
	
	private static Map<String, Double> createMap() {
		logger.info("START");

		Map<String, Double> tempBanks = new HashMap<>();
		tempBanks.put("SBI", 500.0);
		tempBanks.put("IOB", 500.0);
		tempBanks.put("AXIS", 550.0);
		tempBanks.put("DBS", 550.0);
		logger.info("END");

		return tempBanks;
	}

	
	public static double getBankServiceCharge(String bankName) {
		if (banks.containsKey(bankName.toUpperCase()))
			return banks.get(bankName.toUpperCase());
		else
			return 0;
	}
	

	
}
