package springapp.mapper;


import java.util.List;
 








import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import springapp.domain.BusDate;
import springapp.domain.Consumers;
import springapp.domain.Contact;
import springapp.domain.Status;

 
public interface ContactMapper {
 
    final String SELECT_ALL = "SELECT * FROM feed_status";
    final String getStatus = "SELECT subject_area_code subarea, sbd.subject_bus_date sbd, fs.business_date fbd, fs.status "
			+ "FROM  `subject_business_dates` sbd "
			+ "LEFT OUTER JOIN feed_status fs ON sbd.subject_area_code = fs.sub_area";
    
    final String ODSConsumer = "select sub_area,existing,potential,source "
			+ "from fode_data_load.consumer_matix " + "where source='ODS'";
    
    final String WHConsumer = "select sub_area,existing,potential,source "
			+ "from fode_data_load.consumer_matix " + "where source='WH'";
    
    final String BusDate = "select subject_area_code subarea,subject_bus_date businessdate from fode_data_load.subject_business_dates order by subject_area_code";
    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    @Select(SELECT_ALL)
    @Results(value = {
    		@Result(property="statusd", column="status")
    		})
    List<Contact> selectAll();
    
    @Select(getStatus)
	List<Status> getStatus();
    @Select(ODSConsumer)
	List<Consumers> getODSConsumer();
	@Select(WHConsumer)
	List<Consumers> getWHConsumer();
	@Select(BusDate)
	List<BusDate> getBusDate();
    
    
}