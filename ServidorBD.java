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
public class ServidorBD extends UnicastRemoteObject implements InterfaceServidorBD
{
    public ServidorBD() throws RemoteException
    {
        System.out.println("Novo Servidor BD instanciado...");
    	smarts = new Vector();
    }

    public int insere(String marca, String modelo, String memoria, String cor) throws RemoteException
    {
    	Smartphone s = new Smartphone(marca, modelo, memoria, cor);
   	smarts.add(s);
	System.out.println("Inserido novo tuplo com ID: "+s.ID());
	return s.ID();
    }
    public Vector lista() throws RemoteException
    {
    	return smarts;
    }
    public Smartphone selecciona(int id) throws RemoteException
    {
    	for (int j=0; j < smarts.size(); j++)
    	{
        	Smartphone s = (Smartphone) smarts.get(j);
        	if (s.temID(id)) return s; 
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
            		return 1;
        	}
    	}
    	return 0;
    }

    Vector smarts;

    public int insere(String string, String string0, String string1, String string2, String string3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}