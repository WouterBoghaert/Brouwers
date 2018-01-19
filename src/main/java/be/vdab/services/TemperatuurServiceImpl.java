package be.vdab.services;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import be.vdab.restclients.TemperatuurClient;

@Service
class TemperatuurServiceImpl implements TemperatuurService {
	private final TemperatuurClient temperatuurClient;
	
	TemperatuurServiceImpl (TemperatuurClient temperatuurClient) {
		this.temperatuurClient = temperatuurClient;
	}
	
	@Override
	public BigDecimal temperatuur(String gemeente) {
		return temperatuurClient.getTemperatuur(gemeente)
			.setScale(1, RoundingMode.HALF_UP);
	}

}
