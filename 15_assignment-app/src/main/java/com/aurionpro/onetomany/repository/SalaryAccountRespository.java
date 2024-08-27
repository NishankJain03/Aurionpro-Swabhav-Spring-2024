package com.aurionpro.onetomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.onetomany.entity.SalaryAccount;
import java.util.List;
import java.util.Optional;



public interface SalaryAccountRespository extends JpaRepository<SalaryAccount, Long>{
	Optional<SalaryAccount> findByAccountNumber(long accountNumber);
}
