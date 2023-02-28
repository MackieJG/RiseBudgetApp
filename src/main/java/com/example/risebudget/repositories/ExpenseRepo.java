package com.example.risebudget.repositories;

import com.example.risebudget.models.CategoryType;
import com.example.risebudget.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long> {

    List<Expense> findByCategory(CategoryType categoryType);

    List<Expense> findByProviderName(String name);

    List<Expense> findByAmount(double amount);

    List<Expense> findByTitle(String title);

    List<Expense> findByDate(Date date);

}


