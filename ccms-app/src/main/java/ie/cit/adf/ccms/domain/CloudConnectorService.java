package ie.cit.adf.ccms.domain;

public interface CloudConnectorService {

	String getCloudURI();
	int connectToCloud(String cloudURI); // should return the connection object

}
