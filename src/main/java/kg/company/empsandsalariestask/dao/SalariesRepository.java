package kg.company.empsandsalariestask.dao;

import kg.company.empsandsalariestask.models.Salaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalariesRepository extends JpaRepository<Salaries, Long> {

}
