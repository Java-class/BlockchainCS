package service;


import config.Commons;
import contract.PeerList;
import entity.Peer;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple11;
import org.web3j.tx.gas.DefaultGasProvider;
import util.ConnectionUtil;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeerService {
    public static String deployPeerContract(){
        String contractAddress = null;
        try {
            //// owner of project deploy peer contract.
            String pk = "f3f3850e57c9f8e73125b0dc394d4fc8be14b5ce94ae9abec8cb8d101a484e52";
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
        PeerList peerList = contract.PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        BigInteger patent_count = peerList.peerCount().send();
        for(long i = 1;i<=patent_count.intValue();i++) {
            Tuple11<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, BigInteger> value = peerList.peers(BigInteger.valueOf(i)).send();
            Peer peer = new Peer(value);
            peers.add(peer);
        }
        return peers;
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


}
