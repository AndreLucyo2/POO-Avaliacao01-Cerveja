/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdFake;

import entidades.Avaliacao;
import entidades.Cerveja;
import entidades.Pessoa;
import entidades.dao.CervejaDAO;
import entidades.dao.PessoaDAO;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class BancoFake
{

    private static final ArrayList<Pessoa> TB_PESSOA = new ArrayList<Pessoa>();
    private static final ArrayList<Cerveja> TB_CERVEJA = new ArrayList<Cerveja>();
    private static final ArrayList<Avaliacao> TB_AVALIACAO = new ArrayList<Avaliacao>();

    public BancoFake()
    {
	seedTB_Pessoa();
	seedTB_Cerveja();
	seedTB_Avaliacao();
    }

    //criar dados na tabela fake
    private static void seedTB_Pessoa()
    {

	//criando elementos
	Pessoa pessoa1 = new Pessoa(1, "Andre", "Masc", 37);
	Pessoa pessoa2 = new Pessoa(2, "Lucas", "Masc", 23);
	Pessoa pessoa3 = new Pessoa(3, "Andreia", "Fem", 35);
	Pessoa pessoa4 = new Pessoa(4, "Tiago", "Masc", 48);
	Pessoa pessoa5 = new Pessoa(5, "Maria", "Tem", 20);

	//Adiciona Elementos na lista
	TB_PESSOA.add(pessoa1);
	TB_PESSOA.add(pessoa2);
	TB_PESSOA.add(pessoa3);
	TB_PESSOA.add(pessoa4);
	TB_PESSOA.add(pessoa5);

    }

    //criar dados na tabela fake
    private static void seedTB_Cerveja()
    {
	//criando elementos
	Cerveja cerveja1 = new Cerveja(1, "Skol", "Carlsberg", "Skol é uma marca de cerveja de propriedade da empresa dinamarquesa Carlsberg, com licença para ser fabricada no Brasil.", 29);
	Cerveja cerveja2 = new Cerveja(2, "Brahma", "Brahma", "Brahma é uma marca de cerveja com licença para ser fabricada no Brasil.", 17);
	Cerveja cerveja3 = new Cerveja(3, "Antártica", "Antártica", "Antártica é uma marca de cerveja com licença para ser fabricada no Brasil.", 10);
	Cerveja cerveja4 = new Cerveja(4, "Heineken", "Heineken", "Heineken é uma marca de cerveja com licença para ser fabricada no Brasil.", 27);

	//Adiciona Elementos na lista
	TB_CERVEJA.add(cerveja1);
	TB_CERVEJA.add(cerveja2);
	TB_CERVEJA.add(cerveja3);
	TB_CERVEJA.add(cerveja4);

    }

    //criar dados na tabela fake
    private static void seedTB_Avaliacao()
    {
	Avaliacao avaliacao1 = new Avaliacao(1, 2, PessoaDAO.findByID(1), CervejaDAO.findById(1));
	Avaliacao avaliacao2 = new Avaliacao(2, 5, PessoaDAO.findByID(3), CervejaDAO.findById(3));
	Avaliacao avaliacao3 = new Avaliacao(3, 0, PessoaDAO.findByID(1), CervejaDAO.findById(2));
	Avaliacao avaliacao4 = new Avaliacao(4, 10, PessoaDAO.findByID(6), CervejaDAO.findById(4));

	//Adiciona Elementos na lista
	TB_AVALIACAO.add(avaliacao1);
	TB_AVALIACAO.add(avaliacao2);
	TB_AVALIACAO.add(avaliacao3);
	TB_AVALIACAO.add(avaliacao4);

    }

    public static ArrayList<Pessoa> getTB_PESSOA()
    {
	return TB_PESSOA;
    }

    public static ArrayList<Cerveja> getTB_CERVEJA()
    {
	return TB_CERVEJA;
    }

    public static ArrayList<Avaliacao> getTB_AVALIACAO()
    {
	return TB_AVALIACAO;
    }
}
