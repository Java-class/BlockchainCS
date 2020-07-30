package service;

import entity.PeerSetting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettingServiceTest {

    @Test
    void savePeerSetting() {
        PeerSetting peerSetting = new PeerSetting();
        peerSetting.setMountAddress("c:////");
        peerSetting.setPublicKey("public key");
        SettingService.savePeerSetting(peerSetting);
    }
}