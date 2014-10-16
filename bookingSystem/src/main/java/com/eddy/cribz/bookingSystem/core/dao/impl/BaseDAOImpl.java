package com.eddy.cribz.bookingSystem.core.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eddy.cribz.bookingSystem.core.dao.BaseDAO;
import com.eddy.cribz.bookingSystem.core.security.util.ProcnetSecurityUtil;
import com.eddy.cribz.bookingSystem.model.ParentEntity;
import com.eddy.cribz.bookingSystem.model.RecordStatus;
import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;


@Repository("BaseDAO")
public abstract class BaseDAOImpl<T> extends GenericDAOImpl<T, String>
		implements BaseDAO<T> {

	private EntityManager entityManager;

	public void delete(T entity) {
		if (entity != null) {
			if (entity instanceof ParentEntity) {
				((ParentEntity) entity).setRecordStatus(RecordStatus.DELETED);
				this.save(entity);
			}
		}

	}

	public <T1> T1 getEntityById(Class<T1> type, String id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T1> criteriaQuery = criteriaBuilder.createQuery(type);
		Root<T1> from = criteriaQuery.from(type);
		criteriaQuery.select(from).where(
				criteriaBuilder.equal(from.get("id"), id));
		return entityManager.createQuery(criteriaQuery).getSingleResult();

	}

	public <T> void mergeEntity(T entity) {
		super._merge(entity);
	}

	@Override
	public T save(T entity) {

		if (entity == null)
			return null;

		if (entity instanceof ParentEntity) {
			if (StringUtils.isBlank(((ParentEntity) entity).getId())) {
				((ParentEntity) entity).setId(null);

				ParentEntity obj = (ParentEntity) entity;
				obj.setDateCreated(Calendar.getInstance().getTime());
				try {
					obj.setCreatedBy(ProcnetSecurityUtil.getLoggedInUser());
				} catch (Exception e) {
				}
			}

			else {
				ParentEntity obj = (ParentEntity) entity;
				obj.setDateChanged(Calendar.getInstance().getTime());
				try {
					obj.setChangedBy(ProcnetSecurityUtil.getLoggedInUser());
				} catch (Exception e) {
				}
			}
		}

		return super.save(entity);
	}

	public T saveConsolidatedPlan(T entity) {
		if (entity == null)
			return null;

		if (entity instanceof ParentEntity) {
			if (StringUtils.isBlank(((ParentEntity) entity).getId())) {
				((ParentEntity) entity).setId(null);

				ParentEntity obj = (ParentEntity) entity;
				obj.setDateCreated(Calendar.getInstance().getTime());
				try {
					obj.setCreatedBy(ProcnetSecurityUtil.getLoggedInUser());
				} catch (Exception e) {
				
				}
			}

		}

		return super.save(entity);
	}

	public List<T> searchAll() {
		Search search = new Search();
		search.copy();
		return search(search);
	}

	public List<T> searchByPropertyEqual(String property, Object value) {
		Search search = new Search();
		search.addFilterEqual(property, value);
		search.addFilterEqual("recordStatus", RecordStatus.ACTIVE);
		return search(search);
	}

	public List<T> searchByPropertyEqual(String property, Object value,
			RecordStatus recordStatus) {
		Search search = new Search();
		search.addFilterEqual(property, value);
		search.addFilterEqual("recordStatus", recordStatus);
		return search(search);
	}

	public List<T> searchByRecordStatus(RecordStatus recordStatus) {
		Search search = new Search();
		search.addFilterEqual("recordStatus", recordStatus);
		return search(search);
	}

	public T searchUniqueByPropertyEqual(String property, Object value) {
		Search search = new Search();
		search.addFilterEqual(property, value);
		search.addFilterEqual("recordStatus", RecordStatus.ACTIVE);
		return (T) searchUnique(search);
	}

	public T searchUniqueByPropertyEquals(String property, Object value) {
		Search search = new Search();
		search.addFilterEqual(property, value);
		return (T) searchUnique(search);
	}

	@Autowired
	@Override
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
		this.entityManager = entityManager;
	}

	@Override
	@Autowired
	public void setSearchProcessor(JPASearchProcessor searchProcessor) {
		super.setSearchProcessor(searchProcessor);
	}

	public T update(T entity) {
		return this.save(entity);
	}

	public <T> void updateEntity(T entity) {
		entityManager.merge(entity);
	}

}