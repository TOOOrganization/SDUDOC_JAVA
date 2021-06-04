package cn.edu.sdu.controller;

import cn.edu.sdu.api.CommonResult;
import cn.edu.sdu.api.ResultCode;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.UmsRight;
import cn.edu.sdu.sdudoc.sdudocmbg.entity.ds1.UmsRole;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.ds1.UmsRightRepository;
import cn.edu.sdu.sdudoc.sdudocmbg.repository.ds1.UmsRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ds1_right")
public class Ds1UmsRightController {

    @Autowired
    UmsRightRepository repository;

    @RequestMapping(value = "/find_all", method = RequestMethod.GET)
    public CommonResult<List<UmsRight>> findAll() {
        List<UmsRight> all = repository.findAll();

        return CommonResult.success(all);
    }

    @RequestMapping(value = "/find_by_id", method = RequestMethod.GET)
    public CommonResult<UmsRight> findById(Integer id) {
        Optional<UmsRight> one = repository.findById(id);

        return one.map(CommonResult::success).orElseGet(() -> CommonResult.failed(
                ResultCode.ROLE_NOT_EXIST,
                ResultCode.ROLE_NOT_EXIST.getMessage()
        ));
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public CommonResult<UmsRight> save(@RequestBody UmsRight right) {
        try {
            UmsRight save = repository.save(right);

            return CommonResult.success(save);
        } catch (Exception e) {
            e.printStackTrace();

            return CommonResult.failed(
                    ResultCode.ROLE_SAVE_FAILURE,
                    ResultCode.USER_AVATAR_UPLOAD_FAILURE.getMessage()
            );
        }
    }

    @RequestMapping(value = "delete_by_id", method = RequestMethod.POST)
    public CommonResult<Integer> deleteById(Integer id) {
        repository.deleteById(id);

        return CommonResult.success(id);
    }
}
