package ie.cit.adf.ccms.service;

import ie.cit.adf.ccms.domain.CatalogItem;

import java.util.List;

public interface CMSService {
	
	public void SyncFromCloud(String cloudURI, String username, String password);
	public List<CatalogItem> getAllCatalogItems();
	
}



