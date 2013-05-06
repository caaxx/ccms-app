package ie.cit.adf.ccms.web;

import ie.cit.adf.ccms.service.CMSService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CCMSController {

	@Autowired
	private CMSService ccmsService; 
		
	@RequestMapping("index")
	public String listItems(Model model) {
		
		model.addAttribute("catalogItems", ccmsService.getAllCatalogItems());

		return "CatalogView.jsp";
	}
}

