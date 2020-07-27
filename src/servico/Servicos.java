/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import bdFake.BancoFake;
import entidades.Cerveja;
import entidades.Pessoa;
import entidades.dao.CervejaDAO;
import entidades.dao.PessoaDAO;
import java.util.Scanner;

/**
 *
 * @author Andre
 */
public class Servicos
{

    public void printCabecalho(int cont)
    {
	if (cont <= 1)
	{
	    System.out.println("#########################################################");
	    System.out.println("#              AVALIAÇÃO DE CERVEJAS                    #");
	    System.out.println("#########################################################");
	    System.out.println("-----------------------------------------------------------");
	    System.out.println("            INICIO AVALIAÇÃO " + cont + "                  ");
	    System.out.println("-----------------------------------------------------------");

	}
	else
	{
	    System.out.println("-----------------------------------------------------------");
	    System.out.println("            INICIO AVALIAÇÃO " + cont + "                 ");
	    System.out.println("-----------------------------------------------------------");

	}

    }

    public int idPessoaNova()
    {
	Scanner scan = new Scanner(System.in);

	Pessoa novaPessoa = new Pessoa();

	System.out.println("\nCADASTRANDO NOVA PESSOA ...");
	System.out.print("Informe Nome:");
	novaPessoa.setNome(scan.next());

	System.out.print("Informe sexo:");
	novaPessoa.setSexo(scan.next());

	System.out.print("Informe Idade:");
	novaPessoa.setIdade(scan.nextInt());

	//GRAVA PESSOA:
	PessoaDAO.add(novaPessoa);

	//PEGA O ID gerado
	return novaPessoa.ultimoID();

    }

    public int idPessoaSelecionada(BancoFake bd)
    {
	Scanner scan = new Scanner(System.in);

	System.out.println("\nSELECIONANDO NOVA PESSOA >>>>>>>>>>>>>>>>>>>>>>>>");
	System.out.print("\nPara selecionar a pessoa informe o ID:");

	//MOSTRA PESSOAS CADSTRADAS:
	PessoaDAO.printAll(bd.getTB_PESSOA());

	return scan.nextInt();

    }

    public int idCervejaNova()
    {
	Scanner scan = new Scanner(System.in);

	Cerveja novaCerveja = new Cerveja();

	System.out.println("\nCADASTRANDO NOVA CERVEJA ...");
	System.out.print("Informe Nome:");
	novaCerveja.setNome(scan.next());

	System.out.print("Informe Marca:");
	novaCerveja.setMarca(scan.next());

	System.out.print("Informe Descrição:");
	novaCerveja.setDescricao(scan.next());

	System.out.print("Informe Teor Alcoolico:");
	novaCerveja.setTeorAlcoolico(scan.nextInt());

	//GRAVA CERVEJA:
	CervejaDAO.add(novaCerveja);

	//PEGA O ID gerado
	return novaCerveja.ultimoID();

    }

    public int idCervejaSelecionada(BancoFake bd)
    {
	Scanner scan = new Scanner(System.in);

	System.out.println("\nSELECIONANDO NOVA CERVEJA >>>>>>>>>>>>>>>>>>>>>>>");
	System.out.print("\nPara selecionar a Cerveja informe o ID:");

	//MOSTRA CERVEJA CADASTRADA:
	CervejaDAO.printAll(bd.getTB_CERVEJA());

	return scan.nextInt();

    }
}
