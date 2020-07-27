/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.dao;

import bdFake.BancoFake;
import entidades.Cerveja;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class CervejaDAO
{

    //CRUD CERVEJA ============================================================== 
    public static Cerveja findById(int id)
    {
	//percorre a lista se encontrar :
	for (Cerveja cerv : BancoFake.getTB_CERVEJA())
	{
	    if (cerv.getId() == id)
	    {
		return cerv;
	    }
	    else
	    {
		//System.out.println("Cerveja " + id + " não encontrada!");
	    }
	}
	return null;
    }

    public static boolean add(Cerveja cerveja)
    {
	try
	{
	    BancoFake.getTB_CERVEJA().add(cerveja);
	    return true;
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	    return false;
	}
    }

    public static boolean remove(int id)
    {
	try
	{
	    //percorre a lista se encontrar :
	    for (Cerveja cerv : BancoFake.getTB_CERVEJA())
	    {
		if (cerv.getId() == id)
		{
		    BancoFake.getTB_CERVEJA().remove(cerv);
		    return true;
		}
	    }

	    System.out.println("Cerveja " + id + " não encontrada!");
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}
	return false;
    }

    public static boolean update(Cerveja cerveja)
    {
	try
	{
	    //percorre a lista se encontrar :
	    for (Cerveja cerv : BancoFake.getTB_CERVEJA())
	    {
		if (cerv.getId() == cerveja.getId())
		{
		    //remove a cerveja OLD
		    BancoFake.getTB_CERVEJA().remove(cerv);

		    //Adiciona a cerveja Nova com mesmo id
		    BancoFake.getTB_CERVEJA().add(cerveja);

		    return true;
		}
	    }
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}
	return false;
    }

    public static void printAll(ArrayList<Cerveja> lista)
    {
	if (lista != null)
	{
	    System.out.println("\nTABELA CERVEJA ====================================================");

	    //percorre a lista
	    for (Cerveja cerv : BancoFake.getTB_CERVEJA())
	    {
		System.out.println(cerv.toString());
	    }

	    System.out.println("===================================================================");

	    return;
	}
	System.out.println("Lsta Vazia!");

    }

}
