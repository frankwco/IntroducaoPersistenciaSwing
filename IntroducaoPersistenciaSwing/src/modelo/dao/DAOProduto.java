/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Cliente;
import modelo.Produto;

/**
 *
 * @author Aluno
 */
public class DAOProduto {

    public void salvar(Produto pro) {
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("TestePersistenciaPU");
        EntityManager em = fac.createEntityManager();
        em.getTransaction().begin();

        em.persist(pro);

        em.getTransaction().commit();
        em.close();
        fac.close();
    }

    public void alterar(Produto pro) {
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("TestePersistenciaPU");
        EntityManager em = fac.createEntityManager();
        em.getTransaction().begin();

        em.merge(pro);

        em.getTransaction().commit();
        em.close();
        fac.close();
    }

    public void remover(Produto pro) {
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("TestePersistenciaPU");
        EntityManager em = fac.createEntityManager();
        em.getTransaction().begin();

        if (pro.getId() != null) {
            Produto produtoBanco=em.find(Produto.class, pro.getId());
            em.remove(produtoBanco);
        }

        em.getTransaction().commit();
        em.close();
        fac.close();
    }

    public Produto buscarPorId(Long id) {
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("TestePersistenciaPU");
        EntityManager em = fac.createEntityManager();
        em.getTransaction().begin();

        //O find busca por id
        Produto pro = em.find(Produto.class, id);
        
        em.getTransaction().commit();
        em.close();
        fac.close();
        return pro;
    }
    
    public List<Produto> buscarPorDescricao(String desc) {
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("TestePersistenciaPU");
        EntityManager em = fac.createEntityManager();
        em.getTransaction().begin();

        String consulta="from Produto where descricao like '%"+desc+"'%";
        List<Produto> lp=em.createQuery(consulta).getResultList();
        
        em.getTransaction().commit();
        em.close();
        fac.close();
        return lp;
    }

}
