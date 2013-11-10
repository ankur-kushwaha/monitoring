package springapp.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springapp.service.UnixManager;

@Controller
@RequestMapping("/test")
public class TestController {
	protected final Log logger = LogFactory.getLog(getClass());
	@Autowired
	UnixManager unixManager;
	@RequestMapping(value="/{url}.htm",method=RequestMethod.GET)
	public String command(@PathVariable(value="url")String url){
		return url;
	}
}
