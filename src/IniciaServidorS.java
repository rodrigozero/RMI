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

public class IniciaServidorS
{
    public static void main(String argv[])
    {
        try
        {
            System.out.println("Servidor On...");
            Naming.rebind("ServidorBD_s", new ServidorSmartphone());
        }
        catch (Exception e)
        {
            System.out.println("Ocorreu um problema ao cerregar o servidor.\n"+e.toString());
        }
    }
}