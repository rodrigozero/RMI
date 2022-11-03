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

public class SelecionaSmartphone{
    public SelecionaSmartphone()
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
    public void seleciona(String[] argv)
    {
        try
        {
            int id = Integer.parseInt(argv[0]);
            Smartphone sma = (Smartphone) bds.seleciona(id);
            System.out.println(sma.desc());
        }
        catch (Exception e)
        {
            System.out.println("Excepção durante chamada remotas:" +e);
            System.exit(0);
        }
    }  
 
    public static void main (String[] argv)
    {
        if (argv.length!=1)
        {
            System.out.println("Sintaxe:\n\tjava Smartphone selecionado: \"id\"");
            System.exit(0);
        }
        SelecionaSmartphone i = new SelecionaSmartphone();
        i.seleciona(argv);
    }

    private InterfaceServidor bds;
}
