
package springapp.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import springapp.service.ProductManager;

@Controller
public class HelloWorldController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private ProductManager productmanager;
	
	@RequestMapping(value="index.htm",method = RequestMethod.GET)
	public String index() {
		return "index";
	}	
	
	@RequestMapping(value="getStatus.htm",method = RequestMethod.GET)
	public ModelAndView hello() {
		logger.info("returning hello view with ");
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("status", this.productmanager.getStatus());
		return new ModelAndView("status", "model", myModel);
	}
	@RequestMapping(value="getConsumers.htm")
	public ModelAndView getConsumers(){
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("ODSconsumers", this.productmanager.getODSConsumers());
		myModel.put("WHconsumers", this.productmanager.getWHConsumers());
		return new ModelAndView("Consumers", "model", myModel);		
	}
	@RequestMapping(value="routineCheckup.htm")
	public ModelAndView routineCheckup(){
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("busdate", this.productmanager.routineCheckup());
		return new ModelAndView("routineCheckup", "model", myModel);		
	}
	@RequestMapping(value="correctDates.htm")
	public @ResponseBody String correctDates(@RequestParam(value="data") String subarea ){
		String query=productmanager.createQuery(subarea);
		return query;	
	}
	
}
