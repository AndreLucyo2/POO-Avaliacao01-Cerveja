/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.dao;

import bdFake.BancoFake;
import entidades.Avaliacao;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class AvaliacaoDAO
{
    //CRUD AVALIACAO ============================================================== 
    public static Avaliacao findByID(int id)
    {
	//percorre a lista se encontrar :
	for (Avaliacao aval : BancoFake.getTB_AVALIACAO())
	{
	    if (aval.getId() == id)
	    {
		return aval;
	    }
	    else
	    {
		System.out.println("Avaliacao " + id + " não encontrada!");
	    }
	}
	return null;
    }

    public static boolean add(Avaliacao pessoa)
    {
	try
	{
	    BancoFake.getTB_AVALIACAO().add(pessoa);
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
	    for (Avaliacao aval : BancoFake.getTB_AVALIACAO())
	    {
		if (aval.getId() == id)
		{
		    BancoFake.getTB_AVALIACAO().remove(aval);
		    return true;
		}
	    }
	    
	    System.out.println("Avaliacao " + id + " não encontrada!");
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}
	return false;
    }

    public static boolean update(Avaliacao pessoa)
    {
	try
	{
	    //percorre a lista se encontrar :
	    for (Avaliacao aval : BancoFake.getTB_AVALIACAO())
	    {
		if (aval.getId() == pessoa.getId())
		{
		    //remove a pessoa OLD
		    BancoFake.getTB_AVALIACAO().remove(aval);

		    //Adiciona a pessoa Nova com mesmo id
		    BancoFake.getTB_AVALIACAO().add(pessoa);

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

    public static void printAll(ArrayList<Avaliacao> lista)
    {
	if (lista != null)
	{
	    System.out.println("\nTABELA AVALIACAO =====================================================");

	    //percorre a lista
	    for (Avaliacao aval : BancoFake.getTB_AVALIACAO())
	    {
		System.out.println(aval.toString()+"\n");
	    }

	    System.out.println("===================================================================");

	    return;
	}
	System.out.println("Lsta Vazia!");

    }

}
