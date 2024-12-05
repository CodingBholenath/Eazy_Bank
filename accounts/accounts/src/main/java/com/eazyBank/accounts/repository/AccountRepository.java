package com.eazyBank.accounts.repository;

import com.eazyBank.accounts.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Accounts,Long> {
Optional<Accounts>findByCustomerId(Long customerId);

@Transactional
@Modifying
void deleteByCustomerId(Long customerId);
//Behind the scene jpa repository generate delete by customer id query just liike
  //  findbyCustomerId() indicates to prepare a delete query to the spring data jpa framework
}