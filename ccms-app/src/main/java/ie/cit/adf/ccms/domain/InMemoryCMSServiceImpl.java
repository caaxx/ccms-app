package ie.cit.adf.ccms.domain;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCMSServiceImpl implements CMSService {

	public void SyncContentItemsFromCloud(CloudConnectorService cloudConnection) {
		// TODO Auto-generated method stub

	}

	public List<String> getAllCatalogItems() {
		// TODO Auto-generated method stub
		List<String> contentItems = new ArrayList<String>();
		contentItems.add("ItemA");
		contentItems.add("ItemB");
		contentItems.add("ItemC");
		
		return contentItems;
	}

}
