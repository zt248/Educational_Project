package com.service.impl;

import com.dao.DaoException;
import com.dao.EmployeeDAO;
import com.model.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public void add(Employee employee) throws DaoException {
        this.employeeDAO.add(employee);
    }

    @Override
    public List<Employee> getAll() throws DaoException {
        return this.employeeDAO.getAll();
    }

    @Override
    public Employee getById(Long id) throws DaoException {
        return this.employeeDAO.getById(id);
    }

    @Override
    public void update(Employee employee) throws DaoException {
        this.employeeDAO.update(employee);
    }

    @Override
    public void remove(Employee employee) throws DaoException {
        this.employeeDAO.remove(employee);
    }
}
