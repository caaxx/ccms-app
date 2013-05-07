package ie.cit.adf.ccms.domain.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import ie.cit.adf.ccms.domain.CatalogItem;

public class JdbcCatalogItemReposoitory implements CatalogItemRepository {

	private JdbcTemplate jdbcTemplate;
	private CatalogItemMapper ciMapper = new CatalogItemMapper();
	
	public JdbcCatalogItemReposoitory(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public CatalogItem findByName(String name) {
		return jdbcTemplate.queryForObject(
				"SELECT CLOUDNAME, ORGNAME, CATALOGNAME, VAPPNAME, ITEMOWNER, DEPLOYCOUNT FROM CATALOGITEM WHERE ID=?", ciMapper, name);
	}

	@Override
	public List<CatalogItem> getAll() {
		return jdbcTemplate
				.query("SELECT CLOUDNAME, ORGNAME, CATALOGNAME, VAPPNAME, ITEMOWNER, DEPLOYCOUNT FROM CATALOGITEM", ciMapper);
	}

	@Override
	public void add(CatalogItem catalogItem) {
		jdbcTemplate.update("INSERT INTO CATALOGITEM VALUES(?,?,?,?,?,?)", catalogItem.getCloudname(),
				catalogItem.getOrgname(), catalogItem.getCatalogname(), catalogItem.getVappname(), catalogItem.getItemowner(), catalogItem.getDeploycount());
	}

	@Override
	public void delete(String name) {
		jdbcTemplate.update("DELETE FROM CATALOGITEM WHERE VAPPNAME=?", name);

	}

	@Override
	public void Update(CatalogItem catalogItem) {
		jdbcTemplate.update("UPDATE CATALOGITEM SET CLOUDNAME=?, ORGNAME=?, CATALOGNAME=?, ITEMOWNER=?, DEPLOYCOUNT=? WHERE VAPPNAME=?",
				catalogItem.getCloudname(), catalogItem.getOrgname(), catalogItem.getCatalogname(), catalogItem.getItemowner(), catalogItem.getDeploycount(), 
				catalogItem.getVappname());

	}

}

class CatalogItemMapper implements RowMapper<CatalogItem> {
	@Override
	public CatalogItem mapRow(ResultSet rs, int rowNum) throws SQLException {
		CatalogItem ci = new CatalogItem();
		ci.setCloudname(rs.getString("CLOUDNAME"));
		ci.setOrgname(rs.getString("ORGNAME"));
		ci.setCatalogname(rs.getString("CATALOGNAME"));
		ci.setVappname(rs.getString("VAPPNAME"));
		ci.setItemowner(rs.getString("ITEMOWNER"));
		ci.setDeploycount(rs.getInt("DEPLOYCOUNT"));
	
		return ci;
	}
}
