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
            String pk = "a32c0dde69b21f25bf6f91076670730bb6014df03cec198fb9b3c44561a4c8ae";
            Credentials credentials = Credentials.create(pk);
            Web3j web3j = ConnectionUtil.getWeb3jConnection();
           contractAddress = PeerList.deploy(web3j, credentials, new DefaultGasProvider()).send().getContractAddress();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return contractAddress;
    }
    public static String registerPeer(String pk) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        BigInteger bigInteger = new BigInteger("200000000");
        TransactionReceipt tx = peerList.registerPeer("storage1.localhost",bigInteger,bigInteger,bigInteger,bigInteger,"7*24",new Date().toString(),new BigInteger("1")).send();
        System.out.println("contract address: " + tx.getContractAddress());
        System.out.println("From: " + tx.getFrom());
        System.out.println("To: " + tx.getTo());
        System.out.println("Transaction Hash: " + tx.getTransactionHash());
        System.out.println("Block Hash: " + tx.getBlockHash());
        System.out.println("Gas Used: " + tx.getGasUsed());
        System.out.println("Status: " + tx.getStatus());
        return tx.getTransactionHash();
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


    public static void update(String pk, int index) throws Exception {
        Credentials credentials = Credentials.create(pk);
        PeerList peerList = PeerList.load(Commons.PEER_CONTRACT_ADDRESS, ConnectionUtil.getWeb3jConnection(), credentials, new DefaultGasProvider());
        TransactionReceipt tx = peerList.updatePublicUrl(BigInteger.valueOf(index),"new addresss updated").send();
        System.out.println("tx hash: " + tx.getTransactionHash() + " status: " + tx.getStatus());
    }


}
