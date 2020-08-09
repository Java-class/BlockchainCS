package ir.javaclass.dao;

import ir.javaclass.entity.PeerSetting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PeerSettingDaoTest {

    @Autowired
    PeerSettingRepository repository;


    @Test
    void save() {
        PeerSetting peerSetting = new PeerSetting();
        peerSetting.setMountAddress("c:////");
        peerSetting.setPublicKey("0xd31c7e4f509d7d12f5cdf15eed28fdd3585156e4");
        repository.save(peerSetting);
    }

    @Test
    void delete() {
    }

    @Test
    void getSetting() {
        PeerSetting setting = repository.findById("0xd31c7e4f509d7d12f5cdf15eed28fdd3585156e4").get();
        System.out.println(setting.getMountAddress());
    }
}