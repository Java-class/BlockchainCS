package dao;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HibernateUtilTest {

    @Test
    void getSessionFactory() {
        /// test h2 connection
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Statistics statistics = sf.getStatistics();
        String[] entityNames = statistics.getEntityNames();
        for(String  name: entityNames)
            System.out.println(name);
    }
}