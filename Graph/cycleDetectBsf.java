/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
class Node {
    int first;
    int second;
    public Node(int first,int second){
        this.first = first;
        this.second = second;
    }
}

public class Main
{
	public static void main(String []args){
        ArrayList< ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<5;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(1);
        adj.get(4).add(3);
        boolean vis [] = new boolean[6];
        Arrays.fill(vis,false);
        
        boolean ans = bfs(5,adj,vis);
        System.out.println(ans);
        
    }
    public static void print(ArrayList<Integer> ans){
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
    public static boolean bfs(int V, ArrayList< ArrayList<Integer>> adj,boolean[] vis ){
        
       for(int i = 0;i<=V;i++){
           if(vis[i] == false){
               if(isCycle(i,-1,adj,vis)){
                   return true;
               }
           }
       }
       return false;
    }
    public static boolean isCycle(int s,int par, ArrayList< ArrayList<Integer>> adj,boolean[] vis  ){
        Queue<Node> q =  new LinkedList<>();
        q.add(new Node(s,-1));
        vis[s]=true;
        int node = q.peek().first;
        int par = q.peek().second;
        while(!q.isEmpty()){
        int node = q.peek().first;
        int par = q.peek().second;
        q.remove();
        for(Integer it : adj.get(node)){
            if(vis[it] == false){
                vis[it] = true;
                q.add(new Node(it,node));
            }else if(par != it){
                return true;
            }
        }
        }
    return false;
    }
}
