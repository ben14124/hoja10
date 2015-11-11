/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author dbs_jd
 */
public class Hoja10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MissingDigraphNodeException {

        Set<String> encabezadosMatriz = new HashSet<>(); //Set para los encabezados de la matriz
        
        File diccionario = new File ("guategrafo.txt");
        Vector<String> Ciudad1 = new Vector<>();
        Vector<String> Ciudad2 = new Vector<>();
        Vector<Integer> Distancia = new Vector<>();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(diccionario));
            try { 
                for(String line; (line = br.readLine()) != null; ){
                    String[] entry;
                    entry= line.split(" ");
                    Ciudad1.addElement(entry[0]);
                    Ciudad2.addElement(entry[1]);
                    Distancia.addElement(Integer.parseInt(entry[2]));
                    encabezadosMatriz.add(entry[0]);
                    encabezadosMatriz.add(entry[1]);
                }
            }
            catch(Exception e){
            }
        }
        catch(Exception e){
        }
        
    int contador = encabezadosMatriz.size();
    System.out.println("Cantidad de ciudades: "+contador);
    System.out.println();
    
    Vector<String> Ciudades = new Vector<>();

    for(int i=0; i<Ciudad1.size(); i++){
        if(encabezadosMatriz.isEmpty() == false){
            boolean quitar = encabezadosMatriz.remove(Ciudad1.elementAt(i));
            if(quitar == true){
                Ciudades.add(Ciudad1.elementAt(i));
            }
        }
    }
    
    if(encabezadosMatriz.isEmpty() == false){
        for(int i=0; i<Ciudad2.size(); i++){
            if(encabezadosMatriz.isEmpty() == false){
                boolean quitar = encabezadosMatriz.remove(Ciudad2.elementAt(i));
                if(quitar == true){
                    Ciudades.add(Ciudad2.elementAt(i));
                }
            }
        }
    }  
        
    int[][] matrizW = new int[contador][contador];
                
    Digraph<String> grafos = new Digraph<>();
    Digraph<Integer> graph = new Digraph<>();
        
    //Se crea un nodo por ciudad
    for(int f = 0; f < contador; f++){
        grafos.addNode(f);
        grafos.setData(f, Ciudades.elementAt(f));
    }
    
    //Se crean las relaciones
    for(int f = 0; f < contador; f++){
        String ciudad;
        ciudad= grafos.getNode(f).getData();
        System.out.println("Links con "+ciudad+" (ID "+f+"):");
        
        for(int m = 0; m < Ciudad1.size(); m++){
            if (Ciudad1.elementAt(m).equals(ciudad)){
                grafos.addLink(f, Ciudades.indexOf(Ciudad2.elementAt(m)));
                //Se crea la matriz de adyacencia
                matrizW[Ciudades.indexOf(Ciudad2.elementAt(m))][f]=Distancia.elementAt(m);
                System.out.println("-"+Ciudad2.elementAt(m));
            }
        }
    }
    //Se imprime la matriz de adyacencia
    System.out.println("\nMatriz de adyacencia:");
    for (int x = 0; x<contador; x++){
            for (int y = 0; y<contador; y++){
                System.out.print(matrizW[x][y] + " | ");
            }
            System.out.println();
        }
    System.out.println("\nFloyd:\n");
    Floyd algoritmo1 = new Floyd(contador);
        
        int[][] matrizD = algoritmo1.AlgorithmFloyd(5, matrizW);
        
        for (int x = 0; x<contador; x++){
            for (int y = 0; y<contador; y++){
                System.out.print(matrizD[x][y] + " | ");
            }
            System.out.println();
        }
        
    
    /*graph.addNodes(Arrays.asList(1,2,3,4,5));

    try 
    {       
        // set the data fields
        for ( int i = 1; i <= 5; ++i)
        {
            graph.setData(i, i);
        }

        // now add the links between digraph nodes

        graph.addLinks(1,Arrays.asList(2,3));
        graph.addLinks(2,Arrays.asList(2,4));
        graph.addLinks(3,Arrays.asList(1));
        graph.addLinks(4,Arrays.asList(5));

        DigraphNode<Integer> nodo1 = graph.getNode(1);
        List<Integer> l = nodo1.Links();
        int swag = l.size();
        System.out.println("Links del nodo1: "+nodo1.Links()+". Con "+swag+" links");
        
        graph.printGraph();        
        
        int[][] matriz3 = new int[4][4];
        
        matriz3[0][0] = 0;
        matriz3[0][1] = 3000;
        matriz3[0][2] = 3;
        matriz3[0][3] = 3000;
        matriz3[1][0] = 2;
        matriz3[1][1] = 0;
        matriz3[1][2] = 3000;
        matriz3[1][3] = 3000;
        matriz3[2][0] = 3000;
        matriz3[2][1] = 7;
        matriz3[2][2] = 0;
        matriz3[2][3] = 1;
        matriz3[3][0] = 6;
        matriz3[3][1] = 3000;
        matriz3[3][2] = 3000;
        matriz3[3][3] = 0;
        
        Floyd algoritmo1 = new Floyd(4);
        
        int[][] matrizD = algoritmo1.AlgorithmFloyd(4, matriz3);
        
        for (int x = 0; x<4; x++){
            for (int y = 0; y<4; y++){
                System.out.print(matrizD[x][y] + " | ");
            }
            System.out.println();
        }
        
    }
    catch (MissingDigraphNodeException e)
    {
        System.out.println(e.getMessage());
    } */
        
    }
    
}
