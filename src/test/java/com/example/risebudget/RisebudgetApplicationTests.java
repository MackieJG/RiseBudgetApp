package com.example.risebudget;

import com.example.risebudget.models.CategoryType;
import com.example.risebudget.models.Expense;
import com.example.risebudget.repositories.ExpenseRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.TemporalType;
import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class RisebudgetApplicationTests {

	@Autowired
	ExpenseRepo expenseRepo;

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
	public void canFindExpenseByDate(){
		Date date = Date.valueOf("2023-02-28");
		List<Expense> foundExpenses = expenseRepo.findByDate(date);
		assertEquals(5, foundExpenses.size());
	}

}
