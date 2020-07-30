package service;

import dao.PeerSettingDao;
import entity.PeerSetting;

public class SettingService {

    public static PeerSetting savePeerSetting(PeerSetting setting){
        PeerSettingDao.save(setting);
        return setting;
    }

}
