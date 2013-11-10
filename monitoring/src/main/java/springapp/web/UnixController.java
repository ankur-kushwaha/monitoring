package springapp.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import springapp.service.UnixManager;

@Controller
@RequestMapping("/unix")
public class UnixController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	UnixManager unixManager;
	@RequestMapping(value="index.htm",method=RequestMethod.GET)
	public String command(){
		return "command";
	}
	@RequestMapping(value="index.htm",method=RequestMethod.POST)
	public ModelAndView output(@RequestParam(value="command")String command){
		Map<String, String> myModel = new HashMap<String, String>();
		String output=unixManager.getOutput(command);
		System.out.print(output);
		myModel.put("output",output);
		return new ModelAndView("command", "model", myModel);
	}
}
