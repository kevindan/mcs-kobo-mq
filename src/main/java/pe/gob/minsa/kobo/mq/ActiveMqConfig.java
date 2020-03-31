package pe.gob.minsa.kobo.mq;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import pe.gob.minsa.kobo.config.PropertiesBean;

@Configuration
@EnableJms
public class ActiveMqConfig {

	@Autowired
	private PropertiesBean propertiesBean;
		
	@Bean
	public Queue queue() {
		return new ActiveMQQueue(propertiesBean.getCola());
	}

	@Bean
	public ActiveMQConnectionFactory connectionFatory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL(propertiesBean.getBroker_url());
		return factory;
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(connectionFatory());
	}

}
