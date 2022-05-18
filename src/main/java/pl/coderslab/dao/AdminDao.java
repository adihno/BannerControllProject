package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Admin;


import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class AdminDao {
    @PersistenceContext
    EntityManager entityManager;
    public void saveAdmin(Admin admin){
        entityManager.persist(admin);
    }
    public void delete(Admin admin){
        entityManager.remove(entityManager.contains(admin) ?
                admin : entityManager.merge(admin)); }


    public boolean isInDatabase(Admin admin){
        Query query = entityManager.createQuery("select a from Admin a where a.email = :email and a.password = :password");
        query.setParameter("email",admin.getEmail());
        query.setParameter("password", admin.getPassword());
        List<Admin> admins = query.getResultList();
        if(admins.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    public List<Admin> getAllAdmins(){
            Query query = entityManager.createQuery("select a from Admin a");
            return query.getResultList();
    }
    public Admin getAdminByEmail(String email){
        Query query = entityManager.createQuery("select a from Admin a where a.email = :email");
        query.setParameter("email", email);
        List<Admin> result = query.getResultList();
        return result.get(0);
    }




}
