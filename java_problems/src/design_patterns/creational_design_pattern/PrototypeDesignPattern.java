package design_patterns.creational_design_pattern;

import design_patterns.creational_design_pattern.PrototypeFactory.ModelType;

/**
 * Prototype is a creational design pattern that lets you copy existing objects without making your code dependent on their classes.
 * Lets understand this pattern using an example. I am creating an entertainment application that will require instances of 
 * Movie, Album and Show classes very frequently. I do not want to create their instances everytime as it is costly.
 * So, I will create their prototype instances, and everytime when i will need a new instance, I will just clone the prototype.
 * */

interface PrototypeCapable extends Cloneable
{
    public PrototypeCapable clone() throws CloneNotSupportedException;
}

class Movie implements PrototypeCapable
{
    private String name = null;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public Movie clone() throws CloneNotSupportedException {
        System.out.println("Cloning Movie object..");
        return (Movie) super.clone();
    }
    @Override
    public String toString() {
        return "Movie";
    }
}
 
class Album implements PrototypeCapable
{
    private String name = null;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public Album clone() throws CloneNotSupportedException {
        System.out.println("Cloning Album object..");
        return (Album) super.clone();
    }
    @Override
    public String toString() {
        return "Album";
    }
}
 
class Show implements PrototypeCapable
{
    private String name = null;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public Show clone() throws CloneNotSupportedException {
        System.out.println("Cloning Show object..");
        return (Show) super.clone();
    }
    @Override
    public String toString() {
        return "Show";
    }
}
class PrototypeFactory
{
    public static class ModelType
    {
        public static final String MOVIE = "movie";
        public static final String ALBUM = "album";
        public static final String SHOW = "show";
    }
    private static java.util.Map<String , PrototypeCapable> prototypes = new java.util.HashMap<String , PrototypeCapable>();
 
    static
    {
        prototypes.put(ModelType.MOVIE, new Movie());
        prototypes.put(ModelType.ALBUM, new Album());
        prototypes.put(ModelType.SHOW, new Show());
    }
 
    public static PrototypeCapable getInstance(final String s) throws CloneNotSupportedException {
        return ((PrototypeCapable) prototypes.get(s)).clone();
    }
}
public class PrototypeDesignPattern {
	
	public static void main(String[] args)
    {
        try
        {
            String moviePrototype  = PrototypeFactory.getInstance(ModelType.MOVIE).toString();
            System.out.println(moviePrototype);
 
            String albumPrototype  = PrototypeFactory.getInstance(ModelType.ALBUM).toString();
            System.out.println(albumPrototype);
 
            String showPrototype  = PrototypeFactory.getInstance(ModelType.SHOW).toString();
            System.out.println(showPrototype);
 
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
    }

}
