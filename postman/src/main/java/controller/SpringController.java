package controller;

import model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@RestController
public class SpringController {
    List<Employee> employeeList= new ArrayList<Employee>();
    @GetMapping("/employees")
    public List<Employee> get() {
        return employeeList;
    }
    @PostMapping("/employees")
    public Employee post(@RequestBody Employee employee)
    {
        employeeList.add(employee);
        return employee;
    }

    @DeleteMapping(value = "/employees/{empId}")
    public List<Employee> delete(@PathVariable String empId) {
        ListIterator<Employee>
                iterator = employeeList.listIterator();
        while (iterator.hasNext()) {

            if(iterator.next().getId().equals(id))
            {
                iterator.remove();
                break;
            }
        }
        return employeeList;
    }
    @PutMapping(value = "/employees/{empId}")
    public List<Employee> put(@PathVariable String empId,@RequestBody Employee employee) {

        ListIterator<Employee>
                iterator = employeeList.listIterator();
        while (iterator.hasNext()) {

            Employee tempEmp = iterator.next();
            if(tempEmp.getId().equals(id))
            {
                tempEmp.setName(employee.getName());
                break;
            }
        }
        return employeeList;
    }

}