package kodlama.io.hrms.dataAccess.abstracts;


import kodlama.io.hrms.entities.concretes.Employer;

public interface EmployerDao extends UserDao <Employer>{
	
	Employer findById(int id);

	
}
