package pe.gob.minsa.kobo.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.gob.minsa.kobo.dao.KoboDataDao;
import pe.gob.minsa.kobo.model.KoboData;
import pe.gob.minsa.kobo.rowmapper.KoboDataRowMapper;

@Repository
public class KoboDataDaoImpl extends JdbcDaoSupport implements KoboDataDao {

	public KoboDataDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
		
	@Override
	public List<KoboData> listarDatosFormulario(String id_form) {
		List<KoboData> listaData = new ArrayList<KoboData>();
		String sql = "SELECT id, json FROM public.logger_instance li " + 
				"WHERE li.xform_id = "+id_form+ "ORDER BY id ";
		try {
			RowMapper<KoboData> rowData = new KoboDataRowMapper();
			listaData = getJdbcTemplate().query(sql, rowData);			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}		
		return listaData;
	}

}
