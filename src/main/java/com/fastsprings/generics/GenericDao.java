package com.fastsprings.generics;

public interface GenericDao<T> {

	T create(T t);
	
	T update(T t);

	void delete(long id);

	T find(long id);

	

}
