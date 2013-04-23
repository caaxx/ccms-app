package ie.cit.adf.ccms.domain;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Collection;

import org.apache.http.HttpException;

import com.vmware.vcloud.sdk.VCloudException;

import ie.cit.adf.ccms.domain.CloudConnectorService;

public interface CMSService {

	public String getCloudURL();
	public void setCloudURL(String CloudURL);
	public String getUsername();
	public void setUsername(String username);
	public String getPassword();
	public void setPassword(String password);
	
	public void ConnectToCloud()
	throws HttpException, VCloudException, IOException,
	KeyManagementException, NoSuchAlgorithmException,
	UnrecoverableKeyException, KeyStoreException; 
	
	public void SyncContentItemsFromCloud(CloudConnectorService cloudConnection);

	public Collection<String> getAllCatalogItems() throws IOException;
	
}



