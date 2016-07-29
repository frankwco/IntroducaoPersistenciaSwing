/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Produto;
import modelo.dao.DAOProduto;

/**
 *
 * @author Aluno
 */
public class Teste1 {

    public static void main(String[] args) {
        DAOProduto daoP = new DAOProduto();
        Produto p = daoP.buscarPorId(1L);
        p.setDescricao("Novo Teclado");
        daoP.alterar(p);

        //daoP.remover(p);
    }
}
