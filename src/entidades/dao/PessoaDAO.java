/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.dao;

import bdFake.BancoFake;
import entidades.Pessoa;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class PessoaDAO
{
    //CRUD PESSOA ============================================================== 
    public static Pessoa findByID(int id)
    {
	//percorre a lista se encontrar :
	for (Pessoa pes : BancoFake.getTB_PESSOA())
	{
	    if (pes.getId() == id)
	    {
		return pes;
	    }
	}
	return null;
    }

    public static boolean add(Pessoa pessoa)
    {
	try
	{
	    BancoFake.getTB_PESSOA().add(pessoa);
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
	    for (Pessoa pes : BancoFake.getTB_PESSOA())
	    {
		if (pes.getId() == id)
		{
		    BancoFake.getTB_PESSOA().remove(pes);
		    return true;
		}
	    }
	    
	   System.out.println("Pessoa " + id + " não encontrada!");
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}
	return false;
    }

    public static boolean update(Pessoa pessoa)
    {
	try
	{
	    //percorre a lista se encontrar :
	    for (Pessoa pes : BancoFake.getTB_PESSOA())
	    {
		if (pes.getId() == pessoa.getId())
		{
		    //remove a pessoa OLD
		    BancoFake.getTB_PESSOA().remove(pes);

		    //Adiciona a pessoa Nova com mesmo id
		    BancoFake.getTB_PESSOA().add(pessoa);

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

    public static void printAll(ArrayList<Pessoa> lista)
    {
	if (lista != null)
	{
	    System.out.println("\nTABELA PESSOA =====================================================");

	    //percorre a lista
	    for (Pessoa pes : BancoFake.getTB_PESSOA())
	    {
		System.out.println(pes.toString());
	    }

	    System.out.println("===================================================================");

	    return;
	}
	System.out.println("Lsta Vazia!");

    }

}
