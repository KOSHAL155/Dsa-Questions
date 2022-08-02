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
       int n=6;
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> arr=new ArrayList<>();
            adj.add(arr);
        }
        
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        
        
        
        Stack<Integer> topoSort = dfs(n,adj);
        int result[] = new int [n];
        int index = 0;
        while(!topoSort.isEmpty()){
         System.out.print(topoSort.pop());
        }
        
    }

    public static Stack<Integer>  dfs(int V, ArrayList< ArrayList<Integer>> adj){
        Stack<Integer> result  = new Stack<Integer>();
        int [] vis = new int [V];
        Arrays.fill(vis,0);

       for(int i = 0;i<V;i++){
           if(vis[i] == 0){
               topologicalSort(i,adj,vis,result);
           }
       }
       return result;
    }
    public static void topologicalSort(int s, ArrayList< ArrayList<Integer>> adj,int[] vis, Stack<Integer> result  ){
         vis[s]=1;
            for(Integer it : adj.get(s)){
                if(vis[it] == 0){
                 topologicalSort(it,adj,vis,result);
                }
            }
        result.push(s);
    }
}
