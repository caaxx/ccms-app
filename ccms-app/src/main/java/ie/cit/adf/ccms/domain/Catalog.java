package ie.cit.adf.ccms.domain;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
	public List <CatalogItem> catalog = new ArrayList<CatalogItem>();
	
	public Catalog() {
		
	}
	
	public Catalog(List<CatalogItem> catalog) {
		super();
		this.catalog = catalog;
	}
}
