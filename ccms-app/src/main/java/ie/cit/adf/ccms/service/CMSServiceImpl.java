package ie.cit.adf.ccms.service;

import ie.cit.adf.ccms.domain.CatalogItem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CMSServiceImpl implements CMSService {

	@Autowired
	private CloudConnectorService cloudConnector;
	
	@Override
	public void SyncFromCloud(String cloudURI, String username, String password) {
		cloudConnector.connectToCloud(cloudURI, username, password);

	}

	@Override
	public List<CatalogItem> getAllCatalogItems() {
		
		return cloudConnector.getAllItems();
	}

}
