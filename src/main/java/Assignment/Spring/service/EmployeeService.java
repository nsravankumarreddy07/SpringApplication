package Assignment.Spring.service;

import Assignment.Spring.Repository.EmployeeRepository;
import Assignment.Spring.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;
    private int dept;


    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getEmployee() {
        List<Employee> employees = repository.findAll();
        System.out.println(employees);
        return employees;
    }

    public List<Employee> findByDept() {
        return repository.findByDept(dept);
    }

    public void deleteEmployee(Employee employee) {
        repository.delete(employee);
    }

    /**
     * @return
     */
    public List<Employee> addEmployee() {
        return addEmployee();
    }

}