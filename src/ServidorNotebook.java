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
public class ServidorNotebook extends UnicastRemoteObject implements InterfaceServidor
{
    public ServidorNotebook() throws RemoteException
    {
        System.out.println("Servidor Notebook instanciado...");
    	notes = new Vector();
    }
    public int inserir(String marca, String modelo, String cor, float preco) throws RemoteException
    {
    	Notebook n = new Notebook(marca, modelo, cor, preco);
   	notes.add(n);
	System.out.println("Novo Notebook Inserido com ID: "+n.ID());
	return n.ID();
    }
    public Vector lista() throws RemoteException
    {
    	System.out.println("O Cliente Listou Todos os Objetos ");
        return notes;
    }
    public Notebook seleciona(int id) throws RemoteException
    {
    	for (int j=0; j < notes.size(); j++)
    	{
        	Notebook n = (Notebook) notes.get(j);
        	if (n.temID(id))
                    System.out.println("Objeto Selecionado pelo Cliente com ID: "+n.ID());
                    return n;
    	}
        
    	return (Notebook) null;
    }
    public int apaga(int id) throws RemoteException
    {
    	for (int j=0; j < notes.size(); j++)
    	{
        	Notebook n = (Notebook) notes.get(j);
        	if (n.temID(id)) 
        	{
            		notes.remove(j);
                        System.out.println("Notebook Deletado com ID: "+n.ID());
            		return 1;
        	}
    	}
    	return 0;
    }

    Vector notes; 
}
