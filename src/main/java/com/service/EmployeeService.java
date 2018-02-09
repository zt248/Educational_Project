package com.service;

import com.dao.DaoException;
import com.model.Employee;

import java.util.List;

public interface EmployeeService {
    //create
    void add(Employee employee) throws DaoException;

    //read
    List<Employee> getAll() throws DaoException;

    Employee getById(Long id) throws DaoException;

    //update
    void update(Employee employee) throws DaoException;

    //delete
    void remove(Employee employee) throws DaoException;
}
