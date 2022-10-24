package com.fruitsalesplatform.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @PROJECT_NAME: JavaEE��ҵ
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/18 10:06
 */
public interface BaseDao<T> {
    public T get(Serializable id);  // ֻ��ѯһ�����ݣ��������޸�
    public List<T> find(Map map);  // ����������ѯ������
    public void insert(T entity);  // ���룬��ʵ����Ϊ����
    public void update(T entity);  // �޸ģ���ʵ����Ϊ����
    public void deleteById(Serializable id);  // ����idɾ��
    public void delete(Serializable id);  // ����ɾ��
}
