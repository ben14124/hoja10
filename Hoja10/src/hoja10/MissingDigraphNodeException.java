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
class MissingDigraphNodeException extends Exception 
{
    private static final long serialVersionUID = 1000L;
    public MissingDigraphNodeException(String message)
    {
        super(message);
    }
}