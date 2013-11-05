package springapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springapp.domain.Consumers;

public class ConsumerMapper implements RowMapper<Consumers> {
	
	@Override
	public Consumers mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Consumers consumers = new Consumers();
		consumers.setExisting(rs.getString("existing"));
		consumers.setPotential(rs.getString("potential"));
		consumers.setSource(rs.getString("source"));
		consumers.setSub_area(rs.getString("sub_area"));
		return consumers;
	}

}
