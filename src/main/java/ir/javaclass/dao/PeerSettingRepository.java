package ir.javaclass.dao;
import ir.javaclass.entity.PeerSetting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeerSettingRepository extends CrudRepository<PeerSetting,String> {

        /*public static PeerSetting save(PeerSetting setting) {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            try {
                session.getTransaction().begin();
                session.saveOrUpdate(setting);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
            return setting;
        }

        public static void delete(PeerSetting setting) {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            try {
                session.getTransaction().begin();
                session.delete(session);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }


        public static PeerSetting getSetting(String publicKey) {
            PeerSetting result = null;
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            try {
                session.getTransaction().begin();
                result = session.get(PeerSetting.class, publicKey);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
            return result;
        }*/

}
