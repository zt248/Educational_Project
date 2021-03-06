package com.service;

import com.dao.DaoException;
import com.model.Address;

import java.util.List;

public interface AddressService {

    //create
    void add(Address address) throws DaoException;

    //read
    List<Address> getAll() throws DaoException;

    Address getById(Long id) throws DaoException;

    //update
    void update(Address address) throws DaoException;

    //delete

    void remove(Address address) throws DaoException;
}
