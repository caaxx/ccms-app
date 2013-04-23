package ie.cit.adf.ccms.web;

import java.io.IOException;

import ie.cit.adf.ccms.domain.CMSService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CCMSController {

	@Autowired
	private CMSService ccmsService; // dependency injection, wired by context-config.xml
		
	@RequestMapping("login")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("login.jsp");
		model.addObject("cloudURI", "TestURI"); //TODO: Implement login method
		
		return model;
	}

	@RequestMapping("listitems")
	public ModelAndView listItems() {
		
		ModelAndView model = new ModelAndView("CatalogView.jsp");
		try {
			model.addObject("contentItems", ccmsService.getAllCatalogItems());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

/*		List<String> contentItems = new ArrayList<String>();
		contentItems.add("test1");
		contentItems.add("test2");

		model.addObject("contentItems", contentItems);
*/		return model;
	}
}

