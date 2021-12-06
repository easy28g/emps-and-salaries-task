package kg.company.empsandsalariestask.dao;

import kg.company.empsandsalariestask.models.Salaries;
import kg.company.empsandsalariestask.models.dto.SalariesDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalariesRepository extends JpaRepository<Salaries, Long> {
    @Query(value = "select emp_id from salaries where emp_id = ?1", nativeQuery = true)
    Long findSalaryByEmplId(Long id);
    @Query(value = "select * from salaries where emp_id = ?1 and end_date > ?2", nativeQuery = true)
    Salaries findAllSeleryByEmplId(Long id, LocalDate localDate);
    @Query(value = "select salary from salaries where emp_id = ?1 and end_date > ?2", nativeQuery = true)
    BigDecimal getSalaryOfEmplByEmplId(Long fkEmplId, LocalDate localDate);
}
