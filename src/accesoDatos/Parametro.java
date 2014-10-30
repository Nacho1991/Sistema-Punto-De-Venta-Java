/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import java.sql.Date;



public class Parametro {
    public static final int STRING = 1;
    public static final int DOUBLE = 2;
    public static final int INT = 3;
    public static final int DATETIME = 4;
    
    private int tipo;
    private Object valor;
    
    public Parametro(int pTipo, Object pValor)
    {
        this.tipo = pTipo;
        this.valor = pValor;
    }
    
    public int getTipo()
    {
        return this.tipo;
    }
    
    public String getValorString()
    {
        return String.valueOf(this.valor);
    }
    
    public int getValorInt()
    {
        return Integer.parseInt(this.valor.toString());
    }
    
    public double getValorDouble()
    {
        return Double.parseDouble(this.valor.toString());
    }
    
    public Date getValorDate()
    {
        return (Date)this.valor;
    }
}
