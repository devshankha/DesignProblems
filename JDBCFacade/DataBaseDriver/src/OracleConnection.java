
public class OracleConnection implements Connection{

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Statement createStatement() {
		// TODO Auto-generated method stub
		return new OracleStatement();
	}

}
