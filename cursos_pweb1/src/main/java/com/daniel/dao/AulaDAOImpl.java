package com.daniel.dao;

import java.util.List;
import java.util.Optional;

import com.daniel.db.DBFactory;
import com.daniel.entities.Aula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class AulaDAOImpl implements GenericDao<Aula, Long> {

    @Override
    public Aula salvar(Aula entidade) {
        EntityManager em = DBFactory.criarEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(entidade);
            tx.commit();

            return entidade;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<Aula> buscarPorId(Long id) {
        EntityManager em = DBFactory.criarEntityManager();

        try {
            Aula aula = em.find(Aula.class, id);
            return Optional.ofNullable(aula);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Aula> buscarTodos() {
        EntityManager em = DBFactory.criarEntityManager();

        try {
            String jpql = "SELECT a FROM Aula a";
            TypedQuery<Aula> query = em.createQuery(jpql, Aula.class);

            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Aula atualizar(Aula entidade) {
        EntityManager em = DBFactory.criarEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Aula aulaAtualizada = em.merge(entidade);
            tx.commit();

            return aulaAtualizada;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void remover(Long id) {
        EntityManager em = DBFactory.criarEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Aula aula = em.find(Aula.class, id);

            if (aula != null) {
                em.remove(aula);
            } else {
                System.out.println("Aula não encontrada para remoção.");
            }

            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // Método adicional sugerido pelo exercício
    public List<Aula> buscarPorOrdem(Integer ordem) {
        EntityManager em = DBFactory.criarEntityManager();

        try {
            String jpql = "SELECT a FROM Aula a WHERE a.ordem = :ordem";

            TypedQuery<Aula> query = em.createQuery(jpql, Aula.class);
            query.setParameter("ordem", ordem);

            return query.getResultList();
        } finally {
            em.close();
        }
    }
}