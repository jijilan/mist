package cn.jijl.mist.modules.controller;


import cn.jijl.mist.common.annotation.log.SysLog;
import cn.jijl.mist.common.result.ResultView;
import cn.jijl.mist.common.result.SysConstant;
import cn.jijl.mist.modules.controller.base.BaseController;
import cn.jijl.mist.modules.entity.SysManager;
import cn.jijl.mist.modules.service.ISysManagerService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jijl
 * @since 2019-10-28
 */
@Slf4j
@RestController
@RequestMapping("/sys-manager")
@Validated
public class SysManagerController extends BaseController {
    @Autowired
    private ISysManagerService iSysManagerService;

    /**
     * @Author jijl
     * @Description: 根据id获取用户信息
     * @Date 10:43 2020/4/10
     * @Param [id]
     * @return cn.jijl.mist.common.result.ResultView
     **/
    @SysLog(value = "根据id获取用户信息")
    @GetMapping("/getManagerById")
    public ResultView get(String id) {
        SysManager sysManager = iSysManagerService.getById(id);
        return ResultView.ok(sysManager);
    }

    /**
     * @Author jijl
     * @Description: 登录
     * @Date 9:39 2019/10/29
     * @Param [userAccount, userPassword]
     * @return cn.jijl.mist.common.result.ResultView
     **/
    @SysLog(value = "登录")
    @PostMapping(value = "/login")
    public ResultView login(@NotBlank(message = "用户名不能为空") String userAccount,
                            @NotBlank(message = "密码不能为空")
                            @Length(min = 6, max = 20, message = "密码须在长度6-20位之间") String userPassword) {
        ResultView resultView = iSysManagerService.login(userAccount, userPassword);
        if (resultView.getData() != null) {
            SysManager manager = (SysManager) resultView.getData();
            String token = jwtToken(SysConstant.MANAGER_ID, manager.getUserId(), manager, SysConstant.ADMIN_AUTH_TIMEOUT);
            return ResultView.ok(token);
        }
        return resultView;
    }
}
