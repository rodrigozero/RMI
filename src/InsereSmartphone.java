/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;
/**
 *
 * @author rodri
 */

public class InsereSmartphone{
    public InsereSmartphone()
    {
        System.out.println("Carregando...");
        try
        {
            bds = (InterfaceServidor) Naming.lookup("rmi://127.0.0.1/ServidorBD_s");
        }
        catch (Exception e)
        {
            System.out.println("Falhou.\n"+e);
	    System.out.println("Certifique-se que tanto o Servidor de Registos como a Aplicação Servidora estão a correr correctamente.\n");
            System.exit(0);
        }
    }    
    public void inserir(String[] argv)
    {
        try
        {
            int id = bds.inserir(argv[0], argv[1], argv[2], Float.parseFloat(argv[3]));
            System.out.println("Inserido novo Smartphone com ID: "+id);
        }
        catch (Exception e)
        {
            System.out.println("Excepção durante chamada remotas:" +e);
            System.exit(0);
        }
    }  
 
    public static void main (String[] argv)
    {
        if (argv.length!=4)
        {
            System.out.println("Digite as informações: \"Marca\" \"Modelo\" \"Cor\" \"Preco\"");
            System.exit(0);
        }
        InsereSmartphone i = new InsereSmartphone();
        i.inserir(argv);
    }

    private InterfaceServidor bds; 
}
