package ie.cit.adf.ccms.web;

import ie.cit.adf.ccms.service.CMSService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CCMSController {

	@Autowired
	private CMSService ccmsService; 
		
	@RequestMapping("index")
	public String listItems(Model model) {
		
		ccmsService.SyncFromCloud("FakeCloud", "user@cloud", "Secret");
		model.addAttribute("catalogItems", ccmsService.getAllCatalogItems());

		return "CatalogView.jsp";
	}
	
	@RequestMapping("deploy")
	public String deployItem(@RequestParam String vAppName, Model model) {
		
		ccmsService.deploy(vAppName);
		model.addAttribute("catalogItems", ccmsService.getAllCatalogItems());

		return "CatalogView.jsp";
	}
}

