import Utilites.DBUtility;

public class Task22_26 extends DBUtility {
    public static void main(String[] args) {

        String Task22 = "Select count(DISTINCT first_name) as Benzersiz_isim\n" +
                "from employees limit 1000";
        getListMethod(Task22);

        String Task23 = "select count(DISTINCT dept_no) from departments";
        getListMethod(Task23);

        String Task24 = "select *\n" +
                "from employees\n" +
                "where hire_date between '1990-02-20' and '1995-02-20' limit 1000";
        getListMethod(Task24);

        String Task25 = "select emp_no,birth_date,first_name,last_name,gender,hire_date\n" +
                "from employees\n" +
                "where first_name='Annemarie' and last_name='Redmiles' limit 1000";
        getListMethod(Task25);

        String Task26 = "select employees.emp_no, birth_date, first_name, last_name, gender, hire_date, salaries.salary, departments.dept_name, titles.title\n" +
                "from dept_emp\n" +
                "left join employees on employees.emp_no= dept_emp.emp_no\n" +
                "left join departments on departments.dept_no= dept_emp.dept_no\n" +
                "left join titles on titles.emp_no= dept_emp.emp_no\n" +
                "left join salaries on salaries.emp_no= dept_emp.emp_no\n" +
                "where first_name='Annemarie' and last_name='Redmiles' limit 1000";
        getListMethod(Task26);


    }

}

