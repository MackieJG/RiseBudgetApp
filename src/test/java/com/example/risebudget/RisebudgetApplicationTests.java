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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	public void canFindPotByTargetAmount() {
		List<Pot> foundPots = potRepo.findByTargetAmount(600.00);
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

	@Test
	public void canAddExpenseAndSubtractFromBudget() {
		User user = new User("James", 1000);
		Provider tesco = new Provider("Tesco");
		Expense groceries1 = new Expense("Scran", 500, tesco, CategoryType.GROCERIES, user);
		user.addExpense(groceries1);
		assertEquals(500.00, user.getBudget(), 0.01);
	}

//	@Test
//	public void canFindExpensesByProvider() {
//		List<String> providerList = new ArrayList<>();
//		providerList.add("Tesco");
//		Optional<List<String>> providers = Optional.of(providerList);
////		Provider provider = new Provider("Tesco");
//		List<Expense> foundExpenses = expenseRepo.findByProviderNameIn(providers);
//		assertEquals(3, foundExpenses.size());
//	}
//
//	@Test
//	public void canFindExpensesByProviders() {
//		List<String> providers = new ArrayList<>();
//		providers.add("Tesco");
//		providers.add("Asda");
//		List<Expense> foundExpenses = expenseRepo.findByProviderNameIn(providers);
//		assertEquals(4, foundExpenses.size());
//	}

	@Test
	public void canFindExpensesBetweenTwoDates(){
		Date startDate = Date.valueOf("2023-02-25");
		Date endDate = Date.valueOf("2023-03-28");
		List<Expense> foundExpenses = expenseRepo.findByDateBetween(startDate, endDate);
		assertEquals(8, foundExpenses.size());
	}
	// I can't test this properly because I can't figure out how to set different dates :@

	@Test
	public void canFindByProviderNameBetweenTwoDates(){
		Date startDate = Date.valueOf("2023-02-25");
		Date endDate = Date.valueOf("2023-03-28");
		String provider = "Asda";
		List<Expense> foundExpenses = expenseRepo.findByProviderNameAndDateBetween(provider, startDate, endDate);
		assertEquals(1, foundExpenses.size());
	}

//	@Test
//	public void canFindExpensesByCategoryTypesList(){
//		List<CategoryType> categories = new ArrayList<>();
//		categories.add(CategoryType.GROCERIES);
//		categories.add(CategoryType.UTILITIES);
//		List<Expense> foundExpenses = expenseRepo.findByCategoryIn(categories);
//		assertEquals(7, foundExpenses.size());
//	}

	@Test
	public void canFindExpensesByCategoryTypesListAndBetweenDates(){
		Date startDate = Date.valueOf("2023-02-25");
		Date endDate = Date.valueOf("2023-03-28");
		List<CategoryType> categories = new ArrayList<>();
		categories.add(CategoryType.GROCERIES);
		categories.add(CategoryType.SUBSCRIPTIONS);
		List<Expense> foundExpenses = expenseRepo.findByCategoryInAndDateBetween(categories, startDate, endDate);
		assertEquals(6, foundExpenses.size());
	}

	@Test
	public void canFindExpensesByCategoryListAndProviderList(){
		List<CategoryType> categories = new ArrayList<>();
		categories.add(CategoryType.UTILITIES);
		categories.add(CategoryType.SUBSCRIPTIONS);
		List<String> providers = new ArrayList<>();
		providers.add("Asda");
		List<Expense> foundExpenses = expenseRepo.findByCategoryInOrProviderNameIn(categories, providers);
		assertEquals(4, foundExpenses.size());
	}

	@Test
	public void canFindExpensesByCategoryListWithEmptyProviderList(){
		List<CategoryType> categories = new ArrayList<>();
		categories.add(CategoryType.UTILITIES);
		categories.add(CategoryType.SUBSCRIPTIONS);
		List<String> providers = new ArrayList<>();
		List<Expense> foundExpenses = expenseRepo.findByCategoryInOrProviderNameIn(categories, providers);
		assertEquals(3, foundExpenses.size());
	}

	@Test
	public void canFindExpensesByEmptyCategoryListAndProviderList(){
		List<CategoryType> categories = new ArrayList<>();
		List<String> providers = new ArrayList<>();
		providers.add("Asda");
		providers.add("Morrisons");
		List<Expense> foundExpenses = expenseRepo.findByCategoryInOrProviderNameIn(categories, providers);
		assertEquals(2, foundExpenses.size());
	}

	@Test
	public void canFindExpensesByCategoryListAndProviderListAndDatesBetween(){
		Date startDate = Date.valueOf("2023-02-28");
		Date endDate = Date.valueOf("2023-03-02");
		List<CategoryType> categories = new ArrayList<>();
		categories.add(CategoryType.UTILITIES);
		categories.add(CategoryType.SUBSCRIPTIONS);
		List<String> providers = new ArrayList<>();
		providers.add("Asda");
		List<Expense> foundExpenses = expenseRepo.findByCategoryInOrProviderNameInAndDateBetween(categories, providers, startDate, endDate);
		assertEquals(4, foundExpenses.size());
	}



}
