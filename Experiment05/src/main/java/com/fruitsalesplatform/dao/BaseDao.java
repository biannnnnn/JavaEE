package com.fruitsalesplatform.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @PROJECT_NAME: JavaEE作业
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/18 10:06
 */
public interface BaseDao<T> {
    public T get(Serializable id);  // 只查询一个数据，常用于修改
    public List<T> find(Map map);  // 根据条件查询多个结果
    public void insert(T entity);  // 插入，用实体作为参数
    public void update(T entity);  // 修改，用实体作为参数
    public void deleteById(Serializable id);  // 按照id删除
    public void delete(Serializable id);  // 批量删除
}
