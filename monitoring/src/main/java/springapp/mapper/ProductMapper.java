package springapp.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springapp.domain.Status;

public class ProductMapper implements RowMapper<Status>  {
	 public Status mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Status status = new Status();
	      status.setSubarea(rs.getString("sub_area"));
	      status.setSbd(rs.getString("sbd"));
	      status.setFbd(rs.getString("fbd"));
	      status.setStatus( rs.getString("status"));
	      return status;
	   }
}
