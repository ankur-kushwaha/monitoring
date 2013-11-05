package springapp.service; 
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springapp.domain.Consumers;
import springapp.domain.Status;
import springapp.domain.BusDate;
import springapp.repository.ProductDao;

@Component
public class SimpleProductManager implements ProductManager { 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private List<Product> products;   
	@Autowired
	private ProductDao productDao; 
	@Override
	public List<Status> getStatus() {
        //return products;
    	 List<Status> prod= productDao.getStatus();
    	 return prod;
    }

	@Override
	public Object getODSConsumers() {
		// TODO Auto-generated method stub
		List<Consumers> consumers=productDao.getODSConsumers();
		return consumers;
	}
	@Override
	public Object getWHConsumers() {
		// TODO Auto-generated method stub
		List<Consumers> consumers=productDao.getWHConsumers();
		return consumers;
	}

	@Override
	public Object getSubArea() {
		// TODO Auto-generated method stub
		List<Consumers> consumers=productDao.getWHConsumers();
		return consumers;
	}

	@Override
	public Object routineCheckup() {
		// TODO Auto-generated method stub
		List<BusDate> routine=productDao.getBusDate();
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
		
		query="update fode_data_load.subject_business_date  <br>"
				+ "set business_date='"+bd+"',"
				+ "next_business_date='"+nbd+"', "
				+ "previous_business_date='"+pbd+"'  <br>"
				+ "where sub_area='"+subarea+"';";
		return query;
	}
}