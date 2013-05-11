package ie.cit.adf.ccms.web;

import ie.cit.adf.ccms.domain.Catalog;
import ie.cit.adf.ccms.domain.CatalogItem;
import ie.cit.adf.ccms.service.CMSService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
@RequestMapping("api")
public class CCMSRestController {

	@Autowired
	private CMSService ccmsService; 

	// curl -X GET -i http://localhost:8080/ccms/api/catalog/{username}/{password}
	@RequestMapping(value = "/catalog/{username}/{password}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Catalog catalog(@PathVariable String username, @PathVariable String password) {
		//Authentication auth = new UsernamePasswordAuthenticationToken(username, password);
		//SecurityContextHolder.getContext().setAuthentication(auth);
		return new Catalog(ccmsService.getAllCatalogItems());
	}
	
	// curl -X GET -i http://localhost:8080/ccms/api/ci/{vAppName}/{username}/{password}
	@RequestMapping(value = "ci/{vAppName}/{username}/{password}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public CatalogItem getCI(@PathVariable String vAppName, @PathVariable String username, @PathVariable String password) {
		//Authentication auth = new UsernamePasswordAuthenticationToken(username, password);
		//SecurityContextHolder.getContext().setAuthentication(auth);
		
		CatalogItem ci = ccmsService.get(vAppName);
		if (ci == null)
			throw new NotFoundException();
		return ci;
	}
		
	// curl -X PUT -i http://localhost:8080/ccms/api/deploy/{vAppName}
	@RequestMapping(value = "deploy/{vAppName}/{username}/{password}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable String vAppName, @PathVariable String username, @PathVariable String password) {
		try {
			ccmsService.deploy(vAppName);
		}
		catch (RuntimeException e) {
			throw new NotFoundException();
		}
	}
	
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}