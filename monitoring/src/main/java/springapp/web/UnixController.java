package springapp.web;

import java.util.HashMap;
import java.util.Map;

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
	
	@Autowired
	UnixManager unixManager;
	@RequestMapping(value="index.htm",method=RequestMethod.GET)
	public String command(){
		return "command";
	}
	@RequestMapping(value="index.htm",method=RequestMethod.POST)
	public ModelAndView output(@RequestParam(value="command")String command){
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("output",unixManager.getOutput(command));
		return new ModelAndView("command", "model", myModel);
	}
}
