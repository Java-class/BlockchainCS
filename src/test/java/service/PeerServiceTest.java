package  service;
import entity.Peer;
import org.junit.jupiter.api.Test;

import java.util.List;


class PeerServiceTest {

    @Test
    public void deployPeerContract() {
        String contract_address = "0xaad36c131ad122aa6bf9e22c0911477700c7eb68";
        System.out.println("contract_address: " + contract_address);
    }

    @Test
    public void registerPeer() {

        String pk1 = "7f9c01ffb80df6f6b245705ef81fe484ecebcb6a49b4d22133de990d84e1a955";
        String pk2 = "97c2bbf6dd98ff076962f6fcdbfa4259ecf3f7367dfee3e54b7916de4a371469";
        try {
            PeerService.registerPeer(pk1);
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
        try {
            PeerService.update(pk1,1);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}