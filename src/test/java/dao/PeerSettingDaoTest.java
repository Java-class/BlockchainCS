package dao;

import entity.PeerSetting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeerSettingDaoTest {

    @Test
    void save() {
        PeerSetting peerSetting = new PeerSetting();
        peerSetting.setMountAddress("c:////");
        peerSetting.setPublicKey("public key");
        PeerSettingDao.save(peerSetting);
    }

    @Test
    void delete() {
    }

    @Test
    void getSetting() {
        PeerSetting setting = PeerSettingDao.getSetting("public key");
        System.out.println(setting.getMountAddress());
    }
}