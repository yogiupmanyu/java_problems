package geeksfogeeks;

/**
 *
 * */
interface First{
    default void common(){
        System.out.println("Fist");
    }
}

interface Second{
//    default void common(){
//        System.out.println("Second");
//    }
}

class Common implements  First,Second {

}
public class DefaultInterface {
}
