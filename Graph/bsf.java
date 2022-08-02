/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;

public class bsf{
    public static void main(String []args){
        ArrayList< ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<5;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(1);
        adj.get(4).add(3);
        ArrayList<Integer> ans = bfs(5,adj);
        print(ans);
        
    }
    public static void print(ArrayList<Integer> ans){
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    } 
    public static ArrayList<Integer> bfs(int V, ArrayList< ArrayList<Integer>> adj ){
        boolean[] vis = new boolean[V];
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q =  new LinkedList<>();
        
        q.add(0);
        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);
            for(Integer it : adj.get(node)){
                if(vis[it] == false){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
        
    }
}