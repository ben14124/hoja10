/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja10;

public class Node<T> implements Comparable<Node<T>> {
     
    protected T data;
    protected boolean visited;
    public Integer index = null;
    public Integer lowlink = null;
    public double distance = Double.POSITIVE_INFINITY;
    public Node<T> predecessor = null;
     
    public Node(T data) {
        this.data = data;
    }
     
    public Node() {
         
    }
     
    public boolean isVisited() {
        return visited;
    }
     
    public void visit() {
        visited = true;
    }
     
    public void unvisit() {
        visited = false;
    }
     
    public int compareTo(Node<T> ob) {
        String tempA = this.toString();
        String tempB = ob.toString();
         
        return tempA.compareTo(tempB);
    }
     
    public String toString() {
        return data.toString();
    }
     
}