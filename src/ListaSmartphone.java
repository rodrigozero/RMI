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

public class ListaSmartphone
{
    public ListaSmartphone()
    {
        System.out.println("Carregando...");
       
        try
        {
            bds = (InterfaceServidor) Naming.lookup("rmi://192.168.100.20/ServidorBD_s");
        }
        catch (Exception e)
        {
            System.out.println("Falhou.\n"+e);
            System.out.println("Certifique-se que tanto o Servidor de Registos como a Aplicação Servidora estão a correr correctamente.\n");                
            System.exit(0);
        }
    }    
    public void lista()
    {
        try
        {
            Vector itens = bds.lista();
            System.out.println("Smartphones Existentes na Base de Dados: "+itens.size());
            for (int j=0; j < itens.size(); j++)
            {
                Smartphone s = (Smartphone) itens.get(j);
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
        ListaSmartphone l = new ListaSmartphone();
        l.lista();
    }

    private InterfaceServidor bds; 
}
