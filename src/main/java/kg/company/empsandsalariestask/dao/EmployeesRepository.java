package kg.company.empsandsalariestask.dao;

import kg.company.empsandsalariestask.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    @Query(value = "select id from employees where id = ?1", nativeQuery = true)
    Long findEmplById(Long id);
}
