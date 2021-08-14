package kodlama.io.hrms.api.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import kodlama.io.hrms.business.abstracts.RoleService;
import kodlama.io.hrms.entities.concretes.Role;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

	
	private final RoleService roleService;

	@Autowired
	public RolesController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@PostMapping("/saveRole")
	public ResponseEntity<?> saveRole(@RequestBody Role role){
		
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/roles/saveRole").toUriString());
		
		return ResponseEntity.created(uri).body(roleService.saveRole(role));
		
	}

}
