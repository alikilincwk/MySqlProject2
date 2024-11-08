import Utilites.DBUtility;

public class Task17_21 extends DBUtility {
    public static void main(String[] args) {


        String Task18 = "select first_name , last_name, hire_date\n" +
                "from employees\n" +
                "where hire_date < '1990-01-01'\n" +
                "order by first_name, last_name, hire_date limit 1000";
        getListMethod(Task18);


        String Task19 = "select first_name, last_name, hire_date\n" +
                "from employees\n" +
                "where hire_date between '1985-01-01' and '1989-12-31'\n" +
                "order by first_name ,last_name, hire_date limit 100";
        getListMethod(Task19);


        String Task20 = "select first_name, last_name , hire_date , salary\n" +
                "from dept_emp\n" +
                "left join employees ON employees.emp_no = dept_emp.emp_no\n" +
                "left join departments ON departments.dept_no = dept_emp.dept_no\n" +
                "left join salaries ON salaries.emp_no = dept_emp.emp_no\n" +
                "where hire_date between '1985-01-01' and '1989-12-31'and departments.dept_name='Sales'\n" +
                "order by salary desc";
        getListMethod(Task20);

        String Task21_A = "select count(gender)\n" +
                "  from employees\n" +
                "  where gender='M';";
        getListMethod(Task21_A);

        String Task21_B = "select count(gender)\n" +
                " from employees\n" +
                " where gender='F';";
        getListMethod(Task21_B);

        String Task21_C = "select count(gender),gender\n" +
                " from employees\n" +
                " group by gender;";
        getListMethod(Task21_C);

        String Task21_D = "select count(emp_no) as Total\n" +
                "from employees;";
        getListMethod(Task21_D);

    }

}
