package ie.cit.adf.ccms.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Catalog {
	public List <CatalogItem> catalog = new ArrayList<CatalogItem>();
	
	public Catalog() {
		
	}
	
	public Catalog(List<CatalogItem> catalog) {
		super();
		this.catalog = catalog;
	}
}
