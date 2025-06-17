package com.mycart.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycart.store.model.Address;
import com.mycart.store.repository.AddressRepository;

@Service
public class AddressService {
    private AddressRepository addressRepository;
    @Autowired
    public AddressService(AddressRepository addressRepository){
        this.addressRepository=addressRepository;
    }
    public void createAddress(Address address){
        if (address.getHouse()!=null && address.getStreet()!=null && address.getCity()!=null && address.getProvince()!=null && address.getCountry()!=null)
            addressRepository.save(address);
        else
            throw new IllegalArgumentException("Unable to create address");
        
    }
    public Address findAddress(Long addressId){
        return addressRepository.findById(addressId)
        .orElseThrow(()->new IllegalArgumentException("Unable to find address"));
    }
    public void updateAddress(Address updatedAddress){
        
        if (updatedAddress.getHouse()!=null && updatedAddress.getStreet()!=null && updatedAddress.getCity()!=null && updatedAddress.getProvince()!=null && updatedAddress.getCountry()!=null) {
            addressRepository.findById(updatedAddress.getAdd_id())
            .map(address->{
                address.setHouse(updatedAddress.getHouse());
                address.setStreet(updatedAddress.getStreet());
                address.setCity(updatedAddress.getCity());
                address.setProvince(updatedAddress.getProvince());
                address.setCountry(updatedAddress.getCountry());
                return address;
            })
            .orElseThrow(()->new IllegalArgumentException("Unable to update address"));
        }
        
        else
            throw new IllegalArgumentException("Unable to update address");
    }
    public void deleteAddress(Address address){
        if(findAddress(address.getAdd_id())!=null)
            addressRepository.deleteById(address.getAdd_id());
        else
            throw new IllegalArgumentException("Unable to delete address");
    }
}
