// This is a new package comment

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

	public String getCloudname() {
		return cloudname;
	}

	public void setCloudname(String cloudname) {
		this.cloudname = cloudname;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getCatalogname() {
		return catalogname;
	}

	public void setCatalogname(String catalogname) {
		this.catalogname = catalogname;
	}

	public String getVappname() {
		return vappname;
	}

	public void setVappname(String vappname) {
		this.vappname = vappname;
	}

	public String getItemowner() {
		return itemowner;
	}

	public void setItemowner(String itemowner) {
		this.itemowner = itemowner;
	}

	public int getDeploycount() {
		return deploycount;
	}

	public void setDeploycount(int deploycount) {
		this.deploycount = deploycount;
	}



}
