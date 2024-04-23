package com.simuladorLogin.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

	public void inserir(T elemento) throws SQLException;
	public T get(Object id) throws SQLException;
	public List<T> getList() throws SQLException;
	public void atualizar(Object id, T elemento) throws SQLException;
	public void delete(Object id) throws SQLException;
}
