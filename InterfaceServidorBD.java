/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;
import java.util.Vector;
/**
 *
 * @author rodri
 */

public interface InterfaceServidorBD extends Remote{
    public int insere(String marca, String modelo, String memoria, String cor) throws RemoteException;
    public Smartphone selecciona(int id) throws RemoteException;
    public Vector lista() throws RemoteException;
    public int apaga(int id) throws RemoteException;

   // public int insere(String string, String string0, String string1, String string2, String string3);
}