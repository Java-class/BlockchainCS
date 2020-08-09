package ir.javaclass.service;

import ir.javaclass.dao.PeerSettingRepository;
import ir.javaclass.entity.PeerSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingService {
    final PeerSettingRepository repository;
    @Autowired
    public SettingService(PeerSettingRepository repository) {
        this.repository = repository;
    }

    public PeerSetting savePeerSetting(PeerSetting setting){
       return repository.save(setting);
    }

}
