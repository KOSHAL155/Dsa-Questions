/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
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
        boolean isCycle = isDirectedGraphCycle(n,adj);
        System.out.println(isCycle);
	}
	public static boolean isDirectedGraphCycle(int n ,  ArrayList< ArrayList<Integer>> adj){
	    int [] topoSort = new int[n];
	    int [] inDegree = new int[n];
	    for(int i=0;i<n;i++){
	        for(Integer it: adj.get(i)){
	           inDegree[it]++;
	        }
	    }
	    Queue<Integer> q = new LinkedList<Integer>();
	    for(int i=0;i<n;i++){
	        if(inDegree[i]==0) {
	            q.add(i);
	            
	        }
	    }

	    int counter = 0;
	    while(!q.isEmpty()){
	        int node = q.poll();
	       counter++;
	        
	        for(Integer it : adj.get(node)){
	            inDegree[it]--;
	            if(inDegree[it] == 0){ 
	                q.add(it); 
	            }
	        }
	    }
	    if(counter == n ) return false;
	    return true;
	}
	
}
