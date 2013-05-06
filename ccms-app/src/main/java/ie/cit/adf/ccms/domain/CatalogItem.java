package ie.cit.adf.ccms.domain;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "CatalogItem")
public class CatalogItem {
	
	private String cloudname;
	private String orgname;
	private String catalogname;
	private String vappname;
	private String itemowner;
	private int deploycount;
	
	public CatalogItem() {
		
	}
	
	public CatalogItem(String cloudName, String orgName, String catalogName,
			String vAppName, String itemOwner, int deployCount) {
		super();
		this.cloudname = cloudName;
		this.orgname = orgName;
		this.catalogname = catalogName;
		this.vappname = vAppName;
		this.itemowner = itemOwner;
		this.deploycount = deployCount;
	}

	public String getCloudName() {
		return cloudname;
	}
	public void setCloudName(String cloudName) {
		this.cloudname = cloudName;
	}
	public String getOrgName() {
		return orgname;
	}
	public void setOrgName(String orgName) {
		this.orgname = orgName;
	}
	public String getCatalogName() {
		return catalogname;
	}
	public void setCatalogName(String catalogName) {
		this.catalogname = catalogName;
	}
	public String getvAppName() {
		return vappname;
	}
	public void setvAppName(String vAppName) {
		this.vappname = vAppName;
	}
	public String getItemOwner() {
		return itemowner;
	}
	public void setItemOwner(String itemOwner) {
		this.itemowner = itemOwner;
	}
	public int getDeployCount() {
		return deploycount;
	}
	public void setDeployCount(int deployCount) {
		this.deploycount = deployCount;
	}
	
	

}
