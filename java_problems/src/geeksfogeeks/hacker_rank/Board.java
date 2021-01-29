package geeksfogeeks;

public class Board {
    public String solution(int U, int L, int[] C) {
        // write your code in Java SE 8
        StringBuilder uRow = new StringBuilder();
        StringBuilder lRow = new StringBuilder();
        int upperCount = U;
        int lowerCount = L;
        boolean isPossible = false;
        /** Consider two case if C[k] is 1 then possibility that Upper row is 1 or Lower row is 1 */

        // if C[k] is 1 then consider upper row 1
        for (int i = 0; i < C.length; i++) {
            switch (C[i]) {
                case 0:
                    uRow.append(0);
                    lRow.append(0);
                    break;
                case 1:
                    if(upperCount==0 && lowerCount!=0){
                        uRow.append(0);
                        lRow.append(1);
                        lowerCount--;
                    }else{
                        uRow.append(1);
                        lRow.append(0);
                        upperCount--;
                    }
                    break;
                case 2:
                    uRow.append(1);
                    lRow.append(1);
                    upperCount--;
                    lowerCount--;
                    break;
            }

        }

        if ((upperCount == 0) && ( lowerCount == 0)) {
            isPossible = true;
        } else {
            // if C[k] is 1 then consider lower row 1
            upperCount = U;
            lowerCount = L;
            for (int i = 0; i < C.length; i++) {
                switch (C[i]) {
                    case 0:
                        uRow.append(0);
                        lRow.append(0);
                        break;
                    case 1:

                        if(lowerCount==0 && upperCount!=0){
                            uRow.append(1);
                            lRow.append(0);
                            upperCount--;
                        }else{
                            uRow.append(0);
                            lRow.append(1);
                            lowerCount--;
                        }
                        break;
                    case 2:
                        uRow.append(1);
                        lRow.append(1);
                        upperCount--;
                        lowerCount--;
                        break;
                }
            }
            if ((upperCount == 0) && (lowerCount == 0)) {
                isPossible = true;
            }
        }
        if (isPossible) {
            return (uRow.append(',').append(lRow)).toString();
        } else {
            return "IMPOSSIBLE";
        }
    }

}
