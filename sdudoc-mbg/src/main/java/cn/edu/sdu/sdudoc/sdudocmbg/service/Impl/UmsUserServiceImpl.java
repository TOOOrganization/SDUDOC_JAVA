//package cn.edu.sdu.sdudoc.sdudocmbg.service.Impl;
//
//import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUser;
//import cn.edu.sdu.sdudoc.sdudocmbg.entity.UmsUserExample;
//import cn.edu.sdu.sdudoc.sdudocmbg.repository.UmsUserRepository;
//import cn.edu.sdu.sdudoc.sdudocmbg.service.UmsUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class UmsUserServiceImpl implements UmsUserService {
//    @Autowired
//    private UmsUserRepository umsUserRepository;
//
//    @Override
//    public long countByExample() {
//        return umsUserRepository.count();
//    }
//
//    @Override
//    public void deleteByExample(UmsUser example) {
//        umsUserRepository.delete(example);
//    }
//
//    @Override
//    public void deleteById(String uid) {
//        umsUserRepository.deleteById(uid);
//    }
//
//    @Override
//    public UmsUser save(UmsUser record) {
//        return umsUserRepository.save(record);
//    }
//
//    @Override
//    public void saveAll(List<UmsUser> records) {
//        umsUserRepository.saveAll(records);
//    }
//
//    @Override
//    public void flush(){
//        umsUserRepository.flush();
//    }
//
////    @Override
////    public List<UmsUser> selectByExample(UmsUserExample example) {
////        return umsUserRepository.selectByExample(example);
////    }
//
////    @Override
////    public List<UmsUser> findByUid(String uid) {
////        return umsUserRepository.findByUid(uid);
////    }
////
////    @Override
////    public int updateByExampleSelective(UmsUser record, UmsUserExample example) {
////        return umsUserRepository.updateByExampleSelective(record, example);
////    }
////
////    @Override
////    public int updateByExample(UmsUser record, UmsUserExample example) {
////        return umsUserRepository.updateByExample(record, example);
////    }
////
////    @Override
////    public int updateByPrimaryKeySelective(UmsUser record) {
////        return umsUserRepository.updateByPrimaryKeySelective(record);
////    }
////
////    @Override
////    public int updateByPrimaryKey(UmsUser record) {
////        return umsUserRepository.updateByPrimaryKey(record);
////    }
//}
