package br.edu.ifg.luziania.model.dao;

import br.edu.ifg.luziania.model.entity.Partida;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Dependent
public class PartidaDAO {
    @Inject
    EntityManager em;

    public void save(Partida entity){
        em.persist(entity);
    }

    public List<Partida> getAllPartidas(){
        Query query = em.createQuery("from Partida");
        return (List<Partida>) query.getResultList();
    }
}
