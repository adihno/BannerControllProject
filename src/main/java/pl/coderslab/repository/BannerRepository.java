package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Banners;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface BannerRepository extends JpaRepository<Banners,Long> {
    @Query("select b from Banners b where b.admin.id = :adminId")
    List<Banners> getByAdminId(Long adminId);
    @Modifying
    @Query("update Banners b set b.street = ?1, b.price = ?2 , b.is_rented = ?3 where b.id = ?4")
    void setUserInfoById(String street, int price, boolean isRented, Long id);

    @Query("select b from Banners b where b.id = :id")
    List<Banners> getBannersById (Long id);

}
