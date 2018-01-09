package be.vdab.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;

@Repository
class InMemoryBrouwerRepository implements BrouwerRepository {
	private final Map<Long, Brouwer> brouwers = new ConcurrentHashMap<>();
	
	InMemoryBrouwerRepository() {
		brouwers.put(1L, new Brouwer(1L, "Struise Brouwers", 50000000, 
			new Adres("Struisstraat", "200", 1000, "Brussel")));
		brouwers.put(2L, new Brouwer(2L, "Delirium", 200000000, 
				new Adres("Overzeelse Steenweg", "2", 9090, "Melle")));
		brouwers.put(3L, new Brouwer(3L, "Cantillon", 5300000, 
				new Adres("Rue De Gueuze", "58", 1000, "Brussel")));
		brouwers.put(4L, new Brouwer(4L, "Brasseries d'Orval", 12000000, 
				new Adres("Rue Des Péres", "3", 7890, "Orval")));
	}
	
	@Override
	public void create(Brouwer brouwer) {
		brouwer.setBrouwerNr(Collections.max(brouwers.keySet()) + 1);
		brouwers.put(brouwer.getBrouwerNr(), brouwer);
	}

	@Override
	public List<Brouwer> findAll() {
		return new ArrayList<> (brouwers.values());
	}

	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		/*return brouwers.values().stream().filter(brouwer -> brouwer.getNaam().contains(beginNaam))
			.collect(Collectors.toList());*/
		beginNaam = beginNaam.toUpperCase();
		List<Brouwer> resultaat = new ArrayList<>();
		for(Brouwer brouwer: brouwers.values()) {
			if(brouwer.getNaam().toUpperCase().startsWith(beginNaam)) {
				resultaat.add(brouwer);
			}
		}
		return resultaat;
	}

}
