package com.example.risebudget;

import com.example.risebudget.models.*;
import com.example.risebudget.repositories.ExpenseRepo;
import com.example.risebudget.repositories.PotRepo;
import com.example.risebudget.repositories.ProviderRepo;
import com.example.risebudget.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@SpringBootTest
class RisebudgetApplicationTests {
	@Autowired
	ExpenseRepo expenseRepo;
	@Autowired
	PotRepo potRepo;
	@Autowired
	ProviderRepo providerRepo;
	@Autowired
	UserRepo userRepo;


	@Test
	void contextLoads() {
	}

	@Test
	public void canFindExpenseByProviderName(){
		List<Expense> foundExpenses = expenseRepo.findByProviderName("Netflix");
		assertEquals(1, foundExpenses.size());
	}

	@Test
	public void canFindExpenseByAmount(){
		List<Expense> foundExpenses = expenseRepo.findByAmount(14.99);
		assertEquals(1, foundExpenses.size());
	}

	@Test
	public void canFindExpenseByCategory(){
		List<Expense> foundExpenses = expenseRepo.findByCategory(CategoryType.GROCERIES);
		assertEquals(3, foundExpenses.size());
	}

	@Test
	public void canFindExpenseByTitle() {
		List<Expense> foundExpenses = expenseRepo.findByTitle("Food Shopping");
		assertEquals(3, foundExpenses.size());
	}

	@Test
	public void canFindExpenseByDate() {
		Date date = Date.valueOf("2023-02-28");
		List<Expense> foundExpenses = expenseRepo.findByDate(date);
		assertEquals(5, foundExpenses.size());
	}

	@Test
	public void canFindPotByTitle() {
		List<Pot> foundPots = potRepo.findByTitle("Holiday Trip");
		assertEquals(1, foundPots.size());
	}

	@Test
	public void canFindPotByAmount() {
		List<Pot> foundPots = potRepo.findByAmount(600.00);
		assertEquals(1, foundPots.size(), 0.1);
	}

	@Test
	public void canFindProviderByName() {
		List<Provider> foundProviders = providerRepo.findByName("Netflix");
		assertEquals(1, foundProviders.size());
	}

	@Test
	public void canFindUserByName() {
		List<User> foundUser = userRepo.findByName("James");
		assertEquals(1, foundUser.size());
	}


}
