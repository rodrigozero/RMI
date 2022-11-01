/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.rmi.*;
import java.util.Vector;
/**
 *
 * @author rodri
 */

public class ListaTuplos
{
    public ListaTuplos()
    {
        System.out.println("Arrancando o Cliente...");
        // Vamos tentar ir aceder ao Servidor de Registos para recolher a interface
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
    public void lista ()
    {
        try
        {
            Vector tuplos=bd.lista();
            System.out.println("Tuplos Existentes na Base de Dados: "+tuplos.size());
            for (int j=0; j < tuplos.size(); j++)
            {
                Smartphone s = (Smartphone) tuplos.get(j);
                System.out.println(s.desc());
            }
        }
        catch (Exception e)
        {
            System.out.println("Excepção durante chamada remotas:" +e);
            System.exit(0);
        }
    }    

    public static void main (String[] argv)
    {
        ListaTuplos l = new ListaTuplos();
        l.lista();
    }

    private InterfaceServidorBD bd; // A interface para o objecto remoto
}
