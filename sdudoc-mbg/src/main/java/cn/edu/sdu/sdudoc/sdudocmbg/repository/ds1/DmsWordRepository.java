package cn.edu.sdu.sdudoc.sdudocmbg.repository.ds1;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.DmsWord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "ds1DmsWordRepository")
public interface DmsWordRepository extends MongoRepository<DmsWord,String> {

    List<DmsWord> findByWord(String word);

    List<DmsWord> findByArticle(String article);

    List<DmsWord> findByPage(String page);
}
