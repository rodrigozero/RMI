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
            bds = (InterfaceServidor) Naming.lookup("rmi://192.168.100.20/ServidorBD_n");
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
            int id = bds.inserir(argv[0], argv[1], argv[2], argv[3]);
            System.out.println("Inserido novo smartphone com ID: "+id);
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
            System.out.println("Sintaxe:\n\tjava InsereTuplo \"Marca\" \"Modelo\" \"Memoria\" \"Cor\"");
            System.exit(0);
        }
        InsereSmartphone i = new InsereSmartphone();
        i.inserir(argv);
    }

    private InterfaceServidor bds; 
}
