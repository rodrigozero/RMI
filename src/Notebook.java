/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.Naming;
/**
 *
 * @author rodri
 */
public class Notebook implements java.io.Serializable{
    private String marca;
    private String modelo;
    private String cor;
    private float preco;
    private static int gID=0;
    private int mID=0;
    
public Notebook(String marca, String modelo,String cor, float preco){
    this.marca = marca;
    this.modelo = modelo;
    this.cor = cor;
    this.preco = preco;
    marcaID();
}/*
public String getMarca(){
    return marca;
}
public void setMarca(String marca){
    this.marca = marca;
}
public String getModelo(){
    return modelo;
}
public void setModelo(String modelo){
    this.modelo = modelo;
}
public String getMemoria(){
    return memoria;
}
public void setMemoria(String memoria){
    this.memoria = memoria;
}
public String getCor(){
    return cor;
}
public void setCor( String cor){
    this.cor = cor;
}*/
private synchronized int marcaID(){
    mID = gID++;
    return mID;     
}
public boolean temID(int id)
{
    return (mID == id);
}
public int ID()
{
    return mID;
}
public String desc()
    {
        return "["+mID+"]\t"+marca+"\t"+modelo+""+cor+"\t"+preco;
    }

}