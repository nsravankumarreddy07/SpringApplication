package Assignment.Spring.Repository;


import Assignment.Spring.Model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //  static List<Employee> findById(long l) {
    //      return findById(long l);
    //  }
    

    @Bean
    @Query("update employee set salary=:salary where id=22")
    public default Employee findByIdUpdate(int id) {
        return null;
    }

    public List<Employee> findByDept(String dept);

    List<Employee> findByDept(int dept);
}
