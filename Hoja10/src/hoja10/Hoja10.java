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
    for (int x = 0; x<contador; x++){
        for (int y = 0; y<contador; y++){
            if(x!=y){
             matrizW[x][y] = 30000;
            }
        }
    }
                
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
                //Se crea la matriz de pesos
                matrizW[Ciudades.indexOf(Ciudad2.elementAt(m))][f]=Distancia.elementAt(m); //Se ingresa a la matriz el peso del nodo
                System.out.println("-"+Ciudad2.elementAt(m));
            }
        }
    }
    //Se imprime la matriz de adyacencia
    System.out.println("\nMatriz de pesos:");
    for (int x = 0; x<contador; x++){
            for (int y = 0; y<contador; y++){
                System.out.print(matrizW[x][y] + " | ");
            }
            System.out.println();
    }
    
    int[][] Ady = new int[contador][contador];
    
    System.out.println("\nAdyacencia");
    for (int x = 0; x<contador; x++){
        for (int y = 0; y<contador; y++){
            if((matrizW[x][y] != 30000)){
                Ady[x][y] = 1;
            }
            if((matrizW[x][y] == 0)){
                Ady[x][y] = 0;
            }
        }
    }
    
    for (int x = 0; x<contador; x++){
        for (int y = 0; y<contador; y++){
            System.out.print(Ady[x][y] + " | ");
        }
        System.out.println();
    }
    
    Floyd algoritmo1 = new Floyd(contador);
   
       
        int[][] matrizD3 = algoritmo1.AlgorithmFloyd(5, matrizW);

        System.out.println("\nResultado:");
    for (int x = 0; x<contador; x++){
        for (int y = 0; y<contador; y++){
            System.out.print(matrizD3[x][y] + " | ");
        }
        System.out.println();
    }
        
    int[] centro = new int[contador];

    for (int x = 0; x<contador; x++){
        centro[x] = matrizD3[0][x];
        for (int y = 0; y<contador; y++){
            if(matrizD3[y][x] != 0){
                if(centro[x] < matrizD3[y][x]){
                    centro[x] = matrizD3[y][x];
                }
            }
        }
    }
    
    int centroF = centro[0];
    int ciudadC = 0;
    
    for (int x = 0; x<contador; x++){
        if(centroF > centro[x]){
            centroF = centro[x];
            ciudadC = x;
        }
    }
    
    
    System.out.println("\nLa ciudad central en donde se deberia de colocar las oficinas del TSE es: "+Ciudad1.elementAt(ciudadC));
    int[][] matrizP = new int[contador][contador];
    matrizP= algoritmo1.getMatrizP();
    
    System.out.println("\nMatriz de rutas: ");
    for (int x = 0; x<contador; x++){
        for (int y = 0; y<contador; y++){
            System.out.print(matrizP[x][y] + " | ");
        }
        System.out.println();
    }
    
    
    }
    
}
