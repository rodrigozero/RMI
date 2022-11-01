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
public class SelecionaNotebook{
    public SelecionaNotebook()
    {
        System.out.println("Arrancando o Cliente...");
        // Vamos tentar aceder ao Servidor de Registos para recolher a interface
        try
        {
            bdn = (InterfaceServidorNotebook) Naming.lookup("rmi://127.0.0.1/ServidorBD_n");
        }
        catch (Exception e)
        {
            System.out.println("Falhou o arranque do Cliente.\n"+e);
	    System.out.println("Certifique-se que tanto o Servidor de Registos como a Aplicação Servidora estão a correr correctamente.\n");
            System.exit(0);
        }
    }    
    public void selecionaNote (String[] argv)
    {
        try
        {
            int id = Integer.parseInt(argv[0]);
            System.out.println(bdn.selecionaNote(id).desc());
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
            System.out.println("Sintaxe:\n\tjava SelecionaNotebook \"id\"");
            System.exit(0);
        }
        SelecionaNotebook i = new SelecionaNotebook();
        i.selecionaNote(argv);
    }

    private InterfaceServidorNotebook bdn; // A interface para o objecto remoto
}