package com.dao.impl;

import com.config.ApplicationConfig;
import com.dao.AddressDAO;
import com.dao.DaoException;
import com.dao.DepartmentDAO;
import com.dao.EmployeeDAO;
import com.model.Address;
import com.model.Department;
import com.model.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@TransactionConfiguration(defaultRollback = true)
public class EmployeeDaoImplTest {

    @Autowired
    public EmployeeDAO employeeDAO;


    @Autowired
    public DepartmentDAO departmentDAO;

    @Autowired
    public AddressDAO addressDAO;

    @Test
    public void add() throws DaoException {
        Department department = new Department(null, "test");
        Set<Department> departmentSet = new HashSet<>();
        departmentSet.add(department);

        Address address = new Address(null, "Test", "Test", "Test", "Test");
        Employee employee = new Employee();
        employee.setId(null);
        employee.setLastName("test");
        employee.setFirstName("test");
        employee.setAddress(address);
        employee.setDepartments(departmentSet);
        employeeDAO.add(employee);
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getId(), employee.getId());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getLastName(), employee.getLastName());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getFirstName(), employee.getFirstName());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getId(), employee.getAddress().getId());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getCity(), employee.getAddress().getCity());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getCountry(), employee.getAddress().getCountry());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getStreet(), employee.getAddress().getStreet());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getPostCode(), employee.getAddress().getPostCode());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getDepartments().size(), departmentSet.size());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getDepartments().iterator().next().getId(), departmentSet.iterator().next().getId());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getDepartments().iterator().next().getPosition(), departmentSet.iterator().next().getPosition());
        employeeDAO.remove(employee);
    }

    @Test
    public void getAll() throws DaoException {
        Department department = new Department(null, "test");
        Set<Department> departmentSet = new HashSet<>();
        departmentSet.add(department);

        Address address = new Address(null, "Test", "Test", "Test", "Test");
        Employee employee = new Employee();
        employee.setId(null);
        employee.setLastName("test");
        employee.setFirstName("test");
        employee.setAddress(address);
        employee.setDepartments(departmentSet);
        employeeDAO.add(employee);

        List<Employee> list = employeeDAO.getAll();
        Assert.assertNotNull(list);
        Assert.assertTrue(list.size() > 0);
        employeeDAO.remove(employee);
    }

    @Test
    public void getById() throws DaoException {
        Department department = new Department(null, "test");
        Set<Department> departmentSet = new HashSet<>();
        departmentSet.add(department);

        Address address = new Address(null, "Test", "Test", "Test", "Test");
        Employee employee = new Employee();
        employee.setId(null);
        employee.setLastName("test");
        employee.setFirstName("test");
        employee.setBirthday(new Date(92, 3, 28));
        employee.setAddress(address);
        employee.setDepartments(departmentSet);
        employeeDAO.add(employee);

        Assert.assertEquals(employeeDAO.getById(employee.getId()).getId(), employee.getId());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getLastName(), employee.getLastName());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getFirstName(), employee.getFirstName());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getId(), employee.getAddress().getId());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getCity(), employee.getAddress().getCity());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getCountry(), employee.getAddress().getCountry());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getStreet(), employee.getAddress().getStreet());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getPostCode(), employee.getAddress().getPostCode());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getDepartments().size(), departmentSet.size());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getDepartments().iterator().next().getId(), departmentSet.iterator().next().getId());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getDepartments().iterator().next().getPosition(), departmentSet.iterator().next().getPosition());
        employeeDAO.remove(employee);
    }

    @Test
    public void update() throws DaoException {
        Department department = new Department(null, "test");
        Set<Department> departmentSet = new HashSet<>();
        departmentSet.add(department);

        Address address = new Address(null, "Test", "Test", "Test", "Test");
        Employee employee = new Employee();
        employee.setId(null);
        employee.setLastName("test");
        employee.setFirstName("test");
        employee.setBirthday(new Date(92, 3, 28));
        employee.setAddress(address);
        employee.setDepartments(departmentSet);
        employeeDAO.add(employee);

        Assert.assertEquals(employeeDAO.getById(employee.getId()).getId(), employee.getId());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getLastName(), employee.getLastName());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getFirstName(), employee.getFirstName());
//        Assert.assertEquals(employeeDAO.getById(employee.getId()).getBirthday(), employee.getBirthday());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getId(), employee.getAddress().getId());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getCity(), employee.getAddress().getCity());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getCountry(), employee.getAddress().getCountry());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getStreet(), employee.getAddress().getStreet());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getPostCode(), employee.getAddress().getPostCode());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getDepartments().size(), departmentSet.size());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getDepartments().iterator().next().getId(), departmentSet.iterator().next().getId());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getDepartments().iterator().next().getPosition(), departmentSet.iterator().next().getPosition());

        department.setPosition("new Position");
        departmentSet.add(department);

        address.setPostCode("new");
        address.setStreet("new");
        address.setCity("new");
        address.setCountry("new");

        employee.setLastName("new");
        employee.setFirstName("new");
        employee.setBirthday(new Date(94, 4, 29));
        employee.setAddress(address);
        employee.setDepartments(departmentSet);

        employeeDAO.update(employee);
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getId(), employee.getId());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getLastName(), employee.getLastName());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getFirstName(), employee.getFirstName());
//        Assert.assertEquals(employeeDAO.getById(employee.getId()).getBirthday(), employee.getBirthday());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getId(), employee.getAddress().getId());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getCity(), employee.getAddress().getCity());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getCountry(), employee.getAddress().getCountry());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getStreet(), employee.getAddress().getStreet());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getAddress().getPostCode(), employee.getAddress().getPostCode());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getDepartments().size(), departmentSet.size());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getDepartments().iterator().next().getId(), departmentSet.iterator().next().getId());
        Assert.assertEquals(employeeDAO.getById(employee.getId()).getDepartments().iterator().next().getPosition(), departmentSet.iterator().next().getPosition());
        employeeDAO.remove(employee);
    }

    @Test
    public void remove() throws DaoException {
        Department department = new Department(null, "test");
        Set<Department> departmentSet = new HashSet<>();
        departmentSet.add(department);

        Address address = new Address(null, "Test", "Test", "Test", "Test");
        Employee employee = new Employee();
        employee.setId(null);
        employee.setLastName("test");
        employee.setFirstName("test");
        employee.setBirthday(new Date(92, 3, 28));
        employee.setAddress(address);
        employee.setDepartments(departmentSet);
        employeeDAO.add(employee);

        Assert.assertNotNull(employeeDAO.getById(employee.getId()).getId());
        employeeDAO.remove(employee);
        try {
            Assert.assertNull(employeeDAO.getById(employee.getId()).getId());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
