
import java.util.*;
/**
 * How to implement a java plugin library where you can search methods by signature
 * I was asked this question during an interview and could not come up with a good solution. Basically, I have to
 *  implement a java library where clients can register there methods and later search for methods by their 
 *  signature.
 * 
 * @author devshankhasharm
 * 
 * The Function class is given have to implement the register and findMatches method
 *
 */

class Function {
	public final List<String> argumentTypes; // e.g. ["Integer", "String", "PersonClass"]
	public final String name;

	Function(String name, List<String> argumentTypes) {
		this.name = name;
		this.argumentTypes = argumentTypes;
	}

	public String toString() {
		return this.name;
	}
}

public class FunctionLibrary {

	private static Map<String, List<Function>> map = new HashMap<>();

	static void register(Set<Function> functions) {
		for (Function f : functions) {
			List<String> args = f.argumentTypes;
			String n = f.name;
			StringBuffer buf = new StringBuffer();
			for (String s : args) {
				buf.append(s).append("_");

			}
			String key = new String(buf);
			if (!map.containsKey(key)) {
				List<Function> list = new ArrayList<Function>();
				list.add(f);
				map.put(key, list);

			} else {
				List<Function> list = map.get(key);
				list.add(f);

			}
			// map.put(key,map.getOrDefault(key,new ArrayList<Function>().add(f) ));
		}

	}

	static List<Function> findMatches(List<String> argumentTypes) {
		StringBuffer buf = new StringBuffer();
		for (String s : argumentTypes) {

			buf.append(s).append("_");
		}
		String key = new String(buf);

		return map.get(key);
	}

	public static void main(String[] args) {
		List<String> l1 = new ArrayList<String>();
		l1.add("Integer");
		l1.add("String");
		Function f1 = new Function("method1", l1);
		Set<Function> set1 = new HashSet<>();
		set1.add(f1);
		register(set1);
		//System.out.println(findMatches(l1));
		List<String> l2 = new ArrayList<String>();
		l2.add("Integer");
		l2.add("String");
		Function f2 = new Function("method2", l2);
		Set<Function> set2 = new HashSet<>();
		set2.add(f2);
		register(set2);
		System.out.println(findMatches(l1));
		Set<String> s = new HashSet<>();
		s.add("david");
		s.add("hussain");
		
		
		
		

	}

}
