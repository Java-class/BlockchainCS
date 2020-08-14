package ir.javaclass.model;

import ir.javaclass.entity.Peer;
import ir.javaclass.entity.PeerSetting;

public class PeerInfoModel {
    private Peer peer;
    private PeerSetting setting;
    private String privateKey;

    public PeerInfoModel(Peer peer, PeerSetting setting) {
        this.peer = peer;
        this.setting = setting;
    }

    public Peer getPeer() {
        return peer;
    }

    public void setPeer(Peer peer) {
        this.peer = peer;
    }

    public PeerSetting getSetting() {
        return setting;
    }

    public void setSetting(PeerSetting setting) {
        this.setting = setting;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}
