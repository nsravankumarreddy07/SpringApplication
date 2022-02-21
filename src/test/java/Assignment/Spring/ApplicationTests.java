package Assignment.Spring;


import Assignment.Spring.Repository.EmployeeRepository;
import Assignment.Spring.Model.Employee;
import Assignment.Spring.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests  {

	@Autowired
	private EmployeeService service;
    @MockBean
	private EmployeeRepository repository;

    @Test
    public void addEmployeeTest(){
        Employee e =new Employee(3,"Srijan",40000,3);
        when(repository.save(e)).thenReturn(e);
        assertEquals(e,service.addEmployee(e));

    }
    @Test
	void getAllEmployees() {
        when(repository.findAll()).thenReturn(Stream
                .of(new Employee(3,"Srijan",40000,3), new Employee(4,"Pavan",31000,4)).collect(Collectors.toList()));
        assertEquals(2, service.getEmployee().size());
    }
    @Test
    void getEmployee() {
        when(repository.findByDept("dept"))
                .thenReturn(Stream.of(new Employee(3,"Srijan",40000,3)).collect(Collectors.toList()));
                Assertions.assertEquals(0, service.findByDept().size());
    }

    @Test
    void getEmployeeSalary() {
        Employee employee = new Employee(3,"Srijan",40000,3);
        when(repository.save(employee)).thenReturn(employee);
        assertEquals(employee, service.addEmployee(employee));
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee(3,"Srijan",40000,3 );
        when(repository.save(employee)).thenReturn(employee);
        assertEquals(employee, service.addEmployee(employee));
    }

    @Test
    void deleteEmployee() {
        Employee employee = new Employee(3,"Srijan",40000,3);
	    service.deleteEmployee(employee);
		verify(repository, times(1)).delete(employee);
    }


    @Test
    void addEmployees() {
        when(repository.findAll()).thenReturn(Stream
                .of(new Employee(3,"Srijan",40000,3), new Employee(4,"Pavan",31000,4)).collect(Collectors.toList()));
        assertEquals(2, service.getEmployee().size());
    }
}

