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
public class DeletaNotebook{
    public DeletaNotebook()
    {
        System.out.println("Carregando...");
        
        try
        {
            bdn = (InterfaceServidor) Naming.lookup("rmi://127.0.0.1/ServidorBD_n");
        }
        catch (Exception e)
        {
            System.out.println("Falhou.\n"+e);
	    System.out.println("Certifique-se que tanto o Servidor de Registos como a Aplicação Servidora estão a correr correctamente.\n");
            System.exit(0);
        }
    }    
    public void apaga(String[] argv)
    {
        try
        {
            int id = Integer.parseInt(argv[0]);
            bdn.apaga(id);
            System.out.println("Notebook Deletado com ID: "+id);
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
            System.out.println("Qual ID do Objeto a ser Deletado?");
            System.exit(0);
        }
        DeletaNotebook i = new DeletaNotebook();
        i.apaga(argv);
    }

    private InterfaceServidor bdn;
}

