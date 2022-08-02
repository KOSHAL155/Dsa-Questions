/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
// some issue with output in this
import java.util.*;
public class Main
{
	public static void main(String[] args) {
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
    shortestPathUnDirectedGraph(adj,n,0);
     
	}
	public static void shortestPathUnDirectedGraph(ArrayList<ArrayList<Integer>> adj,int N,int src){
        	int[] dist = new int[N]; 
    	for(int i = 0; i < N; i++) 
    		dist[i] = 1000000000; 
    
    	Queue<Integer> q=new LinkedList<>();
    	
    	
    	dist[src] = 0;
    	q.add(src); 
    
    	while(q.isEmpty()==false) 
    	{ 
    		int node = q.poll();  
    		 
    		for(int it:adj.get(node)){
    		    if(dist[node]+1 < dist[it]){
    		        dist[it] = dist[node] + 1;
    		        q.add(it);
    		    }
    		} 
    	}
    	
    	for(int i = 0;i < N;i++) {
    	    System.out.print(dist[i] + " "); 
    	}
	}
}
