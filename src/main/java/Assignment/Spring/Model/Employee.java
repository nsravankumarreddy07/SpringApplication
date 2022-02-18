package Assignment.Spring.Model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
//@Table(name="EMPLOYEE")
public class Employee {
    @Id
    public int id;
    public String name;
    public int salary;
    public int dept;
}