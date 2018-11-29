
public class Client {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("OracleDriver");
		Connection con = DriverManager.getConnection("oracleconnection");
		Statement st = con.createStatement();
		st.executeQuery("fun");
	}

}
