/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String []args){
        ArrayList< ArrayList<Integer>> adj = new ArrayList<>();
        int n=7;
        for(int i=0; i<n;i++){
            adj.add(new ArrayList<>());
        }
        	
		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(2).add(3);
		adj.get(3).add(2);

		adj.get(4).add(3);
		adj.get(3).add(4);

		adj.get(4).add(5);
		adj.get(5).add(4);

		adj.get(4).add(6);
		adj.get(6).add(4);

		adj.get(1).add(6);
		adj.get(6).add(1);
        int color [] = new int[n];
        Arrays.fill(color,-1);
        
        boolean ans = bfs(n,adj,color);
        System.out.println(ans);
        
    }
    
    public static boolean bfs(int V, ArrayList< ArrayList<Integer>> adj,int[] color){
        //check all component
       for(int i = 0;i<V;i++){
           if(color[i] == -1){
               if(!isBipertite(i,adj,color)){
                   return false;
               }
           }
       }
       return true;
    }
    public static boolean isBipertite(int s, ArrayList< ArrayList<Integer>> adj,int[] color  ){
        Queue<Integer> q =new LinkedList<>();
        q.add(s);
        color[s]=1;
        //check by traversing breadth wise
        while(!q.isEmpty()){
            Integer nde = q.poll();
            for(Integer it : adj.get(s)){
                if(color[it] == -1){
                 color[it]= 1-color[nde];
                 q.add(it);
                }else if(color[it] == color[nde]){
                    return false;
                }
            }
        }
        
        return true;
    }
}
