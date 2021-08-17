package com.javokhir.spring.mvcHibernateAop.dao;

import com.javokhir.spring.mvcHibernateAop.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);
}
