package service;

import entity.PeerSetting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettingServiceTest {

    @Test
    void savePeerSetting() {
        PeerSetting peerSetting = new PeerSetting();
        peerSetting.setMountAddress("c:////");
        peerSetting.setPublicKey("0xD31C7E4F509D7d12F5CdF15eEd28FDD3585156e4");
        SettingService.savePeerSetting(peerSetting);
    }
}