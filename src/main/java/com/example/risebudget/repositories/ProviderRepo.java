package com.example.risebudget.repositories;

import com.example.risebudget.models.Expense;
import com.example.risebudget.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProviderRepo extends JpaRepository<Provider, Long> {

    List<Provider> findByName(String name);

}
