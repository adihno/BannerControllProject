package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Renters;


public interface RentersRepository extends JpaRepository<Renters,Long> {
}
