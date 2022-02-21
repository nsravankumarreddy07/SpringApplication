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
    EmployeeList employeeList;

    @GetMapping("/Sravan")
    public List<Employee> getAllEmployees(){
        if(repository.findAll().isEmpty()){
            throw new EmployeeNotFoundException("No employees found");
        }
        return repository.findAll();
    }

    @GetMapping("/Sravan/{id}")
    public Employee getEmployee(@PathVariable int id){
        return repository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Employee id:"+id+" not found"));
    }

    @GetMapping("/Sravan/salary/{id}")
    public int getEmployeeSalary(@PathVariable int id){
        return repository.findById(id).get().getSalary();
    }


    @PutMapping("/Sravan/add")
    public Employee addEmployee(Employee employee){
        repository.save(employee);
        return employee;
    }

    @PutMapping("/Sravan/update/{id}")
    public Employee updateEmployee(@PathVariable int id) {

        return repository.findByIdUpdate(id);
    }

    @DeleteMapping("/Sravan/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Employee deleted";
        }
        else throw new EmployeeNotFoundException("Employee id:"+id+" not found");
    }

    @GetMapping("/Sravan/sort/{dept}")
    public List<Employee> getEmployees(@PathVariable int dept){
        return repository.findByDept(dept);
    }

}