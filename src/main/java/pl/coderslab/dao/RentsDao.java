package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Rents;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RentsDao {
    @PersistenceContext
    EntityManager entityManager;
    public List<Rents> findRentByBannerId(int id){
        Query query = entityManager.createQuery("select r from Rents r where r.banner.id = :id");
        query.setParameter("id", id);
        List<Rents> rentsList = query.getResultList();

        return rentsList;
    }
}
