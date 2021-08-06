package kodlama.io.hrms.core.concretes;

import java.rmi.RemoteException;
import java.util.Locale;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.abstracts.MernisService;
import kodlama.io.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAdapter implements MernisService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {

		KPSPublicSoapProxy client = new KPSPublicSoapProxy();

		boolean result = true;

		try {

			result = client.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalityId()),
					candidate.getFirstName().toUpperCase(new Locale("tr")),
					candidate.getLastName().toUpperCase(new Locale("tr")), candidate.getBirthYear());

		} catch (RemoteException e) {

			e.printStackTrace();
		}

		return result;
	}

}
