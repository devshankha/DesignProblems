
public interface Connection {
	void commit();
	void close();
	Statement createStatement();

}
