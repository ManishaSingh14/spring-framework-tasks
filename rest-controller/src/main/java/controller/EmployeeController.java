package controller;

import model.Employee;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/")
public class EmployeeController {

    private List<Employee> employeeList=new ArrayList<>();

    @PostConstruct
    public void loadData()
    {
        employeeList.add(new Employee(0,"A","HR"));
        employeeList.add(new Employee(1,"B","IT"));
        employeeList.add(new Employee(2,"C","SALES"));
    }
    @GetMapping("/employee")
    public List<Employee> getEmployees()

    {
        return employeeList;
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable Integer employeeId)
    {
        return employeeList.get(employeeId);
    }
}

