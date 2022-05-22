package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Rents;

public interface RentersRepository extends JpaRepository<Rents,Long> {
}
