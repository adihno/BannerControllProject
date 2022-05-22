package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    @Query("select a from Admin a where a.email = :email")
    Admin getAdminByEmail(String email);
}
