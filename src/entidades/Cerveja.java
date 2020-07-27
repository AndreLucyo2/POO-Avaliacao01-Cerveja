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
public class Cerveja
{

    private int id;
    private String nome;
    private String marca;
    private String descricao;
    private int teorAlcoolico;

    private ArrayList<Avaliacao> cervejas = new ArrayList<Avaliacao>();

    public Cerveja()
    {
    }

    public Cerveja(String nome, String marca, String descricao, int teorAlcoolico)
    {
	setId();
	this.nome = nome;
	this.marca = marca;
	this.descricao = descricao;
	this.teorAlcoolico = teorAlcoolico;
    }

    public Cerveja(int id, String nome, String marca, String descricao, int teorAlcoolico)
    {
	this.id = id;
	this.nome = nome;
	this.marca = marca;
	this.descricao = descricao;
	this.teorAlcoolico = teorAlcoolico;
    }

    public int getId()
    {
	return id;
    }

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

    public String getMarca()
    {
	return marca;
    }

    public void setMarca(String marca)
    {
	this.marca = marca;
    }

    public String getDescricao()
    {
	return descricao;
    }

    public void setDescricao(String descricao)
    {
	this.descricao = descricao;
    }

    public int getTeorAlcoolico()
    {
	return teorAlcoolico;
    }

    public void setTeorAlcoolico(int teorAlcoolico)
    {
	this.teorAlcoolico = teorAlcoolico;
    }

    //Descobre o maior id da lista no bancoFake
    public int ultimoID()
    {
	int id = 0;
	int cont = 0;
	
	//Carrega a tabela pessoa
	ArrayList<Cerveja> tb_Cerveja = BancoFake.getTB_CERVEJA();

	try
	{
	    //percorre a lista se encontrar o maios ID:
	    for (Cerveja cerv : tb_Cerveja)
	    {
		if (cont == 0)
		{
		    id = cerv.getId();
		}

		if (cerv.getId() > id)
		{
		    id = cerv.getId();
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
	return "Cerveja{" + "id=" + id + ", nome=" + nome + ", marca=" + marca + ", teorAlcoolico=" + teorAlcoolico + "%" + ",\ndescricao=" + descricao + '}' + "\n";
    }

}
