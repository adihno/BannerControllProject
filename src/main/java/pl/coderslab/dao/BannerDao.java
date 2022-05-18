package pl.coderslab.dao;


import org.springframework.boot.Banner;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Banners;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class BannerDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveBanner(Banner banner){
        entityManager.getTransaction().begin();
        entityManager.persist(banner);
        entityManager.getTransaction().commit();
    }
    public void updateBanner(Banner banner){
        entityManager.getTransaction().begin();
        entityManager.merge(banner);
        entityManager.getTransaction().commit();
    }
    public List<Banners> getBannersListByAdminId(int id){
        Query query = entityManager.createQuery("select b from Banners b where b.admin.id = :adminId");
        query.setParameter("adminId", id);
        List<Banners> bannersList = query.getResultList();
        return bannersList;
    }
    public List<Banners> getBannerById(int id){
        Query query = entityManager.createQuery("select b from Banners b where b.id = :id");
        query.setParameter("id",id);
        return query.getResultList();
    }

}
