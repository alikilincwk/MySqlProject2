import Utilites.DBUtility;

public class Task1_5 extends DBUtility {
    public static void main(String[] args) {

        printDescription.Task01();
        getListMethod(getTask.Task01);

        printDescription.Task02();
        getListMethod(getTask.Task02);


        printDescription.Task03();
        getListMethod(getTask.Task03);


        printDescription.Task04();
        getListMethod(getTask.Task04);


        printDescription.Task05();
        getListMethod(getTask.Task05);

    }

    public static class getTask {

        private static final String Task01 = "SELECT *\n" +
                "FROM employees\n" +
                "INNER JOIN dept_emp ON employees.emp_no = dept_emp.emp_no\n" +
                "WHERE dept_no = 'D001'" ;

        private static final String Task02 = "SELECT employees.*\n" +
                "FROM employees\n" +
                "INNER JOIN dept_emp ON employees.emp_no = dept_emp.emp_no\n" +
                "INNER JOIN departments ON dept_emp.dept_no = departments.dept_no\n" +
                "WHERE departments.dept_name = 'Human Resources' ";

        private static final String Task03 = "SELECT AVG(salary) AS average_salary\n" +
                "FROM salaries ";

        private static final String Task04 = "SELECT AVG(s.salary) AS average_salary\n" +
                "FROM employees e\n" +
                "INNER JOIN salaries s ON e.emp_no = s.emp_no\n" +
                "WHERE e.gender = 'F' ";

        private static final String Task05 = "SELECT AVG(s.salary) AS average_salary\n" +
                "FROM employees e\n" +
                "INNER JOIN salaries s ON e.emp_no = s.emp_no\n" +
                "WHERE e.gender = 'M' ";
    }

    public static class printDescription {
        public static void Task01() {
            System.out.println("1. List all employees in department D001. \n");
        }

        public static void Task02() {
            System.out.println("\n2. List all employees in 'Human Resources' department. \n");
        }

        public static void Task03() {
            System.out.println("\n3. Calculate the average salary of all employees. \n");
        }

        public static void Task04() {
            System.out.println("\n4. Calculate the average salary of all employees with gender \"M\". \n");
        }

        public static void Task05() {
            System.out.println("\n5. Calculate the average salary of all employees with gender \"F\". \n");
        }
    }

}
