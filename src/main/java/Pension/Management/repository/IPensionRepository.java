package Pension.Management.repository;


	public interface IPensionRepository {
		public PensionDetails addPensionDetails(PensionDetails pensionDetails);
		public PensionDetails updatePensionDetails(PensionDetails pensionDetails);
		public PensionDetails viewPensionDetails(PensionDetails pensionDetails);
		public void deletePensionDetails(int pensionerId);
	}

