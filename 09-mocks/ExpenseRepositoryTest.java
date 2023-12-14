package put.io.testing.mocks;

import org.junit.jupiter.api.Test;
import put.io.students.fancylibrary.database.IFancyDatabase;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ExpenseRepositoryTest {

    @Test
    void loadExpenses() {
        final ExpenseRepository expenseRepository = new ExpenseRepository(new MyDatabase());
        expenseRepository.loadExpenses();
        assertTrue(expenseRepository.getExpenses().isEmpty());
    }

    @Test
    void loadExpensesMockito() {
        final IFancyDatabase mockDatabase = mock(IFancyDatabase.class);
        when(mockDatabase.queryAll()).thenReturn(Collections.emptyList());
        final ExpenseRepository expenseRepository = new ExpenseRepository(mockDatabase);
        expenseRepository.loadExpenses();
        verify(mockDatabase).close();
        assertTrue(expenseRepository.getExpenses().isEmpty());
    }
}
