package DAO;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {

    public void insert(Employee employee);

    public void update(Employee employee);

    public void delete(int id);

    public Employee get(int id);

    public List<Employee> list();
}
