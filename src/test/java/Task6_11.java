import Utilites.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Task6_11 extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        System.out.println("\n--- Starting Task 6 ---\n");
        testTask6();
        System.out.println("\n--- End of Task 6 ---\n");

        System.out.println("\n--- Starting Task 7 ---\n");
        testTask7();
        System.out.println("\n--- End of Task 7 ---\n");

        System.out.println("\n--- Starting Task 8 ---\n");
        testTask8();
        System.out.println("\n--- End of Task 8 ---\n");

        System.out.println("\n--- Starting Task 9 ---\n");
        testTask9();
        System.out.println("\n--- End of Task 9 ---\n");

        System.out.println("\n--- Starting Task 10 ---\n");
        testTask10();
        System.out.println("\n--- End of Task 10 ---\n");

        System.out.println("\n--- Starting Task 11 ---\n");
        testTask11();
        System.out.println("\n--- End of Task 11 ---\n");

        DBConnectionClose();
    }

    public static void testTask6() throws SQLException {
        System.out.println("Executing Task 6: List all employees in the 'Sales' department with a salary greater than 70,000.");
        ResultSet sonuc = statement.executeQuery("SELECT e.*, s.salary " +
                "FROM employees e " +
                "JOIN dept_emp de ON e.emp_no = de.emp_no " +
                "JOIN departments d ON de.dept_no = d.dept_no " +
                "JOIN salaries s ON e.emp_no = s.emp_no " +
                "WHERE d.dept_name = 'Sales' AND s.salary > 70000");

        int rowCount = 0;
        while (sonuc.next() && rowCount < 10) {
            rowCount++;
            int empNo = sonuc.getInt("emp_no");
            String firstName = sonuc.getString("first_name");
            String lastName = sonuc.getString("last_name");
            double salary = sonuc.getDouble("salary");
            System.out.println("Employee Details - Emp No: " + empNo + ", First Name: " + firstName +
                    ", Last Name: " + lastName + ", Salary: " + Math.round(salary * 100.0) / 100.0);
           // System.out.printf("Emp No: %d, First Name: %s, Last Name: %s, Salary: %.2f%n", empNo, firstName, lastName, salary);
        }
    }

    public static void testTask7() throws SQLException {
        System.out.println("Executing Task 7: Retrieve employees who have salaries between 50,000 and 100,000.");
        ResultSet sonuc = statement.executeQuery("SELECT e.* " +
                "FROM employees e " +
                "INNER JOIN salaries s ON e.emp_no = s.emp_no " +
                "WHERE s.salary BETWEEN 50000 AND 100000");

        int rowCount = 0;
        while (sonuc.next() && rowCount < 10) {
            rowCount++;
            int empNo = sonuc.getInt("emp_no");
            String firstName = sonuc.getString("first_name");
            String lastName = sonuc.getString("last_name");
            System.out.println("Employee Details - Emp No: " + empNo + ", First Name: " + firstName + ", Last Name: " + lastName);
            //System.out.printf("Emp No: %d, First Name: %s, Last Name: %s%n", empNo, firstName, lastName);
        }
    }

    public static void testTask8() throws SQLException {
        System.out.println("Executing Task 8: Calculate the average salary for each department (by department number).");
        ResultSet sonuc = statement.executeQuery("SELECT d.dept_no, AVG(s.salary) AS average_salary " +
                "FROM dept_emp de " +
                "JOIN salaries s ON de.emp_no = s.emp_no " +
                "JOIN departments d ON de.dept_no = d.dept_no " +
                "GROUP BY d.dept_no");

        while (sonuc.next()) {
            String deptNo = sonuc.getString("dept_no");
            double averageSalary = sonuc.getDouble("average_salary");
            System.out.println("Department Details - Dept No: " + deptNo + ", Average Salary: " + Math.round(averageSalary * 100.0) / 100.0);
            //System.out.printf("Dept No: %s, Average Salary: %.2f%n", deptNo, averageSalary);
        }
    }

    public static void testTask9() throws SQLException {
        System.out.println("Executing Task 9: Calculate the average salary for each department, including department names.");
        ResultSet sonuc = statement.executeQuery("SELECT d.dept_no, d.dept_name, AVG(s.salary) AS average_salary " +
                "FROM employees e " +
                "JOIN dept_emp de ON e.emp_no = de.emp_no " +
                "JOIN salaries s ON e.emp_no = s.emp_no " +
                "JOIN departments d ON de.dept_no = d.dept_no " +
                "GROUP BY d.dept_no, d.dept_name");

        while (sonuc.next()) {
            String deptNo = sonuc.getString("dept_no");
            String deptName = sonuc.getString("dept_name");
            double averageSalary = sonuc.getDouble("average_salary");
            System.out.println("Department Details - Dept No: " + deptNo + ", Dept Name: "
                    + deptName + ", Average Salary: " + Math.round(averageSalary * 100.0) / 100.0);
            //System.out.printf("Dept No: %s, Dept Name: %s, Average Salary: %.2f%n", deptNo, deptName, averageSalary);
        }
    }

    public static void testTask10() throws SQLException {
        System.out.println("Executing Task 10: Find all salary changes for employee with emp_no '10102'.");
        ResultSet sonuc = statement.executeQuery("SELECT emp_no, salary, from_date, to_date " +
                "FROM salaries " +
                "WHERE emp_no = '10102' " +
                "ORDER BY from_date");

        while (sonuc.next()) {
            int empNo = sonuc.getInt("emp_no");
            double salary = sonuc.getDouble("salary");
            String fromDate = sonuc.getString("from_date");
            String toDate = sonuc.getString("to_date");
            System.out.println("Salary Details - Emp No: " + empNo + ", Salary: "
                    + Math.round(salary * 100.0) / 100.0 + ", From Date: " + fromDate + ", To Date: " + toDate);
            //System.out.printf("Emp No: %d, Salary: %.2f, From Date: %s, To Date: %s%n", empNo, salary, fromDate, toDate);
        }
    }

    public static void testTask11() throws SQLException {
        System.out.println("Executing Task 11: Find the salary increases for employee with emp_no '10102'.");
        ResultSet sonuc = statement.executeQuery("SELECT emp_no, salary, to_date " +
                "FROM salaries " +
                "WHERE emp_no = '10102' " +
                "ORDER BY to_date");

        while (sonuc.next()) {
            int empNo = sonuc.getInt("emp_no");
            double salary = sonuc.getDouble("salary");
            String toDate = sonuc.getString("to_date");
            System.out.println("Salary Details - Emp No: " + empNo + ", Salary: "
                    + String.format("%.2f", salary) + ", To Date: " + toDate);
            //System.out.printf("Emp No: %d, Salary: %.2f, To Date: %s%n", empNo, salary, toDate);
        }
    }
}
