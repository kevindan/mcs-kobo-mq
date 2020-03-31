package pe.gob.minsa.kobo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.minsa.kobo.dao.KoboDataDao;
import pe.gob.minsa.kobo.model.KoboData;

@Service
public class KoboDataServiceImpl implements KoboDataService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private KoboDataDao _koboDataDao;
	
	@Override
	public List<KoboData> listarDatosFormulario(String id_form) {
		List<KoboData> listaDatos = new ArrayList<KoboData>();
		try {
			listaDatos = _koboDataDao.listarDatosFormulario(id_form);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return listaDatos;
	}

}
