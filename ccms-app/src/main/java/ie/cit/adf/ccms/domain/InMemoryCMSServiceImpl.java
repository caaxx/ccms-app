package ie.cit.adf.ccms.domain;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;

import org.apache.http.HttpException;

import com.vmware.vcloud.api.rest.schema.ReferenceType;
import com.vmware.vcloud.sdk.Organization;
import com.vmware.vcloud.sdk.VCloudException;
import com.vmware.vcloud.sdk.VcloudClient;
import com.vmware.vcloud.sdk.Vdc;
import com.vmware.vcloud.sdk.constants.Version;

public class InMemoryCMSServiceImpl implements CMSService {

	public VcloudClient vcloudClient;
	public HashMap<String, ReferenceType> organizationsMap;
	String cloudURL;
	String username;
	String password;
	
	public String getCloudURL() {
		return cloudURL;
	}

	public void setCloudURL(String CloudURL) {
		this.cloudURL = CloudURL;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void ConnectToCloud()
			throws HttpException, VCloudException, IOException,
			KeyManagementException, NoSuchAlgorithmException,
			UnrecoverableKeyException, KeyStoreException {
		VcloudClient.setLogLevel(Level.OFF);
		vcloudClient = new VcloudClient(cloudURL, Version.V5_1);
		vcloudClient.registerScheme("https", 443, FakeSSLSocketFactory
				.getInstance());
		vcloudClient.login(username, password);
		organizationsMap = vcloudClient.getOrgRefsByName();
		if (organizationsMap.isEmpty()) {
			throw new HttpException();
		}
	}

	public void SyncContentItemsFromCloud(CloudConnectorService cloudConnection) {
		// TODO Auto-generated method stub

	}

	public Collection<String> getAllCatalogItems() throws IOException {
		List<String> contentItems = new ArrayList<String>();
		contentItems.clear();

		if (!organizationsMap.isEmpty()) {
			for (String organizationName : organizationsMap.keySet()) {
				ReferenceType organizationReference = organizationsMap
						.get(organizationName);

				Organization organization = null;
				try {
					organization = Organization
							.getOrganizationByReference(vcloudClient,
									organizationReference);
				} catch (VCloudException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Collection<ReferenceType> vdcLinks = organization.getVdcRefs();
				if (!vdcLinks.isEmpty()) {
					for (ReferenceType vdcLink : vdcLinks) {
						Vdc vdc = null;
						try {
							vdc = Vdc.getVdcByReference(vcloudClient, vdcLink);
						} catch (VCloudException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
									
						Collection<ReferenceType> vAppTemplateReferences = vdc
								.getVappTemplateRefs();
						if (!vAppTemplateReferences.isEmpty()) {
							for (ReferenceType vAppTemplateRef : vAppTemplateReferences) {
								contentItems.add(vAppTemplateRef.getName());
							}
						}
					}
				}
			}
		} else {
			contentItems.add(cloudURL);
			contentItems.add(username);
			contentItems.add(password);
		}
			
		
		return contentItems;
	}

}
