package cn.edu.sdu.sdudoc.sdudocmysql.service.serviceImpl;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsCharacter;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.DmsCharacterRepository;
import cn.edu.sdu.sdudoc.sdudocmysql.service.DmsCharacterService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DmsCharacterServiceImpl implements DmsCharacterService {

    @Resource
    private DmsCharacterRepository dmsCharacterRepository;

    @Override
    public void save(DmsCharacter dmsCharacter) {
        dmsCharacterRepository.save(dmsCharacter);
    }

    @Override
    public List<DmsCharacter> saveAll(List dmsCharacters) {
        return dmsCharacterRepository.saveAll(dmsCharacters);
    }

    @Override
    public void delete(String id) {
        dmsCharacterRepository.deleteById(id);
    }

    @Override
    public void update(DmsCharacter dmsCharacter) {
        dmsCharacterRepository.save(dmsCharacter);
    }

    @Override
    public List<DmsCharacter> findAll() {
        return dmsCharacterRepository.findAll();
    }
}
