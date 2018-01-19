package be.vdab.restclients;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import be.vdab.exceptions.KanTemperatuurNietLezenException;

@Component
@Scope("prototype")
class OpenweathermapTemperatuurClient implements TemperatuurClient {
	private final static Logger LOGGER =
		Logger.getLogger(OpenweathermapTemperatuurClient.class.getName());
	private URI openweathermapURL;
	private final RestTemplate restTemplate;
	private final String key;
	
	OpenweathermapTemperatuurClient(@Value("${openweathermapURL}") 
		URI openweathermapURL, @Value("${openweathermapKey}")
		String key, RestTemplate restTemplate) {
		this.openweathermapURL = openweathermapURL;
		this.restTemplate = restTemplate;
		this.key = key;
	}
	
	@Override
	public BigDecimal getTemperatuur(String gemeente) {
		try {
			StringBuilder builder = new StringBuilder();
			builder.append(openweathermapURL.toString());
			builder.append("&q=" + gemeente);
			builder.append("&APPID=" + key);
			System.out.println(builder.toString());
			openweathermapURL = new URI(builder.toString());
			Weather weer = restTemplate.getForObject(openweathermapURL, Weather.class);
			return weer.getTemperature().getValue();
		}
		catch(RestClientException | URISyntaxException ex) {
			LOGGER.log(Level.SEVERE, "kan temperatuur niet lezen", ex);
			throw new KanTemperatuurNietLezenException();
		}
	}
}
