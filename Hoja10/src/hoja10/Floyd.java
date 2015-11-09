/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hoja10;

/**
 *
 * @author Daniela
 */
class Floyd{ 
    
    private int[][] matrizP;
    private int[][] matrizD;
    
    public Floyd(int nodos){
        matrizP = new int[nodos][nodos];
        matrizD = new int[nodos][nodos];        
    }
    
    public void AlgorithmFloyd(int n, int[][] W)
    {
            matrizD = W;
            for (int i = 0; i<n; i++){
                    for(int j = 0; j<n; j++){
                            matrizP[i][j] = 0;
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
    }
}
