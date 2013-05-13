package ie.cit.adf.ccms.service;

import ie.cit.adf.ccms.domain.CatalogItem;

import java.util.ArrayList;
import java.util.List;

public class FakeCloudConnectorServiceImpl implements CloudConnectorService {

	@Override
	public void connectToCloud(String cloudURI, String userName, String password) {
	}

	@Override
	public List<CatalogItem> getAllItems() {
		List<CatalogItem> cloudCatalog = new ArrayList<CatalogItem>();
		
		CatalogItem catalogItem1 = new CatalogItem("FakeCloud", "Catalog", "BaseTemplates", 
				"BaseSingleSite v1", "ccleary", 5);
		CatalogItem catalogItem2 = new CatalogItem("FakeCloud", "Catalog", "BaseTemplates", 
				"BasevCloudSite v1", "system", 0);
		CatalogItem catalogItem3 = new CatalogItem("FakeCloud", "Catalog", "BaseTemplates", 
				"BaseMultiSite v1", "ccleary", 0);
		CatalogItem catalogItem4 = new CatalogItem("FakeCloud", "Catalog", "BaseTemplates", 
				"SRM v1", "htester", 0);
		CatalogItem catalogItem5 = new CatalogItem("FakeCloud", "Sandbox", "InternalCatalog", 
				"MySamplevCloud", "jbeginner", 5);
		CatalogItem catalogItem6 = new CatalogItem("FakeCloud", "Sandbox", "InternalCatalog", 
				"vCAC Demo", "ccleary", 0);
		CatalogItem catalogItem7 = new CatalogItem("FakeCloud", "Sandbox", "InternalCatalog", 
				"SpringTrader v2", "jother", 0);
		CatalogItem catalogItem8 = new CatalogItem("FakeCloud", "Demo", "GoldMasters", 
				"vCAC Demo v8.2", "downer", 0);
		CatalogItem catalogItem9 = new CatalogItem("FakeCloud", "Demo", "GoldMasters", 
				"vCloud Demo v8.2", "downer", 0);
		CatalogItem catalogItem10 = new CatalogItem("FakeCloud", "Demo", "GoldMasters", 
				"HorizonWorkspace Demo v8.2", "downer", 0);
		
		cloudCatalog.add(catalogItem1);
		cloudCatalog.add(catalogItem2);
		cloudCatalog.add(catalogItem3);
		cloudCatalog.add(catalogItem4);
		cloudCatalog.add(catalogItem5);
		cloudCatalog.add(catalogItem6);
		cloudCatalog.add(catalogItem7);
		cloudCatalog.add(catalogItem8);
		cloudCatalog.add(catalogItem9);
		cloudCatalog.add(catalogItem10);
		
		return cloudCatalog;
	}

}
