package com.dao.impl;

import com.config.ApplicationConfig;
import com.dao.DaoException;
import com.dao.DepartmentDAO;
import com.model.Department;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class DepartmentDaoImplTest {


    @Autowired
    private DepartmentDAO departmentDao;


    @Test
    public void add() throws DaoException {
        Department department = new Department(null, "test");
        departmentDao.add(department);
        Assert.assertEquals(departmentDao.getById(department.getId()).getId(), department.getId());
        Assert.assertEquals(departmentDao.getById(department.getId()).getPosition(), department.getPosition());
        departmentDao.remove(department);
    }

    @Test
    public void getAll() throws DaoException {
        Department department = new Department(null, "test");
        departmentDao.add(department);
        List<Department> list = departmentDao.getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
        departmentDao.remove(department);
    }

    @Test
    public void getById() throws DaoException {
        Department department = new Department(null, "test");
        departmentDao.add(department);
        Assert.assertEquals(departmentDao.getById(department.getId()).getId(), department.getId());
        Assert.assertEquals(departmentDao.getById(department.getId()).getPosition(), department.getPosition());
        departmentDao.remove(department);
    }

    @Test
    public void update() throws DaoException {
        Department department = new Department(null, "test");

        departmentDao.add(department);
        Assert.assertEquals(departmentDao.getById(department.getId()).getId(), department.getId());
        department.setPosition("new Position");
        departmentDao.update(department);
        Assert.assertEquals(departmentDao.getById(department.getId()).getId(), department.getId());
        Assert.assertEquals(departmentDao.getById(department.getId()).getPosition(), department.getPosition());
        departmentDao.remove(department);
    }

    @Test
    public void remove() throws DaoException {
        Department department = new Department(null, "test");
        departmentDao.add(department);
        Assert.assertNotNull(departmentDao.getById(department.getId()).getId());
        departmentDao.remove(department);
        try {
            Assert.assertNull(departmentDao.getById(department.getId()).getId());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
