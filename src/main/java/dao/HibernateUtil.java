package dao;

import org.hibernate.Cache;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import util.Log;


public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    private HibernateUtil() {
        super();
    }

    public static final SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (SessionFactory.class) {
                if (sessionFactory == null) {
                    try{
                        sessionFactory = new Configuration().configure().buildSessionFactory();
                        Log.infoLog("Peer Server Hibernate Session factory is created.");
                    }
                    catch (Exception ex){
                        Log.errorLog(ex);
                        ex.printStackTrace();
                    }
                }
            }
        }
        return sessionFactory;
    }

    public static void test(){
        sessionFactory.getSessionFactoryOptions();
    }

    public static void shutdown()
    {
        getSessionFactory().close();
    }

    public static void resetHibernateCache(){
        Cache cache = sessionFactory.getCache();
        if (cache != null) {
            //cache.evictAllRegions(); // Evict data from all query regions.
            cache.evictAll();
            Log.infoLog("Hibernate All Cache Was Deleted.");
        }
    }

}


