
public interface Driver {
	Connection connect(String url);
	boolean acceptsURL (String url);
	

}
