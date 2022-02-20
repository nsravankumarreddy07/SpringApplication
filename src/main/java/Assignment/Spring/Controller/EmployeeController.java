package Assignment.Spring.Controller;


import Assignment.Spring.EmployeeException.EmployeeNotFoundException;
import Assignment.Spring.Model.Employee;
import Assignment.Spring.Model.EmployeeList;
import Assignment.Spring.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository repository;
    @Autowired
    Employee e;
    @Autowired
    EmployeeList employeeList;


    @GetMapping("/Employee")
    public List<Employee> getAllEmployees(){
        if(repository.findAll().isEmpty()){
            throw new EmployeeNotFoundException("No employees found");
        }
        return repository.findAll();
    }

    @GetMapping("/Employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return repository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Employee id:"+id+" not found"));
    }

    @GetMapping("/Employee/salary/{id}")
    public int getEmployeeSalary(@PathVariable int id){
        return repository.findById(id).get().getSalary();
    }
    //  @GetMapping("/Employee/Name/{id}")
    //  public String getEmployeeName(@PathVariable String Name){
    //      return repo.findById(Integer.valueOf(Name)).get().getName();
    // }

    @PutMapping("/Employee/add")
    public Employee addEmployee(Employee employee){
        repository.save(employee);
        return employee;
    }

    @PutMapping("/Employee/update/{id}")
    public Employee updateEmployee(@PathVariable int id) {

        return repository.findByIdUpdate(id);
    }

    @DeleteMapping("/Employee/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Employee deleted";
        }
        else throw new EmployeeNotFoundException("Employee id:"+id+" not found");
    }

    @GetMapping("/Employee/sort/{dept}")
    public List<Employee> getEmployees(@PathVariable int dept){
        return repository.findByDept(dept);
    }

}