package pe.gob.minsa.kobo.service;

import java.util.List;

import pe.gob.minsa.kobo.model.KoboData;

public interface KoboDataService {
	
	public List<KoboData> listarDatosFormulario(String id_form);

}
