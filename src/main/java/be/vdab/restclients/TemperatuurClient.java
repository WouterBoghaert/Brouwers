package be.vdab.restclients;

import java.math.BigDecimal;

public interface TemperatuurClient {
	BigDecimal getTemperatuur(String gemeente);
}
