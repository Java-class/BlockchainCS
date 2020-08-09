package ir.javaclass.service;


import ir.javaclass.config.Commons;
import ir.javaclass.contract.PeerList;
import ir.javaclass.entity.Peer;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple11;
import org.web3j.tx.gas.DefaultGasProvider;
import ir.javaclass.util.ConnectionUtil;
import ir.javaclass.util.Log;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeerService {
    public static String deployPeerContract(){
        String contractAddress = null;
        try {
            //// owner of project deploy peer contract.
            String pk = Commons.OWNER_PEERS;
            Credentials credentials = Credentials.create(pk);
            Web3j web3j = ConnectionUtil.getWeb3jConnection();
           contractAddress = PeerList.deploy(web3j, credentials, new DefaultGasProvider()).send().getContractAddress();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return contractAddress;
    }
    public static TransactionReceipt registerPeer(String pk,Peer newPeer) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.registerPeer(newPeer.getUrl(),BigInteger.valueOf(newPeer.getTotalSpace()),BigInteger.valueOf(newPeer.getMaxBandwidth()),BigInteger.valueOf(newPeer.getMaxUser()),BigInteger.valueOf(newPeer.getUptimePercentage()),newPeer.getAvailableTimeRange(),new Date().toString(), BigInteger.valueOf(1)).send();
        System.out.println("contract address: " + tx.getContractAddress());
        System.out.println("From: " + tx.getFrom());
        System.out.println("To: " + tx.getTo());
        System.out.println("Transaction Hash: " + tx.getTransactionHash());
        System.out.println("Block Hash: " + tx.getBlockHash());
        System.out.println("Gas Used: " + tx.getGasUsed());
        System.out.println("Status: " + tx.getStatus());
        return tx;
    }

    public static List<Peer> list(String pk) throws Exception {
        List<Peer> peers = new ArrayList<>();
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        BigInteger patent_count = peerList.peerCount().send();
        for(long i = 1;i<=patent_count.intValue();i++) {
            Tuple11<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, BigInteger> value = peerList.peers(BigInteger.valueOf(i)).send();
            Peer peer = new Peer(value);
            peers.add(peer);
        }
        return peers;
    }

    //// fix inside contract add get peer method called just by owner created peers.
    public static Peer getPeer(String publicKey, String privateKey) throws Exception {
        List<Peer> peers = list(privateKey);
        Log.infoLog("list of peers: " + peers.size());
        for(Peer peer : peers){
            if(peer.getOwner().equalsIgnoreCase(publicKey))
                return peer;
        }
        return null;
    }


    public static TransactionReceipt updatePublicUrl(String pk, int index, String newAddress) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.updatePublicUrl(BigInteger.valueOf(index),newAddress).send();
        System.out.println("tx hash: " + tx.getTransactionHash() + " status: " + tx.getStatus());
        return tx;
    }

    public static TransactionReceipt updateTotalSpace(String pk, int index, long totalSpace) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.updateTotalSpace(BigInteger.valueOf(index),BigInteger.valueOf(totalSpace)).send();
        System.out.println("tx hash: " + tx.getTransactionHash() + " status: " + tx.getStatus());
        return tx;
    }

    public static TransactionReceipt updateUsedSpace(String pk, int index, long usedSpace) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.updateUsedSpace(BigInteger.valueOf(index),BigInteger.valueOf(usedSpace)).send();
        System.out.println("tx hash: " + tx.getTransactionHash() + " status: " + tx.getStatus());
        return tx;
    }

    public static TransactionReceipt updateMaxUser(String pk, int index, int maxUserCount) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.updateMaxUser(BigInteger.valueOf(index),BigInteger.valueOf(maxUserCount)).send();
        System.out.println("tx hash: " + tx.getTransactionHash() + " status: " + tx.getStatus());
        return tx;
    }

    public static TransactionReceipt updateMaxBandwidth(String pk, int index, long bandwidth) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.updateMaxBandwidth(BigInteger.valueOf(index),BigInteger.valueOf(bandwidth)).send();
        System.out.println("tx hash: " + tx.getTransactionHash() + " status: " + tx.getStatus());
        return tx;
    }

    public static TransactionReceipt updateUptimePercentage(String pk, int index, int uptimePercentage) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.updateUpTimePercentage(BigInteger.valueOf(index),BigInteger.valueOf(uptimePercentage)).send();
        System.out.println("tx hash: " + tx.getTransactionHash() + " status: " + tx.getStatus());
        return tx;
    }

    public static TransactionReceipt updateAvailableTimeRange(String pk, int index, String timeRange) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.updateAvailableTimeRange(BigInteger.valueOf(index),timeRange).send();
        System.out.println("tx hash: " + tx.getTransactionHash() + " status: " + tx.getStatus());
        return tx;
    }


}
