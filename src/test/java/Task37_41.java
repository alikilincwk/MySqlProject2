import Utilites.DBUtility;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Task37_41 extends DBUtility {
    public static void main(String[] args) throws SQLException {
        DBConnectionOpen();

        System.out.println("\n--- Starting Task 37 ---\n");
        testTask37();
        System.out.println("\n--- End of Task 37 ---\n");

        System.out.println("\n--- Starting Task 38 ---\n");
        testTask38();
        System.out.println("\n--- End of Task 38 ---\n");

        System.out.println("\n--- Starting Task 39 ---\n");
        testTask39();
        System.out.println("\n--- End of Task 39 ---\n");

        System.out.println("\n--- Starting Task 40 ---\n");
        testTask40();
        System.out.println("\n--- End of Task 40 ---\n");

        System.out.println("\n--- Starting Task 41 ---\n");
        testTask41();
        System.out.println("\n--- End of Task 41 ---\n");

        DBConnectionClose();
    }

    public static void testTask37() throws SQLException {
        System.out.println("Executing Task 37:Find the latest title information for each employee.");
        ResultSet sonuc = statement.executeQuery("SELECT emp_no, title, from_date " +
                "FROM employees.titles " +
                "WHERE to_date = '9999-01-01'");

        int rowCount = 0;
        while (sonuc.next() && rowCount < 10) {
            rowCount++;
            int empNo = sonuc.getInt("emp_no");
            String title = sonuc.getString("title");
            String fromDate = sonuc.getString("from_date");
            System.out.println("Employee Details - Emp No: " + empNo + ", Title: " + title + ", From Date: " + fromDate);
        }
    }

    public static void testTask38() throws SQLException {
        System.out.println("Executing Task 38: Find the first and last names of managers in department 'D005'");
        ResultSet sonuc = statement.executeQuery("SELECT e.first_name, e.last_name " +
                "FROM employees.employees e " +
                "JOIN employees.dept_manager dm ON e.emp_no = dm.emp_no " +
                "WHERE dm.dept_no = 'd005'");

        int rowCount = 0;
        while (sonuc.next() && rowCount < 10) {
            rowCount++;
            String firstName = sonuc.getString("first_name");
            String lastName = sonuc.getString("last_name");
            System.out.println("Manager Details - First Name: " + firstName + ", Last Name: " + lastName);
        }
    }

    public static void testTask39() throws SQLException {
        System.out.println("Executing Task 39: Sort employees by their birth dates");
        ResultSet sonuc = statement.executeQuery("SELECT * " +
                "FROM employees.employees " +
                "ORDER BY birth_date");

        int rowCount = 0;
        while (sonuc.next() && rowCount < 10) {
            rowCount++;
            int empNo = sonuc.getInt("emp_no");
            String firstName = sonuc.getString("first_name");
            String lastName = sonuc.getString("last_name");
            String birthDate = sonuc.getString("birth_date");
            System.out.println("Employee Details - Emp No: " + empNo + ", First Name: " + firstName + ", Last Name: "
                    + lastName + ", Birth Date: " + birthDate);
        }
    }

    public static void testTask40() throws SQLException {
        System.out.println("Executing Task 40: List employees hired in April 1992.");
        ResultSet sonuc = statement.executeQuery("SELECT emp_no, first_name, last_name, gender, hire_date " +
                "FROM employees.employees " +
                "WHERE hire_date BETWEEN '1992-04-01' AND '1992-04-30' " +
                "ORDER BY hire_date ASC");

        int rowCount = 0;
        while (sonuc.next() && rowCount < 10) {
            rowCount++;
            int empNo = sonuc.getInt("emp_no");
            String firstName = sonuc.getString("first_name");
            String lastName = sonuc.getString("last_name");
            String gender = sonuc.getString("gender");
            String hireDate = sonuc.getString("hire_date");
            System.out.println("Employee Details - Emp No: " + empNo + ", First Name: "
                    + firstName + ", Last Name: " + lastName + ", Gender: " + gender + ", Hire Date: " + hireDate);
        }
    }

    public static void testTask41() throws SQLException {
        System.out.println("Executing Task 41: Find all departments that employee '10102' has worked in.");
        ResultSet sonuc = statement.executeQuery("SELECT DISTINCT e.first_name, e.last_name, d.dept_name " +
                "FROM employees.dept_emp de " +
                "JOIN employees.employees e ON de.emp_no = e.emp_no " +
                "JOIN employees.departments d ON de.dept_no = d.dept_no " +
                "WHERE de.emp_no = '10102'");

        int rowCount = 0;
        while (sonuc.next() && rowCount < 10) {
            rowCount++;
            String firstName = sonuc.getString("first_name");
            String lastName = sonuc.getString("last_name");
            String deptName = sonuc.getString("dept_name");
            System.out.println("Department Details - First Name: " + firstName + ", Last Name: "
                    + lastName + ", Department Name: " + deptName);
        }
    }
}
