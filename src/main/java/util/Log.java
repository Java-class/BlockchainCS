
package util;

import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;


public class Log {
    private static Logger logger;

    public static void infoLog(String msg ){
        logger = Logger.getLogger("infologger");
        if(logger.isInfoEnabled())
            logger.info("[CN] "+Thread.currentThread().getStackTrace()[2].getClassName() + " [MN] " + Thread.currentThread().getStackTrace()[2].getMethodName()+" [MSG] "+ msg);
    }

    public static void debugLog(String msg){
        logger = Logger.getLogger("debuglogger");
        if(logger.isDebugEnabled()){
            logger.debug("[CN] "+Thread.currentThread().getStackTrace()[2].getClassName() + " [MN] " + Thread.currentThread().getStackTrace()[2].getMethodName()+ " [MSG] "+ msg);
        }
    }

    public static void traceLog(String msg){
       logger = Logger.getLogger("tracelogger");
        if(logger.isTraceEnabled()){
            logger.trace("[CN] "+Thread.currentThread().getStackTrace()[2].getClassName() + " [MN] " + Thread.currentThread().getStackTrace()[2].getMethodName()+ " [MSG] "+ msg);
        }
    }
    public static void fatalLog(Throwable e){
        logger = Logger.getLogger("fatallogger");
        StringWriter writer = new StringWriter();
        e.printStackTrace(new PrintWriter(writer));
        logger.error("[CN] "+Thread.currentThread().getStackTrace()[2].getClassName()+ " [MN] " + Thread.currentThread().getStackTrace()[2].getMethodName()+ " [MSG] "+ writer.toString());
        Util.closeWriter(writer);
    }

    public static void errorLog(Throwable e){
        logger = Logger.getLogger("errorlogger");
        StringWriter writer = new StringWriter();
        e.printStackTrace(new PrintWriter(writer));
        logger.error("[CN] "+Thread.currentThread().getStackTrace()[2].getClassName()+ " [MN] " + Thread.currentThread().getStackTrace()[2].getMethodName()+ " [MSG] "+ writer.toString());
        Util.closeWriter(writer);
    }

    public static void warnLog(String msg){
        logger = Logger.getLogger("warnlogger");
        //logger.setLevel(Level.WARN);
        logger.warn("[CN] "+Thread.currentThread().getStackTrace()[2].getClassName()+ " [MN] " + Thread.currentThread().getStackTrace()[2].getMethodName()+", [MSG] "+ msg);
    }


}
