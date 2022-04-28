package com.sunhp.activiti.controller;

import com.sujian.blindbox.entity.User;
import com.sujian.blindbox.enums.ResponseCodeEnum;
import com.sujian.blindbox.service.UserService;
import com.sujian.blindbox.vo.request.UserReqVO;
import com.sujian.blindbox.vo.response.ResultVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *
 * @author sujian
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ResultVO<User> selectOne(Integer id) {
        int i = 8/0;
        return userService.queryById(id);
    }

    /**
     * 新增用户
     * @param userReqVO
     * @return
     */
    @PostMapping("insertUser")
    public ResultVO insertUser(@RequestBody @Validated UserReqVO userReqVO){
        return ResultVO.getSuccess(ResponseCodeEnum.SUCCESS);
    }
}