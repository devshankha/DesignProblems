//This is implementation of NullObject Pattern
// idea taken from below link, only basic idea of the code taken, rest i have written myself 
//https://dzone.com/articles/null-object-pattern-in-java
import java.util.ArrayList;
import java.util.List;

interface Shape {
	public void draw();
	
	public boolean isNull();
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Drwaing a circle");
		
	}

	@Override
	public boolean isNull() {		
		return false;
	}
	
}

class Triangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Drwaing a triangle");
		
	}

	@Override
	public boolean isNull() {		
		return false;
	}
	
}

class NullShape implements Shape {

	@Override
	public void draw() {
		System.out.println("Can't draw null shape");
		
	}

	@Override
	public boolean isNull() {		
		return true;
	}
	
}
public class NullObjectPattern1 {
	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
		shapes.add(new Circle());
		shapes.add(new Triangle());
		shapes.add(new NullShape());
		shapes.forEach(Shape::draw);
		List<String> l1 = new ArrayList<String>();
		l1.add("a");
		l1.add("b");
		l1.add("c");
		
		
		
	}

}
