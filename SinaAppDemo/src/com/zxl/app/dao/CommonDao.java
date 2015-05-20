package com.zxl.app.dao;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;

public class CommonDao extends SqlMapClientDaoSupport {

	/**
	 * 查找
	 * 
	 * @param <T>
	 * @param queryString
	 * @param t
	 * @return
	 */
	public <T> Object find(String queryString, T t) {
		return this.getSqlMapClientTemplate().queryForObject(queryString, t);
	}

	/**
	 * 删除
	 * 
	 * @param <T>
	 * @param queryString
	 * @param t
	 */
	public <T> void delete(String queryString, T t) {
		this.getSqlMapClientTemplate().delete(queryString, t);
	}

	/**
	 * 新增
	 * 
	 * @param <T>
	 * @param queryString
	 * @param t
	 * @return
	 */
	public <T> Long insert(String queryString, T t) {
		return (Long) this.getSqlMapClientTemplate().insert(queryString, t);
	}

	/**
	 * 更新
	 * 
	 * @param <T>
	 * @param queryString
	 * @param t
	 */
	public <T> void update(String queryString, T t) {
		this.getSqlMapClientTemplate().update(queryString, t);
	}

	/**
	 * 查询集合
	 * 
	 * @param <T>
	 * @param queryString
	 * @param t
	 * @return
	 */
	public <T> Object findList(String queryString, T t) {
		return this.getSqlMapClientTemplate().queryForList(queryString, t);
	}

	/**
	 * 查询map
	 * 
	 * @param <T>
	 * @param queryString
	 * @param t
	 * @param key
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public <T> Map findMap(String queryString, T t, String key) {
		return (Map) this.getSqlMapClientTemplate().queryForMap(queryString, t,
				key);
	}

	/**
	 * 批量新增
	 * 
	 * @param <T>
	 * @param list
	 * @param queryString
	 */
	public <T> void batchInsert(final List<T> list, final String queryString) {
		this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor)
					throws SQLException {
				executor.startBatch();
				int batch = 0;
				for (T t : list) {
					executor.insert(queryString, t);
					batch++;
					if (batch == 500) {
						executor.executeBatch();
						batch = 0;
					}
				}
				executor.executeBatch();
				return 1;
			}

		});
	}
}
