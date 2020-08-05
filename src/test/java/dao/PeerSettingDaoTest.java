package dao;

import entity.PeerSetting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeerSettingDaoTest {

    @Test
    void save() {
        PeerSetting peerSetting = new PeerSetting();
        peerSetting.setMountAddress("c:////");
        peerSetting.setPublicKey("0xd31c7e4f509d7d12f5cdf15eed28fdd3585156e4");
        PeerSettingDao.save(peerSetting);
    }

    @Test
    void delete() {
    }

    @Test
    void getSetting() {
        PeerSetting setting = PeerSettingDao.getSetting("0xD31C7E4F509D7d12F5CdF15eEd28FDD3585156e4");
        System.out.println(setting.getMountAddress());
    }
}