package hashMap.task4;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    HashMap<String, ArrayList<Double>> expensesByCategories; // замените на таблицу с именем expensesByCategories

    ExpensesManager() {
        expensesByCategories = new HashMap<>();
    }

    // добавьте в метод ещё один параметр — category
    double saveExpense(double moneyBeforeSalary, String category, double expense) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            expenses.add(expense);
        } else {
            ArrayList<Double> expenses = new ArrayList<>();
            expenses.add(expense);
            expensesByCategories.put(category, expenses);
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }


    void printAllExpensesByCategories() {
        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                System.out.println(expense);
            }
        }
    }

    // метод должен принимать название категории и называться findMaxExpenseInCategory
    double findMaxExpenseInCategory(String category) {
        double maxExpense = 0;
        if (expensesByCategories.containsKey(category)) {
            ArrayList<Double> expenses = expensesByCategories.get(category);
            for (Double expense : expenses) {
                if (expense > maxExpense) {
                    maxExpense = expense;
                }
            }
        } else {
            System.out.println("Такой категории пока нет.");
        }
        return maxExpense;
    }

    void removeAllExpenses() {
        expensesByCategories.clear();
        System.out.println("Траты удалены.");
    }

    // Напишите метод для получения суммы всех трат
    double getExpensesSum() {
        double result = 0;
        for (ArrayList<Double> expenses : expensesByCategories.values()) {
            for (double expense : expenses) {
                result += expense;
            }
        }
        return result;
    }

    // Напишите метод для удаления категории
    void removeCategory(String name) {
        expensesByCategories.remove(name);
    }

    // Напишите метод для получения категории, где размер трат больше всего
    String getMaxCategoryName() {
        // Используйте эти переменные для сохранения промежуточных значений
        double maxCategorySum = 0;
        String maxCategoryName = "";

        for (String category : expensesByCategories.keySet()) {
            System.out.println(category);
            ArrayList<Double> expenses = expensesByCategories.get(category);

            for (double expense : expenses) {
                double sum = 0;
                sum += expense;
                if (sum > maxCategorySum) {
                    maxCategorySum = sum;
                    maxCategoryName = category;
                }
            }
        }
        return maxCategoryName;
    }
}

