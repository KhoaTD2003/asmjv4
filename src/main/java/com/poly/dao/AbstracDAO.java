package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.poly.dto.VideoLikedInfo;
import com.poly.util.JpaUtil;

public class AbstracDAO<T> {
	public static final EntityManager entityManager =  JpaUtil.getFactory().createEntityManager();
	
	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
	entityManager.close();
	super.finalize();
	}
		
	public T findById(Class<T> clazz ,Integer id) {
		return entityManager.find(clazz, id);
	}
	public List<T> findAll(Class<T> clazz, boolean existIsActive ) {
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		 sql.append("select o from ").append(entityName).append(" o");
		 if(existIsActive == true) {
			 sql.append(" where isActive = 1");
		 }
		 TypedQuery<T> q = entityManager.createQuery(sql.toString(),clazz);
		return q.getResultList();
	}
	
	public List<T> findAll(Class<T> clazz, boolean existIsActive ,int pageNumber ,int pageSize) {
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		 sql.append("select o from").append(entityName).append(" o");
		 if(existIsActive == true) {
			 sql.append(" where isActive = 1");
		 }
		 TypedQuery<T> q = entityManager.createQuery(sql.toString(),clazz);
		 q.setFirstResult((pageNumber-1)*pageSize); //vi tri bat dau
		 q.setMaxResults(pageSize);					//soluong tt toi da
		return q.getResultList();
	}
	public T findOne(Class<T> clazz ,String sql,Object...params) {
		TypedQuery<T> q = entityManager.createQuery(sql,clazz);
		for(int i = 0; i< params.length ; i++) {
			q.setParameter(i, params[i]);
		}
		List<T> result = q.getResultList();
		if(result.isEmpty()) {
			return null;
		}
		return result.get(0);
		
	}
	public List<T> findMany(Class<T> clazz ,String sql,Object...params) {
		TypedQuery<T> q = entityManager.createQuery(sql,clazz);
		for(int i = 0; i< params.length ; i++) {
			q.setParameter(i, params[i]);
		}
		
		return q.getResultList();	
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findManyByNativeQuery(String sql,Object...params) {
		Query q = entityManager.createQuery(sql);
		for(int i = 0; i< params.length ; i++) {
			q.setParameter(i, params[i]);
		}
		
		return q.getResultList();	
	}

	public T create(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			System.out.println("create succeed");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("cannot insert"+entity.getClass().getSimpleName()+"to db");
			throw new RuntimeException(e);
		}
	}
	
	public T update(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			System.out.println("update succeed");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("cannot update"+entity.getClass().getSimpleName()+"to db");
			throw new RuntimeException(e);
		}
	}
	
	public T delete(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			System.out.println("delete succeed");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			System.out.println("cannot delete"+entity.getClass().getSimpleName()+"to db");
			throw new RuntimeException(e);
		}
	}

	public List<VideoLikedInfo> findVideoLikedInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
