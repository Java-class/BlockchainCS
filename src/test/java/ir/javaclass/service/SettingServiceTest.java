package ir.javaclass.service;

import ir.javaclass.entity.PeerSetting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SettingServiceTest {

    @Autowired
    SettingService service;

    @Test
    void savePeerSetting() {
        PeerSetting peerSetting = new PeerSetting();
        peerSetting.setMountAddress("c:////");
        peerSetting.setPublicKey("0xD31C7E4F509D7d12F5CdF15eEd28FDD3585156e4");
        service.savePeerSetting(peerSetting);
    }
}