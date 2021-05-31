package cn.edu.sdu.service.serviceImpl;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsCharacter;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.ds1.DmsCharacterRepository;
import cn.edu.sdu.service.DmsCharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DmsCharacterServiceImpl implements DmsCharacterService {

    @Autowired
    DmsCharacterRepository dmsCharacterRepository;

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
    public Optional<DmsCharacter> findById(String id) {
        return dmsCharacterRepository.findById(id);
    }

    @Override
    public List<DmsCharacter> findAll() {
        return dmsCharacterRepository.findAll();
    }

    @Override
    public Set<String> findAllArticle() {
        Set<String> articleSet = new HashSet<>();
        List<DmsCharacter> dmsCharacterList = dmsCharacterRepository.findAll();
        for (DmsCharacter dmsCharacter : dmsCharacterList)
            articleSet.add(dmsCharacter.getArticle());
        return articleSet;
    }

    @Override
    public List<DmsCharacter> find(String field, String keyword) {
        List<DmsCharacter> result = new ArrayList<>();
        switch (field){
            case "_id":
                result.add(dmsCharacterRepository.findById(keyword).get());
                break;
            case "character":
                result = dmsCharacterRepository.findByCharacter(keyword);
                break;
            case "article":
                result = dmsCharacterRepository.findByArticle(keyword);
                break;
            case "page":
                result = dmsCharacterRepository.findByPage(keyword);
                break;
        }
        return result;
    }
}
