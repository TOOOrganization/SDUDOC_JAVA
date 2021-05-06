package cn.edu.sdu.sdudoc.sdudocmysql.service.serviceImpl;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.DmsWord;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.DmsWordRepository;
import cn.edu.sdu.sdudoc.sdudocmysql.service.DmsWordService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DmsWordServiceImpl implements DmsWordService {
    @Resource
    private DmsWordRepository dmsWordRepository;

    @Override
    public void save(DmsWord dmsWord) {
        dmsWordRepository.save(dmsWord);
    }

    @Override
    public List<DmsWord> saveAll(List dmsWords) {
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
