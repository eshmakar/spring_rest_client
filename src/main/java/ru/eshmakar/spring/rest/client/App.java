package ru.eshmakar.spring.rest.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.eshmakar.spring.rest.client.configuration.MyConfig;
import ru.eshmakar.spring.rest.client.entity.Employee;

import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);//подключаем конфигурационный класс
        Communication communication = context.getBean("communication", Communication.class);//получаем бин

        //ПОЛУЧЕНИЕ СПИСКА ВСЕХ РАБОТНИКОВ
//        List<Employee> list = communication.getAllEmployee();
//        list.forEach(System.out::println);

        //ПОЛУЧЕНИЕ ОДНОГО РАБОТНИКА ПО ID
//        Employee employee = communication.getEmployee(2);
//        System.out.println(employee);

        //СОХРАНЯЕМ ИЛИ ИЗМЕНЯЕМ РАБОТНИКА, ПРИ ИЗМЕНЕНИИ НЕОБХОДИМО УКАЗАТЬ ID ВРУЧНУЮ  - employee.setId(26);
//        Employee employee = new Employee("Pasha", "Sergeev", "It", 5695);
//        communication.saveEmployee(employee);
//        employee.setId(26);
//        System.out.println(employee);

        //УДАЛЯЕМ РАБОТНИКА ПО ID
        communication.deleteEmployee(26);

    }
}
