package design_patterns.behaviour_design_pattern;

import java.util.ArrayList;
import java.util.List;

interface Shape{
	public void draw(String s);
	public void accept(Visitor  v);
}
//Each concrete element class must implement the `accept`
//method in such a way that it calls the visitor's method that
//corresponds to the element's class.
class Dot implements Shape{

	@Override
	public void draw(String s) {
		System.out.println("Draw Dot with info :: " + s);
	}
	// Note that we're calling `visit`, which matches the
    // current class name. This way we let the visitor know the
    // class of the element it works with.

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
}

class Circle implements Shape{

	@Override
	public void draw(String s) {
		System.out.println("Draw Circle with info :: " + s);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}	
}
//The Visitor interface declares a set of visiting methods that
//correspond to element classes. The signature of a visiting
//method lets the visitor identify the exact class of the
//element that it's dealing with.

interface Visitor {
	public void visit(Dot d);
	public void visit(Circle c);
}
//Concrete visitors implement several versions of the same
//algorithm, which can work with all concrete element classes.
//
//You can experience the biggest benefit of the Visitor pattern
//when using it with a complex object structure such as a
//Composite tree. In this case, it might be helpful to store
//some intermediate state of the algorithm while executing the
//visitor's methods over various objects of the structure.

class DrawVisitor implements Visitor {

	@Override
	public void visit(Dot d) {
		d.draw("Dot Info from Draw Visitor");
	}

	@Override
	public void visit(Circle c) {
		c.draw("Circle Info from Draw Visitor");
	}
}

//The client code can run visitor operations over any set of
//elements without figuring out their concrete classes. The
//accept operation directs a call to the appropriate operation
//in the visitor object.

public class VisitorDesign {
	
	// client 
	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<Shape>(); 
		Visitor drawVisitor = new DrawVisitor();
		
		Shape s1 = new Dot();
		Shape s2 = new Circle();
		Shape s3 = new Dot();
		Shape s4 = new Circle();
		
		shapes.add(s1);
		shapes.add(s2);
		shapes.add(s3);
		shapes.add(s4);
		
		shapes.forEach(shape->{
			shape.accept(drawVisitor);
		});
	}
}
