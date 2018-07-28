import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.ProtocolOptions.Compression;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;


public class TestCassendra {

	
	/** Cassandra Cluster. */
	private Cluster cluster;
	/** Cassandra Session. */
	private Session session;
	private int count;

	/**
	 * Connect to Cassandra Cluster specified by provided node IP address and port
	 * number.
	 *
	 * @param node
	 *            Cluster node IP address.
	 * @param port
	 *            Port of cluster host.
	 */
	public void connect(final String node, final int port) {
		this.cluster = Cluster.builder().addContactPoint(node).withPort(port).withCompression(Compression.NONE)
				.withCredentials("sop_apptalk_system", "changeme").build();
		final Metadata metadata = cluster.getMetadata();
		System.out.printf("Connected to cluster: %s\n", metadata.getClusterName());
		for (final Host host : metadata.getAllHosts()) {
			System.out.printf("Datacenter: %s; Host: %s; Rack: %s\n", host.getDatacenter(), host.getAddress(),
					host.getRack());
		}
		session = cluster.connect();
		session.execute("USE sop_services");
		SimpleStatement statement1 = new SimpleStatement("select * from item");

		SimpleStatement statement2 = new SimpleStatement("DESC sop_services.bby_store_copy1");

		//SimpleStatement statement3 = new SimpleStatement("DESC sop_services.item_copy1");

		statement1.setConsistencyLevel(ConsistencyLevel.ONE);
		statement2.setConsistencyLevel(ConsistencyLevel.ONE);
		//statement3.setConsistencyLevel(ConsistencyLevel.ONE);

		try {

			ResultSet rs = session.execute(statement1);
			System.out.println(rs);
			while (rs.iterator() != null) {
				for (Row row : rs) {
					count++;
				}
				
			}

			Integer count = 0;
			for (Row row : rs) {
				//System.out.println(row.g);
				count++;
			}
			System.out.printf(" total records --->" + count);
			ResultSet rs1 = session.execute(statement2);
			System.out.println(rs1);
		//	ResultSet rs2 = session.execute(statement3);
		//	System.out.println(rs2);
			session.close();
			cluster.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Provide my Session.
	 *
	 * @return My session.
	 */
	public Session getSession() {
		return this.session;
	}

	/** Close cluster. */
	public void close() {
		cluster.close();
	}

	/**
	 * Main function for demonstrating connecting to Cassandra with host and port.
	 *
	 * @param args
	 *            Command-line arguments; first argument, if provided, is the host
	 *            and second argument, if provided, is the port.
	 */
	public static void main(final String[] args) {
		final TestCassendra client = new TestCassendra();
		final String ipAddress = args.length > 0 ? args[0] : "dtl01gc6db01c";
		final int port = args.length > 1 ? Integer.parseInt(args[1]) : 9042;
		System.out.println("Connecting to IP Address " + ipAddress + ":" + port + "...");
		client.connect(ipAddress, port);
		client.close();
	}

}
