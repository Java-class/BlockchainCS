package ir.javaclass.service;

import ir.javaclass.config.Commons;
import ir.javaclass.config.FileDelimiter;
import ir.javaclass.entity.Peer;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigInteger;
import java.util.List;


class PeerServiceTest {

    @Test
    public void deployPeerContract() {
        String contract_address = PeerService.deployPeerContract();
        //String contract_address = "0x5437f75f2a23a4e724d93d139635245232c322cc";
        System.out.println("contract_address: " + contract_address);
    }

    @Test
    public void registerPeer() {
        Peer peer = new Peer("https://localhost:8080",1024_000,1024,100,98,"7*18");
        try {
            PeerService.registerPeer(Commons.USER_PEER_PVK, peer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void list() {
        try {
            List<Peer> list = PeerService.list(Commons.USER_PEER_PVK);
            System.out.println("Size of List: " + list.size());
            for(Peer peer : list)
                System.out.println(peer.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void getPeer() throws Exception {
        Peer peer = PeerService.getPeer(Commons.USER_PEER_PVK);
        assert peer != null;
        System.out.println("#### " + peer.toString());
    }

    @Test
    public void getPublicAddress() throws Exception {
        List<String> list = PeerService.getPublicAddress(Commons.USER_PEER_PVK);
        for(String key :list)
            System.out.println(key);

    }

    @Test
    public void getPeerCount() throws Exception {
        BigInteger count = PeerService.getPeerCount(Commons.USER_PEER_PVK);
        System.out.println("#### " + count.longValue());
    }


    @Test
    public void updateAddress() {
        String pk1 = "7f9c01ffb80df6f6b245705ef81fe484ecebcb6a49b4d22133de990d84e1a955";
        String pk2 = "97c2bbf6dd98ff076962f6fcdbfa4259ecf3f7367dfee3e54b7916de4a371469";
        try {
            PeerService.updatePublicUrl(pk1,"updated Host Address");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void updateTotalSpace() {
        try {
            PeerService.updateTotalSpace(Commons.USER_PEER_PVK,2048_000_000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void updateUsedSpace() {
        try {
            PeerService.updateUsedSpace(Commons.USER_PEER_PVK,1024222220);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void test(){
        File file = new File(FileDelimiter.getSystemDelimiter() +
                "home" + FileDelimiter.getSystemDelimiter() +
                "mostafa" + FileDelimiter.getSystemDelimiter() +
                "00-Developing" + FileDelimiter.getSystemDelimiter() +
                "blockchain-cs" + FileDelimiter.getSystemDelimiter() +
                "peer_data" + FileDelimiter.getSystemDelimiter() +
                "user_data");
        System.out.println(file.exists());
    }

    @Test
    public void updatePeerInfo(){
        PeerService.updatePeerInfo();
    }
}