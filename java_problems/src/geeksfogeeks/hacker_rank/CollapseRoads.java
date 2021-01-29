package geeksfogeeks;
import java.io.*;
        import java.util.*;

public class CollapseRoads {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter wr = new PrintWriter(System.out);
//        int T = Integer.parseInt(br.readLine().trim());
//        for(int t_i=0; t_i<T; t_i++)
//        {
//            String[] NM = br.readLine().split(" ");
//            int N = Integer.parseInt(NM[0]);
//            int M = Integer.parseInt(NM[1]);
//            int[][] roads = new int[M][2];
//            for(int i_roads=0; i_roads<M; i_roads++)
//            {
//                String[] arr_roads = br.readLine().split(" ");
//                for(int j_roads=0; j_roads<arr_roads.length; j_roads++)
//                {
//                    roads[i_roads][j_roads] = Integer.parseInt(arr_roads[j_roads]);
//                }
//            }
//
//            int[] out_ = Solution(N,M,roads);
//            for(int i_out_=0; i_out_<out_.length; i_out_++)
//            {
//                System.out.println(out_[i_out_]);
//            }
//        }
//
//        wr.close();
//        br.close();
//    }
//    static int[] Solution(int N, int M, int[][] roads){
//        // Write your code here
//
//        int[][] list = new int[N+1][N+1];
//
//        for(int i=0;i<M ; i++){
//            int u = roads[i][0];
//            int v = roads[i][1];
//            list[u][v] = 1;
//            list[v][u] = 1;
//        }
//        int res[] = new int[];
//        int cnt = 0;
//        for(int i=0;i<M;i++){
//            int u=roads[i][0];
//            int v = roads[i][1];
//            cnt++;
//            list[u][v] = 0;
//            list[v][u] = 0;
//
//            for(int j=0;i<list[v].length;j++){
//                if(list[v][j]==1){
//                    cnt++;
//                }
//            }
//            res[i]=cnt;
//        }
//    return res;
//    }
}
