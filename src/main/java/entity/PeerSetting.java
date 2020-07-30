package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PeerSetting {
   // private Peer ownerPeer;

    @Id
    private String publicKey;

    private String mountAddress;

    public  PeerSetting(){ }

    public PeerSetting(String publicKey, String mountAddress) {
        this.publicKey = publicKey;
        this.mountAddress = mountAddress;
    }

    public String getMountAddress() {
        return mountAddress;
    }

    public void setMountAddress(String mountAddress) {
        this.mountAddress = mountAddress;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
    //    @Override
//    public String toString() {
//        return "PeerSetting{" +
//                "ownerPeer=" + ownerPeer +
//                ", mountAddress='" + mountAddress + '\'' +
//                '}';
//    }
}
