package cn.edu.sdu.search.service.serviceImpl;

import cn.edu.sdu.entity.ds1.DmsWord;
import cn.edu.sdu.repository.ds1.DmsWordRepository;
import cn.edu.sdu.search.service.DmsWordService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DmsWordServiceImpl implements DmsWordService {
    @Resource
    private DmsWordRepository dmsWordRepository;

    @Override
    public DmsWord save(DmsWord dmsWord) {
        return dmsWordRepository.save(dmsWord);
    }

    @Override
    public List<DmsWord> saveAll(List<DmsWord> dmsWords) {
        return dmsWordRepository.saveAll(dmsWords);
    }

    @Override
    public void delete(String id) {
        dmsWordRepository.deleteById(id);
    }

    @Override
    public void update(DmsWord dmsWord) {
        dmsWordRepository.save(dmsWord);
    }

    @Override
    public List<DmsWord> findAll() {
        return dmsWordRepository.findAll();
    }
}
