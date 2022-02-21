package Assignment.Spring.Repository;


import Assignment.Spring.Model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Bean
    @Query("update employee set salary=:salary where id=2")
    public default Employee findByIdUpdate(int id) {
        return null;
    }

    public List<Employee> findByDept(String dept);

    List<Employee> findByDept(int dept);
}
