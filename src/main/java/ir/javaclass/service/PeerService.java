package ir.javaclass.service;

import ir.javaclass.config.Commons;
import ir.javaclass.contract.PeerList;
import ir.javaclass.entity.Peer;
import ir.javaclass.util.ConnectionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple11;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
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
        List<String> list = peerList.getPublicAddress().send();
        for(String add : list) {
            Tuple11<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, BigInteger> value = peerList.peers(add).send();
            Peer peer = new Peer(value);
            peers.add(peer);
        }
        return peers;
    }

    public static Peer getPeer(String privateKey) throws Exception {
        Credentials credentials = Credentials.create(privateKey);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        Tuple11<BigInteger, String, String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, String, String, BigInteger> value = peerList.peers(Commons.USER_PEER_PBK).send();
        if(value!=null)
            return new Peer(value);
        else
            return null;
    }

    public static List<String> getPublicAddress(String privateKey) throws Exception {
        Credentials credentials = Credentials.create(privateKey);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        return peerList.getPublicAddress().send();
    }

    public static BigInteger getPeerCount(String pk) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        return peerList.getPeerCount().send();
    }


    public static TransactionReceipt updatePublicUrl(String pk, String newAddress) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.updatePublicUrl(newAddress).send();
        log.info("updatePublicUrl, tx hash: " + tx.getTransactionHash() + " status: " + tx.getStatus());
        return tx;
    }

    public static TransactionReceipt updateTotalSpace(String pk, long totalSpace) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.updateTotalSpace(BigInteger.valueOf(totalSpace)).send();
        log.info("updateTotalSpace, tx hash: " + tx.getTransactionHash() + " status: " + tx.getStatus());
        return tx;
    }

    public static TransactionReceipt updateUsedSpace(String pk, long usedSpace) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.updateUsedSpace(BigInteger.valueOf(usedSpace)).send();
        log.info("updateUsedSpace, tx hash: " + tx.getTransactionHash() + " status: " + tx.getStatus());
        return tx;
    }

    public static TransactionReceipt updateMaxUser(String pk, int maxUserCount) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.updateMaxUser(BigInteger.valueOf(maxUserCount)).send();
        log.info("updateMaxUser, tx hash: " + tx.getTransactionHash() + " status: " + tx.getStatus());
        return tx;
    }

    public static TransactionReceipt updateMaxBandwidth(String pk, long bandwidth) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.updateMaxBandwidth(BigInteger.valueOf(bandwidth)).send();
        log.info("updateMaxBandwidth, tx hash: " + tx.getTransactionHash() + " status: " + tx.getStatus());
        return tx;
    }

    public static TransactionReceipt updateUptimePercentage(String pk, int uptimePercentage) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.updateUpTimePercentage(BigInteger.valueOf(uptimePercentage)).send();
        log.info("updateUptimePercentage, tx hash: " + tx.getTransactionHash() + " status: " + tx.getStatus());
        return tx;
    }

    public static TransactionReceipt updateAvailableTimeRange(String pk, String timeRange) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.updateAvailableTimeRange(timeRange).send();
        log.info("updateAvailableTimeRange, tx hash: " + tx.getTransactionHash() + " status: " + tx.getStatus());
        return tx;
    }


    @Scheduled(fixedDelay = 5 * 60 * 1000)
    public void updatePeerInfoJob() {
        log.info("Update Peer Info Job Started...");
        updatePeerInfo();
        log.info("Update Peer Info Job Finished...");
    }

    public static void updatePeerInfo() {
        try {
            File userData = new File(Commons.MOUNT_POINT_ADDRESS);
            long freeSpace;
            long totalSpace;
            long usedSpace;
            if (userData.exists()) {
                freeSpace = userData.getFreeSpace();
                totalSpace = userData.getTotalSpace();
                usedSpace = totalSpace - freeSpace;
                Peer peer = getPeer(Commons.USER_PEER_PVK);
                if (peer == null) {
                    peer = new Peer();
                    peer.setTotalSpace(totalSpace);
                    peer.setUsedSpace(usedSpace);
                    peer.setMaxBandwidth(Commons.maxBandwidth);
                    peer.setMaxUser(Commons.maxUser);
                    peer.setAvailableTimeRange(Commons.availableTimeRange);
                    peer.setUptimePercentage(Commons.uptimePercentage);
                    peer.setUrl(Commons.publicUrl);
                } else {
                    updateUsedSpace(Commons.USER_PEER_PVK, usedSpace);
                    updateTotalSpace(Commons.USER_PEER_PVK, totalSpace);
                    updateMaxBandwidth(Commons.USER_PEER_PVK, Commons.maxBandwidth);
                    updateMaxUser(Commons.USER_PEER_PVK, Commons.maxUser);
                    updateAvailableTimeRange(Commons.USER_PEER_PVK, Commons.availableTimeRange);
                    updateUptimePercentage(Commons.USER_PEER_PVK, Commons.uptimePercentage);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
