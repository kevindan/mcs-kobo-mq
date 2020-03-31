package pe.gob.minsa.kobo.dao;

import java.util.List;

import pe.gob.minsa.kobo.model.KoboData;

public interface KoboDataDao{

	public List<KoboData> listarDatosFormulario(String id_form) ;
	
}
