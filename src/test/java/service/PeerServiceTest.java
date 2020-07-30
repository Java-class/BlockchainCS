package  service;
import entity.Peer;
import org.junit.jupiter.api.Test;

import java.util.List;


class PeerServiceTest {

    @Test
    public void deployPeerContract() {
        //String contract_address = PeerService.deployPeerContract();
        String contract_address = "0x8f7c2ac49d5bde884399c506f7bdab1327a860fe";
        System.out.println("contract_address: " + contract_address);
    }

    @Test
    public void registerPeer() {

        String pk1 = "7f9c01ffb80df6f6b245705ef81fe484ecebcb6a49b4d22133de990d84e1a955";
        String pk2 = "97c2bbf6dd98ff076962f6fcdbfa4259ecf3f7367dfee3e54b7916de4a371469";
        Peer peer1 = new Peer("https://localhost:8083",1024_000,1024,100,98,"7*18");
        try {
            PeerService.registerPeer(pk1,peer1);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void list() {
        String pk1 = "7f9c01ffb80df6f6b245705ef81fe484ecebcb6a49b4d22133de990d84e1a955";
        try {
            List<Peer> list = PeerService.list(pk1);
            for(Peer peer : list)
                System.out.println(peer.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void updateAddress() {
        String pk1 = "7f9c01ffb80df6f6b245705ef81fe484ecebcb6a49b4d22133de990d84e1a955";
        String pk2 = "97c2bbf6dd98ff076962f6fcdbfa4259ecf3f7367dfee3e54b7916de4a371469";
        try {
            PeerService.updatePublicUrl(pk1,1,"updated Host Address");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void updateTotalSpace() {
        String pk1 = "7f9c01ffb80df6f6b245705ef81fe484ecebcb6a49b4d22133de990d84e1a955";
        String pk2 = "97c2bbf6dd98ff076962f6fcdbfa4259ecf3f7367dfee3e54b7916de4a371469";
        try {
            PeerService.updateTotalSpace(pk1,1,2048_000_000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void updateUsedSpace() {
        String pk1 = "7f9c01ffb80df6f6b245705ef81fe484ecebcb6a49b4d22133de990d84e1a955";
        String pk2 = "97c2bbf6dd98ff076962f6fcdbfa4259ecf3f7367dfee3e54b7916de4a371469";
        try {
            PeerService.updateUsedSpace(pk1,1,102400);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}