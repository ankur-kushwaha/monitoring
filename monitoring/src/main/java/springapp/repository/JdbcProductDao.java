package springapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import springapp.domain.Consumers;
import springapp.domain.MktData;
import springapp.domain.Status;
import springapp.domain.BusDate;
import springapp.mapper.ConsumerMapper;
import springapp.mapper.ProductMapper;

@Component
public class JdbcProductDao implements ProductDao {
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	@Resource(name = "qa2")
	private DataSource qa2;
	@Resource(name = "sit")
	private DataSource sit;
	private JdbcTemplate jdbcTemplateObject;
	private SimpleDateFormat sdf;
	private String date;

	public DataSource getDataSource() {
		return qa2;
	}

	public void setDataSource(DataSource dataSource) {
		this.qa2 = dataSource;
	}

	@PostConstruct
	public void afterprocess() {
		jdbcTemplateObject = new JdbcTemplate(qa2);
	}

	public List<Status> getStatus() {
		logger.info("Getting status!");
		String SQL = "SELECT sub_area, sbd.business_date sbd, fs.business_date fbd, fs.status "
				+ "FROM  `subject_business_date` sbd "
				+ "LEFT OUTER JOIN feed_status fs ON sbd.sub_area = fs.subject_area";
		List<Status> products = jdbcTemplateObject.query(SQL,
				new ProductMapper());
		return products;
	}

	@Override
	public List<Consumers> getODSConsumers() {
		// TODO Auto-generated method stub
		logger.info("Getting ODSConsumers from database!");
		String SQL = "select sub_area,existing,potential,source "
				+ "from fode_data_load.consumer_matix " + "where source='ODS'";
		List<Consumers> consumers = jdbcTemplateObject.query(SQL,
				new ConsumerMapper());
		return consumers;
	}

	@Override
	public List<Consumers> getWHConsumers() {
		// TODO Auto-generated method stub
		logger.info("Getting WHConsumers from database!");
		String SQL = "select sub_area,existing,potential,source "
				+ "from fode_data_load.consumer_matix " + "where source='WH'";
		List<Consumers> consumers = jdbcTemplateObject.query(SQL,
				new ConsumerMapper());
		return consumers;
	}

	@Override
	public List<BusDate> getBusDate() {
		// TODO Auto-generated method stub
		logger.info("Getting Business_date from database!");
		String SQL = "select sub_area,business_date from fode_data_load.subject_business_date order by sub_area";
		List<BusDate> busdate = jdbcTemplateObject.query(SQL,
				new RowMapper<BusDate>() {
					@Override
					public BusDate mapRow(ResultSet rs, int arg1)
							throws SQLException {
						// TODO Auto-generated method stub
						BusDate routine = new BusDate();
						routine.setSubArea(rs.getString("sub_area"));
						String bd = rs.getString("business_date");
						routine.setBusinessDate(bd);
						routine.setExpectedBusDate(bd.compareTo(date) + "");
						return routine;
					}
				});
		return busdate;
	}

	@PostConstruct
	public void init() {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		date = sdf.format(new Date());
	}
}