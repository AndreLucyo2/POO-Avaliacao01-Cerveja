/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import bdFake.BancoFake;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class Pessoa
{

    private int id;
    private String nome;
    private String sexo;
    private int idade;

    //associação:
    private ArrayList<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();

    public Pessoa()
    {
    }

    public Pessoa(String nome, String sexo, int idade)
    {
	setId();
	this.nome = nome;
	this.sexo = sexo;
	this.idade = idade;
    }

    public Pessoa(int id, String nome, String sexo, int idade)
    {
	this.id = id;
	this.nome = nome;
	this.sexo = sexo;
	this.idade = idade;
    }

    public int getId()
    {
	return id;
    }

    //pessoa nova pega o ultimo id
    private void setId()
    {
	this.id = ultimoID() + 1;
    }

    public String getNome()
    {
	return nome;
    }

    public void setNome(String nome)
    {
	this.nome = nome;
    }

    public String getSexo()
    {
	return sexo;
    }

    public void setSexo(String sexo)
    {
	this.sexo = sexo;
    }

    public int getIdade()
    {
	return idade;
    }

    public void setIdade(int idade)
    {
	this.idade = idade;
    }

    public ArrayList<Avaliacao> getAvaliacoes()
    {
	return avaliacoes;
    }

    //Descobre o maior id da lista no bancoFake
    private int ultimoID()
    {
	int id = 0;
	int cont = 0;
	//Carrega a tabela pessoa
	ArrayList<Pessoa> tb_pessoas = BancoFake.getTB_PESSOA();

	try
	{
	    //percorre a lista se encontrar o maios ID:
	    for (Pessoa pes : tb_pessoas)
	    {
		if (cont == 0)
		{
		    id = pes.getId();
		}

		if (pes.getId() > id)
		{
		    id = pes.getId();
		}

		cont += cont;

	    }
	}
	catch (Exception e)
	{
	    e.printStackTrace();
	}
	return id;
    }

    @Override
    public String toString()
    {
	return "Pessoa{" + "id=" + id + ", nome=" + nome + ", sexo=" + sexo + ", idade=" + idade + ", avaliacoes=" + avaliacoes + '}';
    }

}
