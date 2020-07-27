/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import bdFake.BancoFake;
import java.util.ArrayList;

/*
ASSOCIAÇÃO DE CLASSES:

	Cerveja   1 ------- N Avaliacao
        
	Avaliacao N ------- 1 Pessoa

 */
/**
 *
 * @author Andre
 */
public class Avaliacao
{

    private int id;
    private int pontuacao;

    //Associação:
    private Pessoa pessoa;
    private Cerveja cerveja;

    public Avaliacao()
    {
    }

    public Avaliacao(int pontuacao, Pessoa pessoa, Cerveja cerveja)
    {
	setId();
	this.pontuacao = pontuacao;
	this.pessoa = pessoa;
	this.cerveja = cerveja;
    }

    public Avaliacao(int id, int pontuacao, Pessoa pessoa, Cerveja cerveja)
    {
	this.id = id;
	this.pontuacao = pontuacao;
	this.pessoa = pessoa;
	this.cerveja = cerveja;
    }

    public int getId()
    {
	return id;
    }

    private void setId()
    {
	this.id = ultimoID() + 1;
    }

    public int getPontuacao()
    {
	return pontuacao;
    }

    public void setPontuacao(int pontuacao)
    {
	if (pontuacaoIsValid(pontuacao))
	{
	    this.pontuacao = pontuacao;
	}
    }

    //valida se pontuação esta entre 0 e 10:
    public static boolean pontuacaoIsValid(int ponto)
    {
	return (ponto >= 0) & (ponto <= 10);
    }

    public Pessoa getPessoa()
    {
	return pessoa;
    }

    public void setPessoa(Pessoa pessoa)
    {
	this.pessoa = pessoa;
    }

    public Cerveja getCerveja()
    {
	return cerveja;
    }

    public void setCerveja(Cerveja cerveja)
    {
	this.cerveja = cerveja;
    }

    //Descobre o maior id da lista no bancoFake
    private int ultimoID()
    {
	int id = 0;
	int cont = 0;
	//Carrega a tabela pessoa
	ArrayList<Avaliacao> tb_avaliacao = BancoFake.getTB_AVALIACAO();

	try
	{
	    //percorre a lista se encontrar o maios ID:
	    for (Avaliacao aval : tb_avaliacao)
	    {
		if (cont == 0)
		{
		    id = aval.getId();
		}

		if (aval.getId() > id)
		{
		    id = aval.getId();
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
	return "Avaliacao{" + "id=" + id + ", pontuacao=" + pontuacao + "\n, pessoa=" + pessoa + "\n, cerveja=" + cerveja + '}';
    }

}
