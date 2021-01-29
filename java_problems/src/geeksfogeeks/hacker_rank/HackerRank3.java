package java_problems.geeksfogeeks;

public class HackerRank3 {
    public static void main(String[] args) {
//        int mask = 0x000F;
//        int value = 0x2222;
//        System.out.println(value & mask);

        try{
            Float f1 = new Float("3.0");
            int x = f1.intValue();
            byte b  = f1.byteValue();
            double d = f1.doubleValue();

            System.out.println(x+b+d);
        }catch (Exception e){
            System.out.println("bad");
        }
    }
}
