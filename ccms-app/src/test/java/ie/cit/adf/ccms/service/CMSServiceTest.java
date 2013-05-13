package ie.cit.adf.ccms.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import ie.cit.adf.ccms.domain.CatalogItem;
import ie.cit.adf.ccms.domain.dao.CatalogItemRepository;
import ie.cit.adf.ccms.domain.dao.InMemoryCatalogItemRepository;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class CMSServiceTest {

	private CMSServiceImpl tested;
	private CatalogItemRepository ciRepo;
	Authentication auth;
	

	@Before
	public void setup() {
		auth = new UsernamePasswordAuthenticationToken("guest", "guest");
		SecurityContextHolder.getContext().setAuthentication(auth);
		ciRepo = new InMemoryCatalogItemRepository();
		tested = new CMSServiceImpl(ciRepo);
		tested.setCloudConnector(new FakeCloudConnectorServiceImpl());
	}

	@Test
	public void testDeployCI() {
		SecurityContextHolder.getContext().setAuthentication(auth);
		tested.SyncFromCloud("Test", "Admin", "Admin");
		CatalogItem ci = tested.get("MySamplevCloud");
		assertNotNull(ci);
		assertThat(ci.getDeploycount(), equalTo(5));
		tested.deploy(ci.getVappname());
		assertThat(ci.getDeploycount(), equalTo(6));
	}
}
