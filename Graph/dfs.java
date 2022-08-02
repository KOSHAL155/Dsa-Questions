/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;

public class Main{
    public static void main(String []args){
        ArrayList< ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<5;i++){
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(4);
        adj.get(2).add(1);
        adj.get(4).add(3);
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[5];
        for(int i=0 ;i<5;i++){
                if(vis[i] == false){
                   dfs(i,adj,ans,vis);
                }
            }
         
        print(ans);
        
    }
    public static void print(ArrayList<Integer> ans){
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    } 
    public static void dfs(int node, ArrayList< ArrayList<Integer>> adj ,ArrayList<Integer> ans,boolean[] vis ){
        
    
        ans.add(node);
        vis[node]=true;

            
            for(Integer it : adj.get(node)){
                if(vis[it] == false){
                   dfs(it,adj,ans,vis);
                }
            }
     
        
    }
}