package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.entities.concretes.Role;

public interface RoleService {

	Role saveRole(Role role);

	Role getByRoleName(String roleName);
}

