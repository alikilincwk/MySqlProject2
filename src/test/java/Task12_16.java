import Utilites.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Task12_16 extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        System.out.println("\n--- Starting Task 12 ---\n");
        testTask12();
        System.out.println("\n--- End of Task 12 ---\n");

        System.out.println("\n--- Starting Task 13 ---\n");
        testTask13();
        System.out.println("\n--- End of Task 13 ---\n");

        System.out.println("\n--- Starting Task 14 ---\n");
        testTask14();
        System.out.println("\n--- End of Task 14 ---\n");

        System.out.println("\n--- Starting Task 15 ---\n");
        testTask15();
        System.out.println("\n--- End of Task 15 ---\n");

        System.out.println("\n--- Starting Task 16 ---\n");
        testTask16();
        System.out.println("\n--- End of Task 16 ---\n");

        DBConnectionClose();
    }

    public static void testTask12() throws SQLException {
        System.out.println("Executing Task 12: Find the employee with the highest salary.");
        ResultSet sonuc = statement.executeQuery("SELECT * FROM employees " +
                "JOIN salaries ON employees.emp_no = salaries.emp_no " +
                "ORDER BY salary DESC " +
                "LIMIT 1");

        if (sonuc.next()) {
            int empNo = sonuc.getInt("emp_no");
            String firstName = sonuc.getString("first_name");
            String lastName = sonuc.getString("last_name");
            double salary = sonuc.getDouble("salary");
            System.out.println("Employee Details - Emp No: " + empNo + ", First Name: " + firstName + ", Last Name: " + lastName + ", Salary: " + Math.round(salary * 100.0) / 100.0);
        }
    }

    public static void testTask13() throws SQLException {
        System.out.println("Executing Task 13: Find the latest salaries for each employee.");
        ResultSet sonuc = statement.executeQuery("SELECT emp_no, salary, to_date " +
                "FROM salaries " +
                "WHERE (emp_no, to_date) IN (SELECT emp_no, MAX(to_date) FROM salaries GROUP BY emp_no)");

        int rowCount = 0;
        while (sonuc.next() && rowCount < 10) {
            rowCount++;
            int empNo = sonuc.getInt("emp_no");
            double salary = sonuc.getDouble("salary");
            String toDate = sonuc.getString("to_date");
            System.out.println("Salary Details - Emp No: " + empNo + ", Salary: " + Math.round(salary * 100.0) / 100.0 + ", To Date: " + toDate);
        }
    }

    public static void testTask14() throws SQLException {
        System.out.println("Executing Task 14: List the first name, last name, and highest salary of employees in the 'Sales' department.");
        ResultSet sonuc = statement.executeQuery("SELECT e.first_name, e.last_name, MAX(s.salary) AS highest_salary " +
                "FROM employees e " +
                "INNER JOIN dept_emp de ON e.emp_no = de.emp_no " +
                "INNER JOIN departments d ON de.dept_no = d.dept_no " +
                "INNER JOIN salaries s ON e.emp_no = s.emp_no " +
                "WHERE d.dept_name = 'Sales' " +
                "GROUP BY e.first_name, e.last_name " +
                "ORDER BY highest_salary DESC " +
                "LIMIT 1");

        if (sonuc.next()) {
            String firstName = sonuc.getString("first_name");
            String lastName = sonuc.getString("last_name");
            double highestSalary = sonuc.getDouble("highest_salary");
            System.out.println("Employee Details - First Name: " + firstName + ", Last Name: " + lastName + ", Highest Salary: " + Math.round(highestSalary * 100.0) / 100.0);
        }
    }

    public static void testTask15() throws SQLException {
        System.out.println("Executing Task 15: Find the employee with the highest salary in the Research department.");
        ResultSet sonuc = statement.executeQuery("SELECT e.first_name, e.last_name, MAX(s.salary) AS max_salary " +
                "FROM employees e " +
                "INNER JOIN dept_emp de ON e.emp_no = de.emp_no " +
                "INNER JOIN departments d ON de.dept_no = d.dept_no " +
                "INNER JOIN salaries s ON e.emp_no = s.emp_no " +
                "WHERE d.dept_name = 'Research' " +
                "GROUP BY e.first_name, e.last_name " +
                "ORDER BY max_salary DESC " +
                "LIMIT 1");

        if (sonuc.next()) {
            String firstName = sonuc.getString("first_name");
            String lastName = sonuc.getString("last_name");
            double maxSalary = sonuc.getDouble("max_salary");
            System.out.println("Employee Details - First Name: " + firstName + ", Last Name: " + lastName + ", Max Salary: " + Math.round(maxSalary * 100.0) / 100.0);
        }
    }

    public static void testTask16() throws SQLException {
        System.out.println("Executing Task 16: For each department, identify the employee with the highest single salary ever recorded.");
        ResultSet sonuc = statement.executeQuery("SELECT d.dept_name AS department, e.first_name, e.last_name, s.salary AS max_salary " +
                "FROM employees e " +
                "INNER JOIN dept_emp de ON e.emp_no = de.emp_no " +
                "INNER JOIN departments d ON de.dept_no = d.dept_no " +
                "INNER JOIN salaries s ON e.emp_no = s.emp_no " +
                "WHERE s.salary = (SELECT MAX(salary) FROM salaries WHERE emp_no = e.emp_no) " +
                "GROUP BY d.dept_name, e.first_name, e.last_name, s.salary " +
                "ORDER BY max_salary DESC");

        int rowCount = 0;
        while (sonuc.next() && rowCount < 10) {
            rowCount++;
            String department = sonuc.getString("department");
            String firstName = sonuc.getString("first_name");
            String lastName = sonuc.getString("last_name");
            double maxSalary = sonuc.getDouble("max_salary");
            System.out.println("Department Details - Department: " + department + ", First Name: " + firstName + ", Last Name: " + lastName + ", Max Salary: " + Math.round(maxSalary * 100.0) / 100.0);
        }
    }
}
