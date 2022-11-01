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

public interface InterfaceServidorSmartphone extends Remote{
    public int insereSmart(String marca, String modelo, String memoria, String cor) throws RemoteException;
    public Smartphone selecionaSmart(int id) throws RemoteException;
    public Vector listaSmart() throws RemoteException;
    public int apagaSmart(int id) throws RemoteException;

   // public int insere(String string, String string0, String string1, String string2, String string3);
}