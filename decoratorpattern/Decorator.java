//This code is taken from javapapers
// excellent explanation of decorators== https://javapapers.com/design-patterns/decorator-pattern/

abstract class Icecream {
	public abstract String makeIcecream();
}

class SimpleIcecream extends Icecream {

	@Override
	public String makeIcecream() {
		return "Base Icecream";
	}

}

abstract class IcecreamDecorator extends Icecream {

	protected Icecream specialIcecream;

	public IcecreamDecorator(Icecream specialIcecream) {
		System.out.println("----");
		this.specialIcecream = specialIcecream;
	}

	public String makeIcecream() {
		return specialIcecream.makeIcecream();
	}
}

class NuttyDecorator extends IcecreamDecorator {

	public NuttyDecorator(Icecream specialIcecream) {
		super(specialIcecream);
	}

	public String makeIcecream() {
		return specialIcecream.makeIcecream() + addNuts();
	}

	private String addNuts() {
		return " + cruncy nuts";
	}
}

class HoneyDecorator extends IcecreamDecorator {

	public HoneyDecorator(Icecream specialIcecream) {
		super(specialIcecream);
	}

	public String makeIcecream() {
		return specialIcecream.makeIcecream() + addHoney();
	}

	private String addHoney() {
		return " + sweet honey";
	}
}

public class Decorator {
	public static void main(String[] args) {
		Icecream icecream = new HoneyDecorator(new NuttyDecorator(new SimpleIcecream()));
	    System.out.println(icecream.makeIcecream());

	}

}
