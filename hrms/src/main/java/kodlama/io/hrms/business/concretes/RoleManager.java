package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.RoleService;
import kodlama.io.hrms.dataAccess.abstracts.RoleDao;
import kodlama.io.hrms.entities.concretes.Role;

@Service
public class RoleManager implements RoleService{
	
	private final RoleDao roleDao;

	@Autowired
	public RoleManager(RoleDao roleDao) {
		super();
		this.roleDao = roleDao;
	}

	@Override
	public Role saveRole(Role role) {
		
		return roleDao.save(role);
	}

	@Override
	public Role getByRoleName(String roleName) {
		
		return roleDao.findByRoleName(roleName);
	}

}
