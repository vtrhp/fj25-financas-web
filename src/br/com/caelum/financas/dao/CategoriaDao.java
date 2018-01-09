package br.com.caelum.financas.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Categoria;

@Stateless
public class CategoriaDao {
	@Inject //@PersistenceContext
	private EntityManager manager;
	
	public Categoria procura(Integer id) {
		String jpql = "select c from Categoria c where c.id = :id ";
		TypedQuery<Categoria> query = this.manager.createQuery(jpql, Categoria.class);
		query.setParameter("id", id);		
		return query.getSingleResult();
	}
	
	public List<Categoria> lista(){
		String jpql = "select c from Categoria c ";
		TypedQuery<Categoria> query = this.manager.createQuery(jpql, Categoria.class);
		
		return query.getResultList();
	}

}
