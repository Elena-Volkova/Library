package com.example.application.server.repository;

import com.example.application.server.repository.model.AddressDB;

public interface AddressDao {

    AddressDB findById(Long addressId);

    void saveAddress(AddressDB address);

    void deleteAddress(Long addressId);

    void updateAddress(AddressDB address);

}
