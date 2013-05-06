package ie.cit.adf.ccms.service;

import ie.cit.adf.ccms.domain.CatalogItem;

import java.util.List;

public interface CloudConnectorService {

	public void connectToCloud(String cloudURI, String userName, String password); 
	List<CatalogItem> getAllItems();
}
