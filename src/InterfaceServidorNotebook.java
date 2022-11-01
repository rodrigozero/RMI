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
   public interface InterfaceServidorNotebook extends Remote{
    public int insereNote(String marca, String modelo, String memoria, String cor) throws RemoteException;
    public Notebook selecionaNote(int id) throws RemoteException;
    public Vector listaNote() throws RemoteException;
    public int apagaNote(int id) throws RemoteException;
    }