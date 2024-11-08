import Utilites.DBUtility;

import java.util.List;

public class Task27_31 extends DBUtility {
    public static void main(String[] args) {

        String TASK27 = "select* \n" +
                "from dept_emp\n" +
                "left join dept_manager ON dept_emp.dept_no=dept_manager.dept_no\n" +
                "where dept_emp.dept_no='d005' and dept_manager.dept_no='d005' limit 1000";
        getListMethod(TASK27);

        String TASK28 = "select* \n" +
                "from employees\n" +
                "left join salaries on employees.emp_no=salaries.emp_no\n" +
                "where employees.hire_date >'1994-02-24'\n" +
                "and salaries.salary >'50000' limit 1000";
        getListMethod(TASK28);

        String TASK29 = "select*\n" +
                "from departments \n" +
                "left join dept_manager ON departments.dept_no=dept_manager.dept_no\n" +
                "where departments.dept_no='d007' and dept_manager.dept_no='d007' limit 1000";
        getListMethod(TASK29);

        String TASK30 = "SELECT dept_emp.emp_no, from_date, to_date, departments.dept_name ,\n" +
                "       TIMESTAMPDIFF(YEAR, dept_emp.from_date, dept_emp.to_date) AS Years\n" +
                "FROM dept_emp\n" +
                "left join departments ON departments.dept_no = dept_emp.dept_no \n" +
                "WHERE emp_no = '11102' and TIMESTAMPDIFF(YEAR, dept_emp.from_date, dept_emp.to_date)\n" +
                "ORDER BY dept_emp.from_date limit 1000";
        getListMethod(TASK30);

        String TASK31 = "select  departments.dept_no ,employees.first_name ,employees.last_name, salary\n" +
                "from salaries\n" +
                "left join employees ON employees.emp_no = salaries.emp_no\n" +
                "left join dept_emp ON employees.emp_no = dept_emp.emp_no\n" +
                "left join departments ON departments.dept_no =dept_emp.dept_no\n" +
                "where departments.dept_no='d004' order by salaries.salary desc limit 1 limit 1000";
        getListMethod(TASK31);
    }
}
