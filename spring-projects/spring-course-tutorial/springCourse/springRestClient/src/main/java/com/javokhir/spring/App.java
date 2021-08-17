package com.javokhir.spring;

import com.javokhir.spring.configuration.MyConfig;
import com.javokhir.spring.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Communication communication = context.getBean("communication",
                Communication.class);

        /* get all employees */
        System.out.println(communication.getAllEmployees());

        /* get one employee with id 1*/
        Employee employee = communication.getEmployee(1);
        System.out.println(employee);

        /* create new employee or update */
        Employee emp = new Employee("Bob", "Marly", "IT", 500);
        emp.setId(10);
        communication.saveEmployee(emp);

        /* delete employee */
        communication.deleteEmployee(10);
    }
}
