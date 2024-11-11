import Utilites.DBUtility;

public class Task32_36 extends DBUtility {
    public static void main(String[] args) {

        System.out.println("\n\n************************* TASK 32 *******************************\n\n");
        //Find the entire position history for employee with emp. no '10102'
        String task32 = "select first_name,last_name,titles.*\n" +
                " from titles\n" +
                " left join employees ON titles.emp_no=employees.emp_no\n" +
                " where titles.emp_no=10102;";
        getListMethod(task32);

        System.out.println("\n\n************************* TASK 33 *******************************\n\n");
        //Finding the average "employee age"
        String task33 = "select avg(2024 - substr(birth_date,1, 4)) as AverageAge\n" +
                "from employees;";
        getListMethod(task33);

        System.out.println("\n\n************************* TASK 34 *******************************\n\n");
        //Finding the number of employees per department
        String task34 = "select dept_no, count(*) as TotalEmployee\n" +
                "from dept_emp\n" +
                "group by dept_no;";
        getListMethod(task34);

        System.out.println("\n\n************************* TASK 35 *******************************\n\n");
        //Finding the managerial history of employee with ID (emp. no) 110022
        String task35 = "select dept_manager.emp_no,first_name ,last_name,dept_name,from_date,to_date\n" +
                "from dept_manager\n" +
                "left join employees ON employees.emp_no=dept_manager.emp_no\n" +
                "left join departments ON departments.dept_no=dept_manager.dept_no\n" +
                "where dept_manager.emp_no= 110022;";
        getListMethod(task35);

        System.out.println("\n\n************************* TASK 36 *******************************\n\n");
        //Find the duration of employment for each employee
        String task36 = "select*, (2024-substr(hire_date,1, 4)) as DurOfEmployement\n" +
                " from employees\n" +
                " limit 500;";
        getListMethod(task36);


    }
}
