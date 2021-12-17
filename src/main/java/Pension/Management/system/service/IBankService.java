package Pension.Management.system.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Pension.Management.repository.IBankRepository;
import Pension.Management.system.model.BankDetails;

@Service
public class IBankService {
	
	private static final Logger LOG = LoggerFactory.getLogger(IBankService.class);

	@Autowired
	private IBankRepository bankRepository;

	public BankDetails addBank(BankDetails bankDetails) {
		LOG.info("Service addBank");
		if(bankRepository.findById(bankDetails.getAccno()))
		return bankRepository.save(bankDetails);
		LOG.info(bankDetails.getAccno()+"Already Exist");
		return null;
	}
	
	public void deleteBank(long accno) {
		LOG.info("Service DeleteBank");
		if(bankRepository.findById(accno)) {
			bankRepository.deleteById(accno);
		}else
	      LOG.info("Bank details not exist");
				
	}
	
}
