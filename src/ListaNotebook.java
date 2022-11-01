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
public class ListaNotebook{
    public ListaNotebook()
    {
        System.out.println("Carregando...");
        // Vamos tentar ir aceder ao Servidor de Registos para recolher a interface
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
    public void listaNote(){
        try
        {
            Vector itens = bdn.listaNote();
            System.out.println("Notebooks Existentes na Base de Dados: "+itens.size());
            for (int j=0; j < itens.size(); j++)
            {
                Notebook n = (Notebook) itens.get(j);
                System.out.println(n.desc());
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
        ListaNotebook l = new ListaNotebook();
        l.listaNote();
    }

    private InterfaceServidorNotebook bdn; // A interface para o objecto remoto
}

