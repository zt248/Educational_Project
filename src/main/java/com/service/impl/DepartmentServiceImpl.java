package com.service.impl;

import com.dao.DaoException;
import com.dao.DepartmentDAO;
import com.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements com.service.DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;


    @Override
    public void add(Department department) throws DaoException {
        this.departmentDAO.add(department);
    }

    @Override
    public List<Department> getAll() throws DaoException {
        return this.departmentDAO.getAll();
    }

    @Override
    public Department getById(Long id) throws DaoException {
        return this.departmentDAO.getById(id);
    }

    @Override
    public void update(Department department) throws DaoException {
        this.departmentDAO.update(department);
    }

    @Override
    public void remove(Department department) throws DaoException {
        this.departmentDAO.remove(department);
    }
}
