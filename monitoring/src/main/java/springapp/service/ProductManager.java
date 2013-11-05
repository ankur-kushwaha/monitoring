package springapp.service; 
import java.io.Serializable;
import java.util.List; 

import springapp.domain.Status;
public interface ProductManager extends Serializable{ 

	public Object getODSConsumers();

	Object getWHConsumers();

	public Object getSubArea();

	public Object routineCheckup();

	public String createQuery(String subarea);

	List<Status> getStatus();    
    
}