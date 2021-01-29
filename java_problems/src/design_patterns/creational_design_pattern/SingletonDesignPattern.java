package design_patterns.creational_design_pattern;


// creates inner static class 
/**
 * 
 *  Notice the private inner static class that contains the instance of the singleton class. When the singleton class is loaded, 
 * SingletonHelper class is not loaded into memory and only when someone calls the getInstance method, this class gets loaded and 
 * creates the Singleton class instance.
 * 
 * 
 * 
 * So it destroys the singleton pattern, to overcome this scenario all we need to do it provide the implementation of readResolve() 
 * method.

protected Object readResolve() {
    return getInstance();
}
After this, you will notice that hashCode of both the instances is same in the test program.

 */
class BillPughSingleton {

    private BillPughSingleton(){}
    
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}

 
class SingletonDesignPattern
{

}


