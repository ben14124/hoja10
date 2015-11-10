/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja10;

/**
 *
 * @author dbs_jd
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dbs_jd
 */
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
}

