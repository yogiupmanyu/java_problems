public class FruitBasket {

public static void main(String[] args) {
        int[] fruits = {1,0,1,4,1,4,1,2,3};
        int furt = totalFruit( fruits );
        System.out.println(furt);
    }
    public static int totalFruit(int[] fruits) {
        int one = fruits[0];
        int two = 0;
        for( int i=0 ; i< fruits.length;i++ ){
            if(fruits[i]!=fruits[0]){
                two = fruits[i];
                break;
            }
        }
        int max = -1;
        int cur = 0;
        int j = 0;
        while(j < fruits.length){
            if( fruits[j]==one || fruits[j]==two){
                cur++;
                j++;
            }else{
                max = Math.max( max, cur );
                int k = j-1;
                int newOne = fruits[k];
                while( fruits[k]==newOne){
                    k--;
                }
                cur = (j-k);
                one = fruits[k+1];
                two = fruits[j];
                j++;
            }
        }
        return Math.max( max, cur );
    }
}
