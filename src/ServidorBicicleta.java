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
public class ServidorBicicleta extends UnicastRemoteObject implements InterfaceServidor
{
    public ServidorBicicleta() throws RemoteException
    {
        System.out.println("Servidor instanciado...");
    	bics = new Vector();
    }
    public int inserir(String marca, String modelo, String cor, float preco) throws RemoteException
    {
    	Bicicleta b = new Bicicleta(marca, modelo, cor, preco);
   	bics.add(b);
	System.out.println("Nova Bicicleta Inserida com ID: "+b.ID());
	return b.ID();
    }
    public Vector lista() throws RemoteException
    {
    	System.out.println("O Cliente Listou Todos os Objetos ");
        return bics;
    }
    public Bicicleta seleciona(int id) throws RemoteException
    {
    	for (int j=0; j < bics.size(); j++)
    	{
        	Bicicleta b = (Bicicleta) bics.get(j);
        	if (b.temID(id))
                    System.out.println("Objeto Selecionado pelo Cliente com ID: "+b.ID());
                    return b;
    	}
        
    	return (Bicicleta) null;
    }
    public int apaga(int id) throws RemoteException
    {
    	for (int j=0; j < bics.size(); j++)
    	{
        	Bicicleta b = (Bicicleta) bics.get(j);
        	if (b.temID(id)) 
        	{
            		bics.remove(j);
                        System.out.println("Bicicleta Deletado com ID: "+b.ID());
            		return 1;
        	}
    	}
    	return 0;
    }

    Vector bics; 
}
