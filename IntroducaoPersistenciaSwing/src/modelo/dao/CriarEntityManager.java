/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Aluno
 */
public class CriarEntityManager {
    //Padrão Singleton: garante uma única instância da classe
    private static CriarEntityManager criarem;
    private EntityManager em;
    
    private CriarEntityManager(){
        em=Persistence.createEntityManagerFactory("TestePersistenciaPU")
                .createEntityManager();
    }
    
    public static CriarEntityManager getInstancia(){
        if(criarem==null){
            criarem=new CriarEntityManager();
        }
        return criarem;
    }
    public EntityManager getEm(){
        return em;
    }
}
