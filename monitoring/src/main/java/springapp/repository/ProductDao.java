package springapp.repository; 
import java.util.List; 

import org.springframework.stereotype.Component;

import springapp.domain.MktData;
import springapp.domain.Status;
import springapp.domain.Consumers;
import springapp.domain.BusDate;
@Component
public interface ProductDao { 
    public List<Status> getStatus();

	public List<Consumers> getODSConsumers();

	public List<Consumers> getWHConsumers(); 

	public List<BusDate> getBusDate();
}