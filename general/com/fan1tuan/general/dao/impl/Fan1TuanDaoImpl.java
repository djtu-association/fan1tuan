package com.fan1tuan.general.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.fan1tuan.general.dao.CriteriaWrapper;
import com.fan1tuan.general.dao.Fan1TuanDao;
import com.fan1tuan.general.dao.FieldFilter;
import com.fan1tuan.general.dao.Pageable;
import com.fan1tuan.general.dao.QueryWrapper;
import com.fan1tuan.general.dao.Sortable;
import com.fan1tuan.general.dao.UpdateWrapper;
import com.mongodb.WriteResult;

public class Fan1TuanDaoImpl<T> implements Fan1TuanDao<T>{

	private Logger logger; 
	
	protected MongoOperations mongoOperations;
	public void setTemplate(MongoTemplate template){
		this.mongoOperations = template;
	}
	public MongoTemplate getTemplate(){
		return (MongoTemplate)mongoOperations;
	}
	
	
	private Class<T> cls;
	/**
	 * Default constructor. 构造函数不传参，但是很重要，为继承的子类抽出泛型的Class对象，以便于 传给DAO方法
	 */
	@SuppressWarnings("unchecked")
	public Fan1TuanDaoImpl() {
		@SuppressWarnings("rawtypes")
		Class clazz = getClass();

		while (clazz != Object.class) {
			Type t = clazz.getGenericSuperclass();
			if (t instanceof ParameterizedType) {
				Type[] args = ((ParameterizedType) t).getActualTypeArguments();
				if (args[0] instanceof Class) {
					this.cls = (Class<T>) args[0];
					break;
				}
			}
			clazz = clazz.getSuperclass();
		}
		
		logger = LogManager.getLogger(getClass().getName());
		

	}
	
	
	@Override
	public void add(T paramT) {
		logger.entry(paramT);
		logger.info("In "+getClass().getName());
		mongoOperations.insert(paramT);
		logger.exit();
	}

	@Override
	public void addMulti(Collection<T> paramTs) {
		logger.entry(paramTs);
		logger.info("In "+getClass().getName());
		mongoOperations.insertAll(paramTs);
		//mongoOperations.insert(paramTs, cls);
		logger.exit();
	}
	
	@Override
	public void addMultiOneByOne(Collection<T> paramTs){
		logger.entry(paramTs);
		logger.info("In "+getClass().getName());
		for(T param : paramTs){
			mongoOperations.insert(param);
		}
		logger.exit();
	}

	@Override
	public void update(T paramT) {
		logger.entry(paramT);
		logger.info("In "+getClass().getName());
		mongoOperations.save(paramT);
		logger.exit();
	}
	@Override
	public WriteResult updateFirstByParams(CriteriaWrapper criteriaWrapper,
			UpdateWrapper updateWrapper) {
		logger.entry(criteriaWrapper,updateWrapper);
		logger.info("In "+getClass().getName());
		return logger.exit(mongoOperations.updateFirst(QueryWrapper.wrap(criteriaWrapper), updateWrapper.getUpdate(), cls));
	}
	@Override
	public WriteResult updateFirstByParams(String id, UpdateWrapper updateWrapper) {
		logger.entry(id,updateWrapper);
		logger.info("In "+getClass().getName());
		return logger.exit(mongoOperations.updateFirst(QueryWrapper.wrap(id), updateWrapper.getUpdate(), cls));
	}
	@Override
	public WriteResult updateMultiByParams(CriteriaWrapper criteriaWrapper,
			UpdateWrapper updateWrapper) {
		return mongoOperations.updateMulti(QueryWrapper.wrap(criteriaWrapper), updateWrapper.getUpdate(), cls);
	}
	@Override
	public WriteResult updateMultiByParams(CriteriaWrapper criteriaWrapper,
			Pageable pageable, Sortable sortable, UpdateWrapper updateWrapper) {
		// TODO Auto-generated method stub
		return mongoOperations.updateMulti(QueryWrapper.wrap(criteriaWrapper, null, pageable).with(sortable.toSort()), updateWrapper.getUpdate(), cls);
	}

