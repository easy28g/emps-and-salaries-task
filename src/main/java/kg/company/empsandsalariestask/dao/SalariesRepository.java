package kg.company.empsandsalariestask.dao;

import kg.company.empsandsalariestask.models.Salaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalariesRepository extends JpaRepository<Salaries, Long> {
    @Query(value = "select emp_id from salaries where emp_id = ?1", nativeQuery = true)
    Long findSalaryByEmplId(Long id);
}
