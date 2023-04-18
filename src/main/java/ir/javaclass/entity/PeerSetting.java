package ir.javaclass.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class PeerSetting implements Serializable {

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
        @Override
    public String toString() {
        return "PeerSetting{" +
                ", mountAddress='" + mountAddress + '\'' +
                '}';
    }
}
