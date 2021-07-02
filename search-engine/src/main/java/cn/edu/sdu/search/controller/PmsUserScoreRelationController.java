package cn.edu.sdu.search.controller;

import cn.edu.sdu.entity.ds1.PmsUserScoreRelation;
import cn.edu.sdu.repository.ds1.PmsUserScoreRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/score")
public class PmsUserScoreRelationController {

    @Autowired
    private PmsUserScoreRelationRepository pmsUserScoreRelationService;

    @PostMapping("/find")
    public Object find(Integer uid){
        Optional<PmsUserScoreRelation> pusrs = pmsUserScoreRelationService.findById(uid);
        return pusrs.orElse(null);

    }

    @PostMapping("/delete")
    public void delete(Integer uid){
        pmsUserScoreRelationService.deleteById(uid);
    }

    @PostMapping("/update")
    public String update(Integer uid, BigInteger score){
        Optional<PmsUserScoreRelation> pusrs = pmsUserScoreRelationService.findById(uid);
        if (pusrs.isPresent()) {
            PmsUserScoreRelation pusr = pusrs.get();
            pusr.setScore(score);
            pmsUserScoreRelationService.save(pusr);
            return "更新成功";
        }else{
            return "更新失败";
        }
    }

    @PostMapping("/save")
    public void save(Integer uid, BigInteger score){
        PmsUserScoreRelation pusr = new PmsUserScoreRelation(uid, score);
        System.out.println(pmsUserScoreRelationService.save(pusr));
    }
}
