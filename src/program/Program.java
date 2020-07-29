/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import bdFake.BancoFake;
import entidades.Avaliacao;
import entidades.dao.AvaliacaoDAO;
import entidades.dao.CervejaDAO;
import entidades.dao.PessoaDAO;
import java.text.ParseException;
import java.util.Scanner;
import servicos.Servico;

/**
 *
 * @author Andre
 */
public class Program
{

    public static void main(String[] args) throws ParseException
    {
	//+++++++++++++++++++++++++++++++++++++++++++
	//BANCO KAKE:
	BancoFake bd = new BancoFake();
	//+++++++++++++++++++++++++++++++++++++++++++

	Scanner scan = new Scanner(System.in);
	
	int idPessoa = 0;
	int idCerveja = 0;
	int cont = 1;
	String continuar="";

	do
	{
	    //Mostra cabeçalho inicial:
	    new Servico().printCabecalho(cont);

	    //PESSOA:
	    System.out.print("Cadastrar nova pessoa? S/N ");
	    String cadastrarP = scan.next().toUpperCase();
	    if (cadastrarP.equals("S"))
	    {
		//PEGA O ID gerado
		idPessoa = new Servico().idPessoaNova();
	    }
	    else
	    {
		//PEGA ID SELECIONADO:
		idPessoa = new Servico().idPessoaSelecionada(bd);

		if (PessoaDAO.findByID(idPessoa) == null)
		{
		    System.out.println("\nId Inválido!");
		    break;
		}

	    }

	    //CERVEJA:
	    System.out.print("\nCadastrar nova Cerveja? S/N ");
	    String cadastrarC = scan.next().toUpperCase();

	    if (cadastrarC.equals("S"))
	    {
		//PEGA O ID gerado
		idCerveja = new Servico().idCervejaNova();
	    }
	    else
	    {
		//PEGA ID SELECIONADO:
		idCerveja = new Servico().idCervejaSelecionada(bd);

		if (CervejaDAO.findById(idCerveja) == null)
		{
		    System.out.println("\nId Inválido!");
		    break;
		}

	    }

	    //valida regra da pontuação:
	    int pontos;
	    do
	    {
		System.out.println("\nInforme uma pontuação entre 0 e 10, para a cerveja selecionada:");

		pontos = scan.nextInt();
	    }
	    while (!Avaliacao.pontuacaoIsValid(pontos));

	    //AVALIACAO:
	    Avaliacao avaliacao1 = new Avaliacao(pontos, PessoaDAO.findByID(idPessoa), CervejaDAO.findById(idCerveja));

	    //GRAVA AVALIAÇÃO:
	    AvaliacaoDAO.add(avaliacao1);

	    System.out.println("\nDeseja fazer nova avaliaçao? S/N ");
	    continuar = scan.next().toUpperCase();
	    cont += cont;
	}
	while (continuar.equals("S"));

	//Mostra tabela das avaliações:
	AvaliacaoDAO.printAll(bd.getTB_AVALIACAO());

    }

}
