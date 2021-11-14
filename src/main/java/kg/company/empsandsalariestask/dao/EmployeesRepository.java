package kg.company.empsandsalariestask.dao;

import kg.company.empsandsalariestask.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

}
