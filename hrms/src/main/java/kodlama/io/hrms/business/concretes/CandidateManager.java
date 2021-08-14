package kodlama.io.hrms.business.concretes;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CandidateService;
import kodlama.io.hrms.business.abstracts.RoleService;
import kodlama.io.hrms.business.auth.CandidateValidationService;
import kodlama.io.hrms.core.concretes.BusinessRules;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CandidateDao;
import kodlama.io.hrms.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.entities.concretes.Candidate;
import kodlama.io.hrms.entities.concretes.Role;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CandidateManager extends UserManager<Candidate> implements CandidateService {

	private final CandidateDao candidateDao;
	private final CandidateValidationService candidateValidationService;
	private final RoleService roleService;
	private final PasswordEncoder passwordEncoder;


	@Autowired
	public CandidateManager(UserDao<Candidate> userDao, RoleService roleService, PasswordEncoder passwordEncoder,
			CandidateDao candidateDao, CandidateValidationService candidateValidationService) {
		super(userDao, roleService, passwordEncoder);
		this.candidateDao = candidateDao;
		this.candidateValidationService = candidateValidationService;
		this.roleService = roleService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Result add(Candidate candidate) {

		Result result = BusinessRules.Run(this.candidateValidationService.validateCandidate(candidate),
				nationalityIdExist(candidate.getNationalityId()), super.isEmailExist(candidate.getEmail()));

		if (!result.isSuccess()) {

			if (fakemernisValidate(candidate)) {

				if (!emailValidate(candidate).isSuccess()) {

				}

				return result;
			}
			return new ErrorResult("Mernis hatası");
		}
		log.info("Kullanıcı {} database'e eklendi", candidate.getId());
		candidate.setPassword(passwordEncoder.encode(candidate.getPassword()));
		return new SuccessDataResult<>(this.candidateDao.save(candidate), "İş arayan eklendi");

	}

	private Result nationalityIdExist(String nationalityId) {

		if (candidateDao.findByNationalityId(nationalityId).isPresent()) {

			return new ErrorResult("Bu kimlik numarası kullanılıyor");
		}
		return new SuccessResult();
	}

//sahte servisle
	private boolean fakemernisValidate(Candidate candidate) {

		return true;
	}

	private Result emailValidate(Candidate candidate) {

		return new SuccessResult();
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		Candidate candidate = candidateDao.getById(id);
		return new SuccessDataResult<>(candidate);
	}

	@Override
	public void addRoleToUser(String email, String roleName) {

		log.info("İş arayana {} rol {} eklendi", email, roleName);

		Role role = roleService.getByRoleName(roleName);
		Candidate candidate = candidateDao.getByEmail(email);

		candidate.getRoles().add(role);

	}
}
