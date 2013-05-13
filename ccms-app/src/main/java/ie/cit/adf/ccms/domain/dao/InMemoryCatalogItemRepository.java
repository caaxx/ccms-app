package ie.cit.adf.ccms.domain.dao;

import ie.cit.adf.ccms.domain.CatalogItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCatalogItemRepository implements CatalogItemRepository {
	private Map<String, CatalogItem> data = new HashMap<String, CatalogItem>();

	@Override
	public CatalogItem findByName(String name) {
		return data.get(name);
	}

	@Override
	public List<CatalogItem> getAll() {
		return new ArrayList<CatalogItem>(data.values());
	}

	@Override
	public void add(CatalogItem catalogItem) {
		data.put(catalogItem.getVappname(), catalogItem);

	}

	@Override
	public void delete(String name) {
		data.remove(name);

	}

	@Override
	public void Update(CatalogItem catalogItem) {
		data.put(catalogItem.getVappname(), catalogItem);

	}

}
