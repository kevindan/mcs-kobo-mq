package pe.gob.minsa.kobo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.gob.minsa.kobo.model.KoboData;

public class KoboDataRowMapper implements RowMapper<KoboData>{

	@Override
	public KoboData mapRow(ResultSet rs, int rowNum) throws SQLException {
		KoboData koboData = new KoboData();
		koboData.setId(rs.getString("id"));
		koboData.setData(rs.getString("json"));
		return koboData;
	}
	
}
