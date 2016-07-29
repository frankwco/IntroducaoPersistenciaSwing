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

/**
 *
 * @author Frank
 */
public class DAOCliente {
    private EntityManager em;

    public void salvar(Cliente cli) {
        //EntityManagerFactory fac = Persistence.createEntityManagerFactory("TestePersistenciaPU");
        em = CriarEntityManager.getInstancia().getEm();
        em.getTransaction().begin();

        em.persist(cli);

        em.getTransaction().commit();
        //em.close();
        //fac.close();
    }
    public void alterar(Cliente cli) {
        //EntityManagerFactory fac = Persistence.createEntityManagerFactory("TestePersistenciaPU");
        em = CriarEntityManager.getInstancia().getEm();
        em.getTransaction().begin();

        em.merge(cli);

        em.getTransaction().commit();
        //em.close();
        //fac.close();
    }
    

    public void remover(Cliente cli) {
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("TestePersistenciaPU");
        EntityManager em = fac.createEntityManager();
        em.getTransaction().begin();

        em.remove(cli);

        em.getTransaction().commit();
        em.close();
        fac.close();
    }

    public void buscaId2() {
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("TestePersistenciaPU");
        EntityManager em = fac.createEntityManager();
        em.getTransaction().begin();

        Cliente c = em.find(Cliente.class, 2L);
        System.out.println("Cliente: " + c.getNome());

        em.getTransaction().commit();
        em.close();
        fac.close();
    }

    public List<Cliente> listaClientes() {
        List<Cliente> listaClientes;
        em = CriarEntityManager.getInstancia().getEm();
       
        listaClientes = em.createQuery("from Cliente").getResultList();
     
        return listaClientes;
    }

}
