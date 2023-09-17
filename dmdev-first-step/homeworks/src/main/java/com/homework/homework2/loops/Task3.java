package com.homework.homework2.loops;

/**
 * Задание 3
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию Junior Java Developer с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 * <p>
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 * <p>
 * Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
 */

public class Task3 {
    private static final int INITIAL_SALARY = 600;
    private static final int SALARY_INCREMENTS = 400;
    private static final int MONTHS_BETWEEN_INCREMENTS = 6;
    private static final int MONTHLY_EXPENSES = 300;
    private static final double BROKER_INVESTMENT_RATE = 0.1;
    private static final double MONTHLY_RETURNS = 0.02;
    private static final double SAVINGS_RATE_BASE = 1.0;
    private static final double INVESTMENT_RATE_BASE = 1.0;
    private static final int TOTAL_MONTHS = 3 * 12 + 2; // 3 years and 2 months

    public static void main(String[] args) {
        double totalSavings = 0;
        double totalInvestment = 0;
        int currentSalary = INITIAL_SALARY;

        for (int currentMonth = 1; currentMonth <= TOTAL_MONTHS; currentMonth++) {
            if (shouldIncreaseSalary(currentMonth)) {
                currentSalary = increaseSalary(currentSalary);
            }

            int netIncome = calculateNetIncome(currentSalary);
            totalSavings = updateTotalSavings(totalSavings, netIncome);
            totalInvestment = updateInvestment(totalInvestment, netIncome);
        }

        System.out.printf("Total savings after %d months: %.2f%n", TOTAL_MONTHS, totalSavings);
        System.out.printf("Total investment after %d months: %.2f%n", TOTAL_MONTHS, totalInvestment);
    }

    /**
     * Determines if the salary should be increased this month.
     *
     * @param currentMonth The current month.
     * @return True if the salary should be increased, otherwise false.
     */
    private static boolean shouldIncreaseSalary(int currentMonth) {
        return currentMonth % MONTHS_BETWEEN_INCREMENTS == 0;
    }

    /**
     * Increases the current salary.
     *
     * @param currentSalary The current salary.
     * @return The new salary.
     */
    private static int increaseSalary(int currentSalary) {
        return currentSalary + SALARY_INCREMENTS;
    }

    /**
     * Calculates the net income for the month.
     *
     * @param currentSalary The current salary.
     * @return The net income.
     */
    private static int calculateNetIncome(int currentSalary) {
        return currentSalary - MONTHLY_EXPENSES;
    }

    /**
     * Updates the total savings based on the net income.
     *
     * @param totalSavings The current total savings.
     * @param netIncome    The net income for the month.
     * @return The updated total savings.
     */
    private static double updateTotalSavings(double totalSavings, int netIncome) {
        return totalSavings + netIncome * (SAVINGS_RATE_BASE - BROKER_INVESTMENT_RATE);
    }

    /**
     * Updates the total investment based on the net income and monthly returns.
     *
     * @param investment The current total investment.
     * @param netIncome  The net income for the month.
     * @return The updated total investment.
     */
    private static double updateInvestment(double investment, int netIncome) {
        investment += netIncome * BROKER_INVESTMENT_RATE;
        return investment * (INVESTMENT_RATE_BASE + MONTHLY_RETURNS);
    }
}
