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
* En esta clase se encuentran el metodo para el algoritmo de Floyd.
*******************************/

package hoja10;

class Floyd{ 
    
    private int[][] matrizP;
    private int[][] matrizD;
    
    public Floyd(int nodos){
        matrizP = new int[nodos][nodos];
        matrizD = new int[nodos][nodos];        
    }
    
    public int[][] AlgorithmFloyd(int n, int[][] W)
    {     
            matrizD = W;
            for (int i = 0; i<n; i++){      //Se inicializa la matrizP con 0's.
                    for(int j = 0; j<n; j++){
                            matrizP[i][j] = 8;
                    }
            }
            
            
            
            
            
             for (int k = 0; k < n; k++){
                    for(int i = 0; i < n; i++){
                            for(int j = 0; j<n; j++)
                            {
                                    if (matrizD[i][k] + matrizD[k][j]< matrizD[i][j])
                                    {
                                            matrizD[i][j] = matrizD[i][k] + matrizD[k][j];
                                            matrizP[i][j] = k;
                                    }
                            }
                    }
                    
             }
             
             return matrizD;
    }
    public int[][] getMatrizP(){
        return matrizP;
    }
}
