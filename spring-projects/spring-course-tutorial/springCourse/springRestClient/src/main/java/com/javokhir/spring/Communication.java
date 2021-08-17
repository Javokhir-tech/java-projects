package com.javokhir.spring;

import com.javokhir.spring.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    @Autowired
    private RestTemplate restTemplate;
    
    private final String URL = "http://localhost:8080/springRest/api/employees";    // url of server

    public List<Employee> getAllEmployees() {   // get all employees from server, exchange method to get
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null
                        , new ParameterizedTypeReference<List<Employee>>() {});
        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }

    public Employee getEmployee(int id) {   // get one, else throw exception
        Employee employee = null;
        try {
            employee = restTemplate.getForObject(URL + "/" + id,
                    Employee.class);
        } catch (Exception e) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }

        return employee;
    }

    public void saveEmployee(Employee employee) {   // save or update into db of the server
        int id = employee.getId();
        if (id == 0) {
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL, employee, String.class);
            System.out.println("New Employee was added to db");
            System.out.println(responseEntity.getBody());
        }
        else {
            restTemplate.put(URL, employee);
            System.out.println("Employee with id " + id + " was updated");
        }
    }

    public void deleteEmployee(int id) {    // delete from db
        restTemplate.delete(URL + "/" + id);
        System.out.println("Employee with id " + id + " was deleted from db");
    }
}
