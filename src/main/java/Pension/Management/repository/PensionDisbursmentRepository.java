package Pension.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Pension.Management.system.model.BankDetails;

@Repository
public interface PensionDisbursmentRepository extends JpaRepository<BankDetails, Integer> {

}