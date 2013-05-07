package ie.cit.adf.ccms.service;

import ie.cit.adf.ccms.domain.CatalogItem;
import ie.cit.adf.ccms.domain.dao.CatalogItemRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CMSServiceImpl implements CMSService {

	private CatalogItemRepository ciRepo;
	
	public CMSServiceImpl(CatalogItemRepository ciRepo) {
		this.ciRepo = ciRepo;
	}
	
	@Autowired
	private CloudConnectorService cloudConnector;
	
	@Override
	public void SyncFromCloud(String cloudURI, String username, String password) {
		cloudConnector.connectToCloud(cloudURI, username, password);
		List<CatalogItem> cloudContent = cloudConnector.getAllItems();
		for (CatalogItem cItem : cloudContent) {
			ciRepo.add(cItem);
		}
		
		
	}

	@Override
	public List<CatalogItem> getAllCatalogItems() {
		
		return ciRepo.getAll(); 
	}

}
