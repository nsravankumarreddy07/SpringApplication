package Assignment.Spring.Model;

import Assignment.Spring.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeList {
    @Autowired
    EmployeeRepository repo;
    public static List<Employee> list = new ArrayList<>();

    public void ce(){
        list = repo.saveAll(repo.findAll());

    }
}
