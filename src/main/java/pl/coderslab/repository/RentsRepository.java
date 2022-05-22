package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Rents;

import java.util.List;

public interface RentsRepository extends JpaRepository<Rents,Long> {

    @Query("select r from Rents r where r.banner.id = :id")
    List<Rents> findByBannerId(Long id);


}
