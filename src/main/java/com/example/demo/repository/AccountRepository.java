package com.example.demo.repository;

import com.example.demo.model.Accounts;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Accounts, Integer> {

    Accounts getAccountByNumber(Integer number);
}
