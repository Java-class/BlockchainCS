package config;
import dao.HibernateUtil;


import javax.inject.Singleton;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class ContextListener implements ServletContextListener {

    private static String rootPath = null;
    private static String rootPathWithoutSlash = null;

    private static Map map = new HashMap();
    private static List<String> list = new ArrayList<String>();

    public static String getRootPath() {
        return rootPath;
    }

    public static String getRootPathWithoutSlash() {
        return rootPathWithoutSlash;
    }

    public static Map getMountMap() { return map; }

    public static List<String> getMountPath() { return list; }


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        rootPath = servletContextEvent.getServletContext().getRealPath("");
        rootPathWithoutSlash = rootPath;
        if (!rootPath.endsWith("/")) rootPath += "/";
        if (rootPathWithoutSlash.endsWith("/")) rootPathWithoutSlash = rootPathWithoutSlash.substring(0, rootPathWithoutSlash.length() - 1);

        HibernateUtil.getSessionFactory();
        //EntityManagerUtil.getEntityManagerFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        /// close hibernate Session Factory
        HibernateUtil.shutdown();
    }
}