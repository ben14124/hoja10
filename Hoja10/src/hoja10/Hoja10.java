/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoja10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/**
 *
 * @author dbs_jd
 */
public class Hoja10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("la ruta mas corta es: la integral de línea desde t=0 hasta t=3, parametrizando x=cost, y = sent, z = 1");
        // TODO code application logic here
        
File fileDiccionario= new File ("diccionario.txt");
        File fileTexto= new File ("texto.txt");
        BinaryTree diccionario= new BinaryTree(null);
        BinarySearchTree funciones = new BinarySearchTree();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileDiccionario));
            try { 
                ArrayList<TreeMap> lista= new ArrayList<TreeMap>();
                for(String line; (line = br.readLine()) != null; ){
                    String[] entry;
                    entry= line.split(",");
                    entry[0]=entry[0].substring(1).toLowerCase();
                    entry[1]=(String) entry[1].subSequence(1, entry[1].length()-1);
                    entry[1]=entry[1].toLowerCase();
                    TreeMap<String, String> entrada = new TreeMap();
                    entrada.put(entry[0], entry[1]);
                    lista.add(entrada);
                }
                diccionario.setValue(lista.get(0));
                for (int x=1; x<lista.size(); x++){
                    funciones.insertNode(diccionario, lista.get(x));
                }
                
                System.out.println("DICCIONARIO INGLES-ESPANOL\n\nPalabras en el diccionario:\n");
                funciones.printInOrder(diccionario);
                System.out.println("\n");
            }
            catch(Exception e){
            }
        }
        catch(Exception e){
            
        }
    Digraph<Integer> graph= new Digraph<Integer>();
    graph.addNodes(Arrays.asList(1,2,3,4,5));

    try 
    {       
        // set the data fields
        for ( int i = 1; i <= 5; ++i)
        {
            graph.setData(i, i);
        }

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
        
        // now add the links between digraph nodes

        graph.addLinks(1,Arrays.asList(2,3));
        graph.addLinks(2,Arrays.asList(2,4));
        graph.addLinks(3,Arrays.asList(1));
        graph.addLinks(4,Arrays.asList(5));

        graph.printGraph();
    }
    catch ( MissingDigraphNodeException e)
    {
        System.out.println(e.getMessage());
    }

        
        
    }
    
}
