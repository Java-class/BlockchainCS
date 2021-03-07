package ir.javaclass.config;

import ir.javaclass.entity.Peer;

import java.math.BigInteger;

public class Commons {

    public final static String OWNER_PEERS = "48549222538a31b595e955b364ace662306178bd7ce536718804fd6b8bb36e88";
    public final static String USER_PEER_PVK = "eafbc4cf238d322b63bcb7ee3f7c25f2d3886d20cbc852e8ef89b46b6e4ef301";
    public final static String USER_PEER_PBK = "0xEf8f0bE2811D18Dd66EaCE3E315BE6C463E47aC6";
    public final static String MOUNT_POINT_ADDRESS = "C:\\Users\\Mostafa\\Desktop\\blockchain-cs\\peer_data\\user-data";
    //public final static String MOUNT_POINT_ADDRESS = "/home/mostafa/00-Developing/blockchain-cs/peer_data/user_data";
    public final static String CHUNK_SUFFIX = "-chunk";
    public final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    public final static BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);
    public final static String PEER_CONTRACT_ADDRESS = "0xfe7494cf295fdb9cf7fb7c4cb98adfbf77d22ccb";

    /// peer local setting
    public final static String ownerAddress = USER_PEER_PBK;
    public final static String publicUrl = "http://192.168.1.101:8085";
    public final static int maxUser = 100;
    public final static long totalSpace = 1024000000;
    public final static long maxBandwidth = 102400;
    public final static int uptimePercentage = 90;
    public final static String availableTimeRange = "5*24";
    public final static Peer.PeerStatus peerStatus = Peer.PeerStatus.ACTIVE;
}
