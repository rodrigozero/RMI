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

public class ArrancaServidor
{
    public static void main(String argv[])
    {
        try
        {
            System.out.println("Arrancando servidor...");
            Naming.rebind("ServidorBD_1", new ServidorBD());
        }
        catch (Exception e)
        {
            System.out.println("Ocorreu um problema no arranque do servidor.\n"+e.toString());
        }
    }
}