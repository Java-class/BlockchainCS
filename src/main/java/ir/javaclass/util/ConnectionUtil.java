package ir.javaclass.util;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

public class ConnectionUtil {
    private static Web3j web3jConnection = null;

    private ConnectionUtil() {
        super();
    }

    public static Web3j getWeb3jConnection() {
        if (web3jConnection == null) {
            synchronized (Web3j.class) {
                if (web3jConnection == null) {
                    try {
                        System.out.println("Connecting to Ethereum ...");
                        web3jConnection = Web3j.build(new HttpService("http://127.0.0.1:7546"));
                        System.out.println("Successfully connected to Ethereum Network.");
                        System.out.println("Client Version: " + web3jConnection.web3ClientVersion().send().getWeb3ClientVersion());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        return web3jConnection;
    }

    public static void shutdown() {
        getWeb3jConnection().shutdown();
    }
}
