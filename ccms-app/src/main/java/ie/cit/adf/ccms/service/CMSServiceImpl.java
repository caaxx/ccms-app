package ie.cit.adf.ccms.service;

import ie.cit.adf.ccms.domain.CatalogItem;
import ie.cit.adf.ccms.domain.dao.CatalogItemRepository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;

@Secured("ROLE_USER")
public class CMSServiceImpl implements CMSService {

	private CatalogItemRepository ciRepo;
	private Logger logger = Logger.getRootLogger();
	
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
			try {
				ciRepo.add(cItem);
			}
			catch (DuplicateKeyException e) {
				logger.warn("Duplicate exception thrown while adding items to the database. ", e);
				continue;
			}
		}
		
		
	}

	public void setCloudConnector(CloudConnectorService cloudConnector) {
		this.cloudConnector = cloudConnector;
	}

	@Override
	public List<CatalogItem> getAllCatalogItems() {
		return ciRepo.getAll(); 
	}

	@Override
	@Transactional
	public void deploy(String vAppName) 
			throws RuntimeException {
		CatalogItem ci = get(vAppName);
		if (ci == null) {
			throw new RuntimeException();
		}
		int deployCount = ci.getDeploycount() + 1;
		ci.setDeploycount(deployCount);
		ciRepo.Update(ci);
	}

	@Override
	public CatalogItem get(String vAppName) {
		CatalogItem ci = ciRepo.findByName(vAppName);
		return ci;
	}

}
