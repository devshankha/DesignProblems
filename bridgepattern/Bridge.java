//Taken from Pankaj Kumars pdf on design patterns
abstract class Shape {
	protected Color color;

	public Shape(Color c) {
		color = c;

	}

	abstract void draw();
}

class Circle extends Shape {
	
	public Circle(Color c) {
		super(c);
	}

	@Override
	void draw() {
		System.out.print("Drawing a circle ");
		color.fill();
		
	}
	
}
class Square extends Shape {
	public Square(Color c) {
		super(c);
	}

	@Override
	void draw() {
		System.out.println("Drawing a square ");
		color.fill();
		
	}
	
}

abstract class  Color {
	
	abstract void fill();
}

class RedColor extends Color {

	@Override
	void fill() {
		// TODO Auto-generated method stub
		System.out.println("with red");
	}
	
}
public class Bridge {
	public static void main(String[] args) {
		Shape s = new Circle(new RedColor());
		s.draw();
		
	}

}
