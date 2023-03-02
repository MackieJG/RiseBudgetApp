package com.example.risebudget.repositories;

import com.example.risebudget.models.CategoryType;
import com.example.risebudget.models.Expense;
import com.example.risebudget.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long> {

    List<Expense> findByCategory(CategoryType category);

    List<Expense> findByProviderName(String name);

    List<Expense> findByAmount(double amount);

    List<Expense> findByTitle(String title);

    List<Expense> findByDate(Date date);

    List<Expense> findByProviderNameIn(List<String> providers);

    List<Expense> findByCategoryIn(List<CategoryType> categories);

    List<Expense> findByDateBetween(Date startDate, Date endDate);

    List<Expense> findByProviderNameAndDateBetween(String name, Date startDate, Date endDate);

    List<Expense> findByCategoryInAndDateBetween(List<CategoryType> categories, Date startDate, Date endDate);

    List<Expense> findByCategoryInOrProviderNameIn(List<CategoryType> categories, List<String> providers);

    List<Expense> findByCategoryInAndProviderNameIn(List<CategoryType> categories, List<String> providers);

    List<Expense> findByCategoryInOrProviderNameInAndDateBetween(List<CategoryType> categories, List<String> providers, Date startDate, Date endDate);


}


