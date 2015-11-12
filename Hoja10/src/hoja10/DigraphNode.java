/*******************************
*Universidad del Valle de Guatemala
*Algoritmos y estructura de datos
*Seccion 30
*Hoja de trabajo 10: grafos
*Integrantes del grupo:
*   Juan Diego Benitez - 14124
*   Maria Belen Hernandez - 14361
*   Jose Alejandro Rivera - 14213
*   Daniela Pocasangre A. - 14162
* 
* En esta clase se encuentran los metodos para que funcione el nodo de un grafo con direccion.
* 
* Codigo obtenido de: http://codereview.stackexchange.com/questions/29915/digraph-code-in-java
*******************************/
package hoja10;

import java.util.ArrayList;
import java.util.List;

class DigraphNode<T>  
{
    int id;
    T data;
    ArrayList<DigraphNode<T> > links;

    public DigraphNode(int i) 
    {
        id = i;
        links = new ArrayList<DigraphNode<T> >();
    }
    public DigraphNode(int i, T d) 
    { 
        id = i; data = d;
        links = new ArrayList<DigraphNode<T> >();
    }

    public DigraphNode(DigraphNode<T> other)
    {
        this.data = other.data;
        this.links = other.links;
        this.id = other.id;
    }

    public void setData (T d ) { data =  d; }
    public void addLink (DigraphNode<T> n) { links.add(n); }
    public void addLinks (List<DigraphNode<T> > ns) { links.addAll(ns); }

    public List<DigraphNode<T>> getLinks()
    {
        // return a new copy of the list
        ArrayList<DigraphNode<T> > l = new ArrayList<DigraphNode<T> >(); 
        for ( DigraphNode<T> i : links )
        {
            i.links.add(new DigraphNode<T>(i)); // use copy constructor
        }
        return l;
    }

    public void printNode()
    {
        System.out.print("Id: " + id + " links: ");
        for ( DigraphNode<T> i : links )
        {
            System.out.print(i.id + " ");
        }
        System.out.println();
    }
    
    public List<T> Links()
    {
        List<T> l = new ArrayList<>();         
        for ( DigraphNode<T> i : links )
        {
            l.add(i.data);
        }        
        return l;
    }  
    public T getData(){
        return data;
    }
}

