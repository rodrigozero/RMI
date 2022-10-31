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

public class InsereTuplo
{
    public InsereTuplo()
    {
        System.out.println("Arrancando o Cliente...");
        // Vamos tentar aceder ao Servidor de Registos para recolher a interface
        try
        {
            bd = (InterfaceServidorBD) Naming.lookup("rmi://127.0.0.1/ServidorBD_1");
        }
        catch (Exception e)
        {
            System.out.println("Falhou o arranque do Cliente.\n"+e);
	    System.out.println("Certifique-se que tanto o Servidor de Registos como a Aplicação Servidora estão a correr correctamente.\n");
            System.exit(0);
        }
    }    
    public void insere (String[] argv)
    {
        try
        {
            int id = bd.insere(argv[0], argv[1], argv[2], argv[3]);
            System.out.println("Inserido novo tuplo com ID: "+id);
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
        InsereTuplo i = new InsereTuplo();
        i.insere(argv);
    }

    private InterfaceServidorBD bd; // A interface para o objecto remoto
}
