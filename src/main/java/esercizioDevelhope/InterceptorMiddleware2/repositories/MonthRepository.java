package esercizioDevelhope.InterceptorMiddleware2.repositories;

import esercizioDevelhope.InterceptorMiddleware2.entities.Month;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthRepository extends JpaRepository<Month, Integer> {
}
