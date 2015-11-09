/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja10;

public class Edge {
 
    protected Node a, b;
    protected double weight;
     
    public Edge(Node a, Node b) {
        this(a, b, Double.POSITIVE_INFINITY);
    }
     
    public Edge(Node a, Node b, double weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }
     
    public double getWeight() {
        return weight;
    }
     
    public String toString() {
        return a + " ==> " + b;
    }
 
}