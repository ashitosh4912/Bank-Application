package com.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.entity.Bank;

@Repository
public interface BankRepo extends JpaRepository<Bank, Long> {
}
