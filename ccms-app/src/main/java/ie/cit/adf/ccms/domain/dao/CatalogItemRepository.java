package ie.cit.adf.ccms.domain.dao;

import ie.cit.adf.ccms.domain.CatalogItem;

import java.util.List;

public interface CatalogItemRepository {
	CatalogItem findByName(String name);
	List<CatalogItem> getAll();
	void add(CatalogItem catalogItem);
	void delete(String name);
	void Update(CatalogItem catalogItem);
}
