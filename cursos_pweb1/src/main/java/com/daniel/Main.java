package com.daniel;

import java.util.Optional;

import com.daniel.dao.InstrutorDAOImpl;
import com.daniel.db.DBFactory;
import com.daniel.entities.Instrutor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursosPU");
        EntityManager em = emf.createEntityManager();
        
        InstrutorDAOImpl instrutorDAO = new InstrutorDAOImpl();
        Instrutor novoInstrutor = new Instrutor();
        novoInstrutor.setNome("Carlos Eduardo");
        novoInstrutor.setEmail("carlos.eduardo@example.com");
        novoInstrutor.setBiografia("Especialista em desenvolvimento de software e arquitetura de sistemas.");

        // Persistindo o novo instrutor
        instrutorDAO.salvar(novoInstrutor);

        // Buscando o instrutor pelo ID
        Optional<Instrutor> instrutorEncontrado = instrutorDAO.buscarPorId(novoInstrutor.getId());
        if (instrutorEncontrado.isPresent()) {
            System.out.println("Instrutor encontrado: " + instrutorEncontrado.get().getNome());
        } else {
            System.out.println("Instrutor não encontrado.");
        }

        // Atualizando o instrutor
        novoInstrutor.setNome("Carlos E. Silva");
        instrutorDAO.atualizar(novoInstrutor);

        // Removendo o instrutor
        instrutorDAO.remover(novoInstrutor.getId());

        // Fechando a fábrica de EntityManager
        DBFactory.fechar();
      

    }
}