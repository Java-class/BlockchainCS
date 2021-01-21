package ir.javaclass.config;

import ir.javaclass.entity.Peer;

import java.math.BigInteger;

public class Commons {

    public final static String OWNER_PEERS = "0470ea77351c5ac3d9d4a7a57c4abefb2dd23898b9d48dcd98b52d6e7c86cf11";
    public final static String USER_PEER_PVK = "d3936809878121364c0ffa0963c2f66daeb7778ad35ffc15ba11e140a1272def";
    public final static String USER_PEER_PBK = "0x38B8DC823Ce7477729507847bE7F83c7D5974Bd5";
    //public final static String MOUNT_POINT_ADDRESS = "C:\\Users\\Mostafa\\Desktop\\blockchain-cs\\peer_data\\user-data";
    public final static String MOUNT_POINT_ADDRESS = "/home/mostafa/00-Developing/blockchain-cs/peer_data/user_data";
    public final static String CHUNK_SUFFIX = "-chunk";
    public final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    public final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    public final static String PEER_CONTRACT_ADDRESS = "0x2e3963255d2911153ab85095a23ed2476dff83f8";

    /// peer local setting
    public final static String ownerAddress = USER_PEER_PBK;
    public final static String publicUrl = "127.0.0.1:8080";
    public final static int maxUser = 100;
    public final static long totalSpace = 1024000000;
    public final static long maxBandwidth = 102400;
    public final static int uptimePercentage = 90;
    public final static String availableTimeRange = "5*24";
    public final static Peer.PeerStatus peerStatus = Peer.PeerStatus.ACTIVE;
}
