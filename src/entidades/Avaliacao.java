/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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

    public void setId(int id)
    {
	this.id = id;
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
    public boolean pontuacaoIsValid(int ponto)
    {
	return (ponto <= 0) & (ponto <= 10);
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

    @Override
    public String toString()
    {
	return "Avaliacao{" + "id=" + id + ", pontuacao=" + pontuacao + "\n, pessoa=" + pessoa + "\n, cerveja=" + cerveja + '}';
    }

}
