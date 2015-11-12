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
* En esta clase se encuentran los metodos para que funcione un grafo con direccion.
* 
* Codigo obtenido de: http://codereview.stackexchange.com/questions/29915/digraph-code-in-java
*******************************/
package hoja10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Digraph<T>  
{
    private HashMap<Integer,DigraphNode<T> > nodes;

    Digraph() 
    {
        nodes = new HashMap<Integer,DigraphNode<T> >();
    }

    public void printGraph()
    {
        for ( Map.Entry<Integer, DigraphNode<T> > cursor : nodes.entrySet())
        {
            cursor.getValue().printNode();
        }
    }

    public void addNode(int id) { nodes.put (id,new DigraphNode<T>(id)); }

    public void addNodes(List<Integer> ids) 
    { 
        for ( Integer i : ids)
        {
            nodes.put (i,new DigraphNode<T>(i)); 
        }
    }

    public void setData (int id, T data ) throws MissingDigraphNodeException 
    { 
        getNode(id).setData(data);
    }

    public void addLink (int id, int linkId ) throws MissingDigraphNodeException 
    { 
        getNode(id).addLink(getNode(linkId));
    }

    public void addLinks (int id, List<Integer> links ) throws MissingDigraphNodeException 
    { 
        DigraphNode<T> node = getNode(id);
        for ( Integer i : links )
        {
            node.addLink(getNode(i));
        }
    }

    DigraphNode<T> getNode(int id) throws MissingDigraphNodeException 
    {
        DigraphNode<T> node = nodes.get(id);
        if (node == null)
        {
            throw new MissingDigraphNodeException("Error: Digraph Node Id: " + id + " not found in Digraph");
        }
        return node;
    }

}