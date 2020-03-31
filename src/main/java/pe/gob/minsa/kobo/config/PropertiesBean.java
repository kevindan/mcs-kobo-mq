package pe.gob.minsa.kobo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value= {"classpath:mcs-kobo-mq.properties"})
public class PropertiesBean {
  
	@Value("${spring.activemq.broker-url}")
	private String broker_url;
	
	@Value("${spring.activemq.queue}")
	private String cola;

	public PropertiesBean() {
		
	}

	public PropertiesBean(String broker_url, String cola) {	
		this.broker_url = broker_url;
		this.cola = cola;
	}

	public String getBroker_url() {
		return broker_url;
	}

	public void setBroker_url(String broker_url) {
		this.broker_url = broker_url;
	}

	public String getCola() {
		return cola;
	}

	public void setCola(String cola) {
		this.cola = cola;
	}

	@Override
	public String toString() {
		return "PropertiesBean [broker_url=" + broker_url + ", cola=" + cola + "]";
	}
	
}
