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
      int V= 6;
                    	ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
       
                    	//Vertex - 0
                    	ArrayList<Integer> neighbors = new ArrayList<Integer>();
                    	neighbors.add(1);
                    	graph.add(neighbors);
 
                    	//Vertex - 1
                    	neighbors = new ArrayList<Integer>();
                    	neighbors.add(2);
                    	neighbors.add(5);
                    	graph.add(neighbors);
 
                    	//Vertex - 2
                    	neighbors = new ArrayList<Integer>();
                    	neighbors.add(3);
                    	graph.add(neighbors);
 
                    	//Vertex - 3
                    	neighbors = new ArrayList<Integer>();
                    	neighbors.add(4);
                    	graph.add(neighbors);
 
                    	//Vertex - 4
                    	neighbors = new ArrayList<Integer>();
                    	neighbors.add(0);
                    	neighbors.add(1);
                    	graph.add(neighbors);
 
                    	//Vertex - 5
                    	neighbors = new ArrayList<Integer>();
                    	graph.add(neighbors);

        
        boolean ans = dfs(V,graph);
        System.out.println(ans);
        
    }

    public static boolean dfs(int V, ArrayList< ArrayList<Integer>> adj){
        int [] vis = new int [V];
        int [] dfsVis = new int [V];
        Arrays.fill(vis,0);
        Arrays.fill(dfsVis,0);
       for(int i = 0;i<V;i++){
           if(vis[i] == 0){
               if(isCyclic(i,adj,vis,dfsVis)){
                   return true;
               }
           }
       }
       return false;
    }
    public static boolean isCyclic(int s, ArrayList< ArrayList<Integer>> adj,int[] vis,int [] dfsVis  ){
         vis[s]=1;
        dfsVis[s]=1;
            for(Integer it : adj.get(s)){
                if(vis[it] == 0){
                 
                 if(isCyclic(it,adj,vis,dfsVis)) return true;
                }else if(dfsVis[it] == 1){
                    return true;
                }
            }
        
        dfsVis[s] = 0;
        return false;
    }
}
