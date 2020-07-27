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

	System.out.println("#########################################################");
	System.out.println("#              AVALIAÇÃO DE CERVEJAS                    #");
	System.out.println("#########################################################");

	System.out.println("\nInforme o ID da pessoa apresentado na tabela abaixo:");

	PessoaDAO.printAll(bd.getTB_PESSOA());
	int idPessoa = scan.nextInt();

	System.out.println("\nInforme o ID da Cerveja que sera avaliada apresentado na tabela abaixo:");
	CervejaDAO.printAll(bd.getTB_CERVEJA());
	int idCerveja = scan.nextInt();

	//valida regra da pontuação:
	int pontos;
	do
	{
	    System.out.println("\nInforme uma pontuação entre 0 e 10, para a cerveja selecionada:");
	    pontos = scan.nextInt();
	}
	while (!Avaliacao.pontuacaoIsValid(pontos));
	
	Avaliacao avaliacao1 = new Avaliacao(pontos, PessoaDAO.findByID(idPessoa), CervejaDAO.findById(idCerveja));

	AvaliacaoDAO.add(avaliacao1);

	AvaliacaoDAO.printAll(bd.getTB_AVALIACAO());

    }
}
