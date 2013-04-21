package ie.cit.adf.ccms.domain;

import java.util.List;

import ie.cit.adf.ccms.domain.CloudConnectorService;

public interface CMSService {

	public void SyncContentItemsFromCloud(CloudConnectorService cloudConnection);

	public List<String> getAllCatalogItems();
	
}



