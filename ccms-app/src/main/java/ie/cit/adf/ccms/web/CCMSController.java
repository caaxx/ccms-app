package ie.cit.adf.ccms.web;

import ie.cit.adf.ccms.domain.CMSService;
import ie.cit.adf.ccms.domain.CloudConnectorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CCMSController {

	@Autowired
	private CMSService ccmsService; // dependency injection, wired by context-config.xml
	
	@Autowired
	private CloudConnectorService cloudConnection;
	
	@RequestMapping("login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login.jsp");
		model.addObject("cloudURI", cloudConnection.getCloudURI()); //TODO: Implement login method
		
		return model;
	}

	@RequestMapping("listitems")
	public ModelAndView listItems() {
		ModelAndView model = new ModelAndView("CatalogView.jsp");
		model.addObject("contentItems", ccmsService.getAllCatalogItems());
			
		return model;
	}
}

