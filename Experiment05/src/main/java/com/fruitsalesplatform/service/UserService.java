package com.fruitsalesplatform.service;

import com.fruitsalesplatform.dao.UserDao;
import com.fruitsalesplatform.entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @PROJECT_NAME: JavaEE��ҵ
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/18 17:07
 */
public interface UserService {
    public User get(Serializable id);  // ֻ��ѯһ�����ݣ��������޸�
    public List<User> find(Map map);  // ����������ѯ������
    public void insert(User user);  // ���룬��ʵ����Ϊ����
    public void update(User user);  // �޸ģ���ʵ����Ϊ����
    public void deleteById(Serializable id);  // ��idɾ����ɾ��һ��
    public void delete(Serializable[] ids);  // ����ɾ��
}
