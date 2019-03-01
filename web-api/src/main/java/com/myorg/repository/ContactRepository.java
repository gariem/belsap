package com.myorg.repository;

import com.myorg.model.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

    Contact findFirstByNumber(String number);

    List<Contact> findAll();

    List<Contact> findAllByNumber(String number);

}
