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
public class Teste2 {

    public static void main(String[] args) {
        Produto p = new Produto();
        p.setDescricao("Computador");
        p.setValor(100.);
        
        DAOProduto dao=new DAOProduto();
        dao.salvar(p);
    }
}