	@Override
	public WriteResult upsert(String id, UpdateWrapper updateWrapper) {
		return mongoOperations.upsert(QueryWrapper.wrap(id), updateWrapper.getUpdate(), cls);
	}
	@Override
	public WriteResult upsert(CriteriaWrapper criteriaWrapper,
			UpdateWrapper updateWrapper) {
		return mongoOperations.upsert(QueryWrapper.wrap(criteriaWrapper), updateWrapper.getUpdate(), cls);

	}
	@Override
	public void delete(String id) {
		mongoOperations.remove(QueryWrapper.wrap(id), cls);
	}
	@Override
	public void delete(T paramT) {
		mongoOperations.remove(paramT);
	}
	@Override
	public void deleteByParams(CriteriaWrapper criteriaWrapper) {
		mongoOperations.remove(QueryWrapper.wrap(criteriaWrapper), cls);
	}
	@Override
	public T findOneById(String id) {
		logger.entry(id);
		logger.info("In "+getClass().getName());
		return logger.exit(mongoOperations.findOne(QueryWrapper.wrap(id), cls));
	}
	@Override
	public T findOneByParams(CriteriaWrapper criteriaWrapper) {
		return mongoOperations.findOne(QueryWrapper.wrap(criteriaWrapper), cls);
	}
	@Override
	public List<T> findByParams(CriteriaWrapper criteriaWrapper) {
		return mongoOperations.find(QueryWrapper.wrap(criteriaWrapper), cls);
	}
	@Override
	public List<T> findByParamsInPage(CriteriaWrapper criteriaWrapper,
			Pageable pageable) {
		return mongoOperations.find(QueryWrapper.wrap(criteriaWrapper, null, pageable), cls);

	}
	@Override
	public List<T> findProjectedByParams(CriteriaWrapper criteriaWrapper,
			FieldFilter filter) {
		return mongoOperations.find(QueryWrapper.wrap(criteriaWrapper, filter, null), cls);

	}
	@Override
	public List<T> findProjectedByParamsInPage(CriteriaWrapper criteriaWrapper,
			FieldFilter filter, Pageable pageable) {
		return mongoOperations.find(QueryWrapper.wrap(criteriaWrapper, filter, pageable), cls);
	}
	@Override
	public List<T> findMultiByIds(String... ids) {
		return mongoOperations.find(QueryWrapper.wrap(CriteriaWrapper.instance().in("id", (Object[])ids)), cls);
	}
	@Override
	public List<T> findAll() {
		return mongoOperations.findAll(cls);
	}
	@Override
	public List<T> findAllInPage(Pageable pageable) {
		return mongoOperations.find(QueryWrapper.wrap(null, null, pageable), cls);
	}
	@Override
	public List<T> findProjectedAll(String... fields) {
		return mongoOperations.find(QueryWrapper.wrap(FieldFilter.instance(fields)), cls);
	}
	@Override
	public List<T> findProjectedAll(FieldFilter filter) {
		return mongoOperations.find(QueryWrapper.wrap(filter), cls);

	}
	@Override
	public List<T> findProjectedAllInPage(Pageable pageable, String... fields) {
		return mongoOperations.find(QueryWrapper.wrap(FieldFilter.instance(fields), pageable), cls);
	}
	@Override
	public List<T> findProjectedAllInPage(Pageable pageable, FieldFilter filter) {
		return mongoOperations.find(QueryWrapper.wrap(filter, pageable), cls);
	}
	@Override
	public Class<T> getParameterizedClass() {
		return cls;
	}
	@Override
	public long getCount(CriteriaWrapper criteriaWrapper) {
		return mongoOperations.count(QueryWrapper.wrap(criteriaWrapper), cls);
	}
	
	
	@Override
	public List<T> findByParamsInOrder(CriteriaWrapper criteriaWrapper,
			Sortable sortable) {
		return mongoOperations.find(QueryWrapper.wrap(criteriaWrapper).with(sortable.toSort()), cls);
	}
	@Override
	public List<T> findByParamsInPageInOrder(CriteriaWrapper criteriaWrapper,
			Pageable pageable, Sortable sortable) {
		return mongoOperations.find(QueryWrapper.wrap(criteriaWrapper,null, pageable).with(sortable.toSort()), cls);
	}
	@Override
	public List<T> findProjectedByParamsInOrder(
			CriteriaWrapper criteriaWrapper, FieldFilter filter,
			Sortable sortable) {
		return mongoOperations.find(QueryWrapper.wrap(criteriaWrapper, filter, null).with(sortable.toSort()), cls);
	}
	@Override
	public List<T> findProjectedByParamsInPageInOrder(CriteriaWrapper criteriaWrapper,
			FieldFilter filter, Pageable pageable, Sortable sortable) {
		return mongoOperations.find(QueryWrapper.wrap(criteriaWrapper, filter, pageable).with(sortable.toSort()), cls);
	}
	@Override
	public List<T> findMultiByIdsInOrder(Sortable sortable, String... ids) {
		return mongoOperations.find(QueryWrapper.wrap(CriteriaWrapper.instance().in("id", (Object[])ids)).with(sortable.toSort()), cls);

	}
	@Override
	public List<T> findAllInOrder(Sortable sortable) {
		return mongoOperations.find(QueryWrapper.wrap(null, null, null).with(sortable.toSort()), cls);
	}
	@Override
	public List<T> findAllInPageInOrder(Pageable pageable, Sortable sortable) {
		return mongoOperations.find(QueryWrapper.wrap(null, null, pageable).with(sortable.toSort()), cls);

	}
	@Override
	public List<T> findProjectedAllInOrder(Sortable sortable, String... fields) {
		return mongoOperations.find(QueryWrapper.wrap(FieldFilter.instance(fields)).with(sortable.toSort()), cls);

	}
	@Override
	public List<T> findProjectedAllInOrder(FieldFilter filter, Sortable sortable) {
		return mongoOperations.find(QueryWrapper.wrap(filter).with(sortable.toSort()), cls);

	}
	@Override
	public List<T> findProjectedAllInPageInOrder(Pageable pageable,
			Sortable sortable, String... fields) {
		return mongoOperations.find(QueryWrapper.wrap(FieldFilter.instance(fields), pageable).with(sortable.toSort()), cls);

	}
	@Override
	public List<T> findProjectedAllInPageInOrder(Pageable pageable,
			FieldFilter filter, Sortable sortable) {
		return mongoOperations.find(QueryWrapper.wrap(filter, pageable).with(sortable.toSort()), cls);

	}
	@Override
	public T findOneProjectedById(String id, FieldFilter fieldFilter) {
		return mongoOperations.findOne(QueryWrapper.wrap(CriteriaWrapper.instance().is("id", id), fieldFilter, null), cls);
	}
	@Override
	public T findOneProjectedByParams(CriteriaWrapper criteriaWrapper, FieldFilter fieldFilter) {
		return mongoOperations.findOne(QueryWrapper.wrap(criteriaWrapper, fieldFilter, null), cls);

	}
	
	
}
