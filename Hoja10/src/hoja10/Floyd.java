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
    public void Floyd(int n, int[][] W, int[][] P, int[][] D)
    {
            D = W;
            for (int i = 0; i<n; i++){
                    for(int j = 0; j<n; j++){
                            P[i][j] = 0;
                    }
            }
             for (int k = 0; k < n; k++){
                    for(int i = 0; i < n; i++){
                            for(int j = 0; j<n; j++)
                            {
                                    if (D[i][k] + D[k][j]< D[i][j])
                                    {
                                            D[i][j] = D[i][k] + D[k][j];
                                            P[i][j] = k;
                                    }
                            }
                    }
             }
    }
}
