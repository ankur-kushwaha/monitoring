package springapp.service; 
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springapp.domain.Consumers;
import springapp.domain.Contact;
import springapp.domain.Status;
import springapp.domain.BusDate;
import springapp.repository.ContactDAO;

@Component
public class SimpleProductManager implements ProductManager { 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private List<Product> products;   
	
	@Autowired
	private ContactDAO contactDao;

	private SimpleDateFormat sdf;

	private String date;
	
	@Override
	public List<Status> getStatus() {
        //return products;
    	 List<Status> prod= contactDao.getStatus();
    	 return prod;
    }

	@Override
	public Object getODSConsumers() {
		// TODO Auto-generated method stub
		List<Consumers> consumers=contactDao.getODSConsumers();
		return consumers;
	}
	@Override
	public Object getWHConsumers() {
		// TODO Auto-generated method stub
		List<Consumers> consumers=contactDao.getWHConsumers();
		return consumers;
	}


	@Override
	public Object routineCheckup() {
		// TODO Auto-generated method stub
		sdf = new SimpleDateFormat("yyyy-MM-dd");
        date = sdf.format(new Date());
		List<BusDate> routine=contactDao.getBusDate();
		for (BusDate busDate : routine) {
			String bd = busDate.getBusinessDate();
            busDate.setExpectedBusDate(bd.compareTo(date) + "");
		}
		return routine;
	}

	@Override
	public String createQuery(String subarea) {
		// TODO Auto-generated method stub
		subarea=subarea.trim();
		String bd="";
		String nbd="";
		String pbd="";
		String query="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		if(subarea.equals("FLSBCS")||subarea.equals("FMSBCS")){
			
		}else if(subarea.equals("INDX_GPR")||subarea.equals("INDX_HSBC")){
			c.add(Calendar.DATE, -2);
		}
		else{
			c.add(Calendar.DATE, -1);
		}
		bd=sdf.format(c.getTime());
		c.add(Calendar.DATE, -1);
		pbd=sdf.format(c.getTime());
		c.add(Calendar.DATE,2);
		nbd=sdf.format(c.getTime());
		
		query="update fode_data_load.subject_business_dates  <br>"
				+ "set subject_bus_date='"+bd+"',"
				+ "subject_nxt_date='"+nbd+"', "
				+ "subject_prv_date='"+pbd+"'  <br>"
				+ "where subject_area_code='"+subarea+"';";
		return query;
	}

	@Override
	public List<Contact> dotest() {
		// TODO Auto-generated method stub
		List<Contact> contact=contactDao.selectAll();
		return contact;
	}
}