/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package program;

import entidades.dao.AvaliacaoDAO;
import entidades.dao.CervejaDAO;
import entidades.dao.PessoaDAO;
import bdFake.BancoFake;
import java.text.ParseException;

/**
 *
 * @author Andre
 */
public class TestBancoFake
{

    public static void main(String[] args) throws ParseException
    {
	//+++++++++++++++++++++++++++++++++++++++++++
	//BANCO KAKE:
	BancoFake bd = new BancoFake();
	//+++++++++++++++++++++++++++++++++++++++++++

	//TESTE PESSOA:
	PessoaDAO.printAll(bd.getTB_PESSOA());
	PessoaDAO.remove(2);
	PessoaDAO.printAll(bd.getTB_PESSOA());

	//TESTE CERVEJA
	CervejaDAO.printAll(bd.getTB_CERVEJA());
	CervejaDAO.remove(8);
	CervejaDAO.printAll(bd.getTB_CERVEJA());

	//TESTE AVALIACAO
	AvaliacaoDAO.printAll(bd.getTB_AVALIACAO());
	AvaliacaoDAO.remove(8);
	AvaliacaoDAO.printAll(bd.getTB_AVALIACAO());

    }
}
