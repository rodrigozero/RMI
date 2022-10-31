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
public class Smartphone implements java.io.Serializable{
    private String marca;
    private String modelo;
    private String memoria;
    private String cor;
    private static int gID=0;
    private int mID=0;
    
public Smartphone(String marca, String modelo, String memoria, String cor){
    this.marca = marca;
    this.modelo = modelo;
    this.memoria = memoria;
    this.cor = cor;
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
        return "["+mID+"]\t"+marca+"\t"+modelo+"\t"+memoria+"\t"+cor;
    }
public static void main (String args[]){
try{
        InterfaceServidorBD bd = (InterfaceServidorBD) Naming.lookup("rmi://127.0.0.1/ServidorBD_1");
}
catch (Exception e){
    e.printStackTrace();
}

}
}