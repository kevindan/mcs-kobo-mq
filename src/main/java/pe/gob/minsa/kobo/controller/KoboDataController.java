package pe.gob.minsa.kobo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import pe.gob.minsa.kobo.model.KoboData;
import pe.gob.minsa.kobo.service.KoboDataService;

@RestController
@RequestMapping("/servicio/v0.0.1")
@Api(tags = { "Servicio para el envío de datos de Kobo al ACTIVE MQ" })
@SwaggerDefinition(tags = {
		@Tag(name = "Envío de datos de Kobo al ACTIVE MQ", description = "Operaciones par el envío de datos de Kobo al ACTIVE MQ") })
public class KoboDataController {

	@Autowired
	private KoboDataService _koboDataService;
	
	@Autowired
	private Queue queue;
	
	@Autowired
	private JmsTemplate _jmsTemplate;
	
	@GetMapping(value = "/listar-datos-formulario/{id_form}", produces = "text/plain; charset=utf-8")
	public String listarDatosFormualrio(@PathVariable ("id_form") String id_form) {
		String mensaje = null;
		List<KoboData> listaDatos = new ArrayList<KoboData>();
		listaDatos = _koboDataService.listarDatosFormulario(id_form);
		ObjectMapper mapper = new ObjectMapper();
		try {
			int i = 0;
			for (KoboData koboData : listaDatos) {				
				String json = mapper.writeValueAsString(koboData);						
				_jmsTemplate.convertAndSend(queue, json);
				i = i +1;
				System.out.println("==> Número de registro enviado al servidor de cola: "+(i));
			}
			mensaje = ":: Elementos enviados a ACTIVE MQ satisfactoriamente ::";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mensaje;
	}

}
