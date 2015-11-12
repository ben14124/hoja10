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
* Codigo obtenido de: http://codereview.stackexchange.com/questions/29915/digraph-code-in-java
*******************************/


package hoja10;


class MissingDigraphNodeException extends Exception 
{
    private static final long serialVersionUID = 1000L;
    public MissingDigraphNodeException(String message)
    {
        super(message);
    }
}