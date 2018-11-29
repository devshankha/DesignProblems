
public class OracleDriver implements Driver{


	public Connection connect(String url) {
		// TODO Auto-generated method stub
		return new OracleConnection();
	}

	
	public boolean acceptsURL(String url) {
		// TODO Auto-generated method stub
		return true;
	}
	static {
		DriverManager.registerDriver(new OracleDriver());
	}

}
