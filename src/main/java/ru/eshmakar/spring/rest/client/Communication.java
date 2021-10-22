package ru.eshmakar.spring.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.eshmakar.spring.rest.client.entity.Employee;

import java.util.List;

@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/api/employees/";


    public List<Employee> getAllEmployee() {
        //с помощью ResponseEntity отправляем запрос и получаем в ответе список работников
        //exchange - Выполнить HTTP-метод для данного шаблона URI, записать заданный объект запроса в запрос и вернуть ответ как ResponseEntity
        // ParameterizedTypeReference - используется для передачи информации об общем типе
        ResponseEntity<List<Employee>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});

        List<Employee> employeeList = responseEntity.getBody();
        return employeeList;
    }


    public Employee getEmployee(int id) {
        Employee employee = restTemplate.getForObject(URL+"/"+id, Employee.class);
        System.out.println(employee);
        return employee;
    }

    public void saveEmployee(Employee employee) {
        int id = employee.getId();
        if (id==0){//если такого работника нет (по умолчанию если не указывать id, он будет 0)
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, employee, String.class);//отправляем работника на сервер методом post
            responseEntity.getBody();
            System.out.println("The employee was added to DB");
        }
        else {
            restTemplate.put(URL, employee);//если такой работник существует, то меняем данные в бд
            System.out.println("Employee with id " + id + " was updated");
        }

    }

    public void deleteEmployee(int id) {
        restTemplate.delete(URL+"/"+id);
        System.out.println("The employee with id " + id + " was deleted");

    }
}
