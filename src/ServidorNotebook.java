/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;
/**
 *
 * @author rodri
 */
public class ServidorNotebook extends UnicastRemoteObject implements InterfaceServidorNotebook
{
    public ServidorNotebook() throws RemoteException
    {
        System.out.println("Novo Servidor notebook instanciado...");
    	notes = new Vector();
    }
    public int insereNote(String marca, String modelo, String memoria, String cor) throws RemoteException
    {
    	Notebook n = new Notebook(marca, modelo, memoria, cor);
   	notes.add(n);
	System.out.println("Inserido novo Notebook com ID: "+n.ID());
	return n.ID();
    }
    public Vector listaNote() throws RemoteException
    {
    	return notes;
    }
    public Notebook selecionaNote(int id) throws RemoteException
    {
    	for (int j=0; j < notes.size(); j++)
    	{
        	Notebook n = (Notebook) notes.get(j);
        	if (n.temID(id)) return n; 
    	}
    	return (Notebook) null;
    }
    public int apagaNote(int id) throws RemoteException
    {
    	for (int j=0; j < notes.size(); j++)
    	{
        	Notebook n = (Notebook) notes.get(j);
        	if (n.temID(id)) 
        	{
            		notes.remove(j);
            		return 1;
        	}
    	}
    	return 0;
    }

    Vector notes; 
}
