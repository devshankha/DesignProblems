import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DriverManager {
	public static PrintStream getLog_stream() {
		return log_stream;
	}

	public static void setLog_stream(PrintStream log_stream) {
		DriverManager.log_stream = log_stream;
	}

	public static PrintWriter getLog_writer() {
		return log_writer;
	}

	public static void setLog_writer(PrintWriter log_writer) {
		DriverManager.log_writer = log_writer;
	}

	static List<Driver> drivers = new ArrayList<>();
	private static PrintStream log_stream;
	private static PrintWriter log_writer;
	static {

		String driver_string = System.getProperty("jdbc.drivers");
		if (driver_string != null) {
			StringTokenizer st = new StringTokenizer(driver_string);
			while (st.hasMoreTokens()) {
				String driver_classname = st.nextToken();

				try {
					Class.forName(driver_classname); // The driver registers itself
				} catch (Exception e) {
					// Ignore not founds
				}
			}
		}

	}

	private DriverManager() {

	}

	public static void registerDriver(Driver d) {
		System.out.println("Driver registered");
		if (!drivers.contains(d)) {
			drivers.add(d);
		}

	}

	public static void deregisterDriver(Driver d) {
		if (drivers.contains(d)) {
			drivers.remove(d);
		}

	}
	
	public static Driver getDriver(String url ) {
		for (Driver d:drivers) {
			if (d.acceptsURL(url))
				return d;
		}
		return null;
	}
	
	public static Connection getConnection(String url) {
		Driver d = getDriver(url);
		if (d == null) {
			return null;
		}
		return d.connect(url);
		
	}

}
