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
public class InsereNotebook{
    public InsereNotebook()
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
    public void inserir(String[] argv)
    {
        try
        {
            int id = bdn.inserir(argv[0], argv[1], argv[2], Float.parseFloat(argv[3]));
            System.out.println("Novo Notebook Inserido com ID: "+id);
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
        InsereNotebook i = new InsereNotebook();
        i.inserir(argv);
    }

    private InterfaceServidor bdn; 
}
