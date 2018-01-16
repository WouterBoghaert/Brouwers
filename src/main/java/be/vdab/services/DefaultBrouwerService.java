package be.vdab.services;

import java.util.List;

import be.vdab.entities.Brouwer;
import be.vdab.repositories.BrouwerRepository;

@ReadOnlyTransactionalService
class DefaultBrouwerService implements BrouwerService {
	private final BrouwerRepository brouwerRepository;
	
	DefaultBrouwerService(BrouwerRepository brouwerRepository) {
		this.brouwerRepository = brouwerRepository;
	}
	
	@Override
	@ModifyingTransactionalServiceMethod
	public void create(Brouwer brouwer) {
		brouwerRepository.create(brouwer);
	}

	@Override
	public List<Brouwer> findAll() {
		return brouwerRepository.findAll();
	}

	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		return brouwerRepository.findByNaam(beginNaam);
	}

}
