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
public class ServidorSmartphone extends UnicastRemoteObject implements InterfaceServidor
{
    public ServidorSmartphone() throws RemoteException
    {
        System.out.println("Servidor Smartphone instanciado...");
    	smarts = new Vector();
    }
    public int inserir(String marca, String modelo, String cor, float preco) throws RemoteException
    {
    	Smartphone s = new Smartphone(marca, modelo, cor, preco);
   	smarts.add(s);
	System.out.println("Novo Smartphone Inserido com ID: "+s.ID());
	return s.ID();
    }
    public Vector lista() throws RemoteException
    {
    	System.out.println("O Cliente Listou Todos os Objetos ");
        return smarts;
        
    }
    
    public Smartphone seleciona(int id) throws RemoteException
    {
    	for (int j=0; j < smarts.size(); j++)
    	{
        	Smartphone s = (Smartphone) smarts.get(j);
        	if (s.temID(id)) 
                    System.out.println("Objeto Selecionado pelo Cliente com ID: "+s.ID());
                    return s; 
    	}
    	return (Smartphone) null;
    }
    public int apaga(int id) throws RemoteException
    {
    	for (int j=0; j < smarts.size(); j++)
    	{
        	Smartphone s = (Smartphone) smarts.get(j);
        	if (s.temID(id)) 
        	{
            		smarts.remove(j);
                        System.out.println("Smartphone Deletado com ID: "+s.ID());
            		return 1;
        	}
    	}
    	return 0;
    }

    Vector smarts; 
}