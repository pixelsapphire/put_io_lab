package put.io.testing.mocks;

import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpenseRepository implements IExpenseRepository {

    private final IFancyDatabase fancyDatabase;
    private List<Expense> expenses;

    public ExpenseRepository(IFancyDatabase source) {
        fancyDatabase = source;
        expenses = new ArrayList<>();
    }

    @Override
    public List<Expense> getExpenses() {
        return Collections.unmodifiableList(expenses);
    }

    @Override
    public List<Expense> getExpensesByCategory(String category) {
        List<Expense> filteredList = new ArrayList<>();
        for (Expense expense : expenses) {
            if (expense.getCategory().equals(category)) filteredList.add(expense);
        }
        return filteredList;
    }

    @Override
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    @Override
    public void deleteExpense(Expense expense) {
        expenses.remove(expense);
    }

    @Override
    public void loadExpenses() {
        fancyDatabase.connect();
        expenses = new ArrayList<>(fancyDatabase.queryAll());
        fancyDatabase.close();
    }

    @Override
    public void saveExpenses() {
        fancyDatabase.connect();

        int i = 1;
        for (Expense expense : expenses) {
            fancyDatabase.persist(expense);
            if (i++ % 2 == 0)
                fancyDatabase.persist(expense);
        }

        fancyDatabase.close();
    }
}
