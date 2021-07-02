package cn.edu.sdu.search.service.serviceImpl;

import cn.edu.sdu.entity.ds1.DmsCharacter;
import cn.edu.sdu.repository.ds1.DmsCharacterRepository;
import cn.edu.sdu.search.service.DmsCharacterService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Component
public class DmsCharacterServiceImpl implements DmsCharacterService {

    @Resource
    private DmsCharacterRepository dmsCharacterRepository;

    @Override
    public DmsCharacter save(DmsCharacter dmsCharacter) {
        return dmsCharacterRepository.save(dmsCharacter);
    }

    @Override
    public List<DmsCharacter> saveAll(List<DmsCharacter> dmsCharacters) {
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
    public Optional<DmsCharacter> findById(String id){ return dmsCharacterRepository.findById(id);}

    @Override
    public List<DmsCharacter> findAll() {
        return dmsCharacterRepository.findAll();
    }
}
