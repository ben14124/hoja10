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
* Esta clase se encarga de la interaccion con el usuario y el despliegue de resultados.
* Imprime el resultado de aplicar el algoritmo de Floyd a los grafos que vienen en el archivo de texto Guategrafo.txt.
*******************************/
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
        
        File diccionario = new File ("guategrafo.txt"); //Se lee el archivo de texto
        Vector<String> Ciudad1 = new Vector<>(); //Se crean tres vectores. Uno para la ciudad de donde se viene, otro para la ciudad a donde se va, y otro para la distancia que hay.
        Vector<String> Ciudad2 = new Vector<>();
        Vector<Integer> Distancia = new Vector<>();
        
        try{        //Lectura del archvo de texto
            BufferedReader br = new BufferedReader(new FileReader(diccionario));
            try { 
                for(String line; (line = br.readLine()) != null; ){
                    String[] entry;
                    entry= line.split(" ");
                    //Se agregan los elementos respectivos
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
        
        int contador = encabezadosMatriz.size(); //El contador nos servira para saber en tamanio de la matriz de adyacencia, pesos, etc.
        System.out.println("Cantidad de ciudades: "+contador);
        System.out.println();

        Vector<String> Ciudades = new Vector<>(); //Se hace un vector para los encabezados de las matrices

        for(int i=0; i<Ciudad1.size(); i++){
            if(encabezadosMatriz.isEmpty() == false){
                boolean quitar = encabezadosMatriz.remove(Ciudad1.elementAt(i));
                if(quitar == true){
                    Ciudades.add(Ciudad1.elementAt(i)); //Se agregan las ciudades respectivas para los encabezados
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

        int[][] matrizW = new int[contador][contador]; //Se crea la matriz de pesos
        for (int x = 0; x<contador; x++){
            for (int y = 0; y<contador; y++){
                if(x!=y){ //Se deja la matriz diagonal con 0.
                 matrizW[x][y] = 30000;
                }
            }
        }

       //Se hacen los digrafos para agregarle los nodos de las ciudades
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
        //Se imprime la matriz de pesos
        System.out.println("\nMatriz de pesos:");
        for (int x = 0; x<contador; x++){
                for (int y = 0; y<contador; y++){
                    System.out.print(matrizW[x][y] + " | ");
                }
                System.out.println();
        }

        //Se crea la matriz de adyacencia
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

        //Impresion del a matriz de adyacencia
        for (int x = 0; x<contador; x++){
            for (int y = 0; y<contador; y++){
                System.out.print(Ady[x][y] + " | ");
            }
            System.out.println();
        }

        //Se instancia la clase para el algoritmo de Floyd
        Floyd algoritmo1 = new Floyd(contador);


        //matrizD3 va a ser la matriz resultante del algoritmo de Floyd
        int[][] matrizD3 = algoritmo1.AlgorithmFloyd(5, matrizW);

        //Se imprime el resultado
        System.out.println("\nResultado:");
        for (int x = 0; x<contador; x++){
            for (int y = 0; y<contador; y++){
                System.out.print(matrizD3[x][y] + " | ");
            }
            System.out.println();
        }

        //Se declara una nueva matriz para encontrar el centro del grafo. Aqui se guardara el maximo de cada columna para luego compararlos.
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

        //Se hacen comparaciones en el arreglo de centro para ver cual es el dato menor.
        for (int x = 0; x<contador; x++){
            if(centroF > centro[x]){
                centroF = centro[x];
                ciudadC = x;
            }
        }

        //Impresion de resultados
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
