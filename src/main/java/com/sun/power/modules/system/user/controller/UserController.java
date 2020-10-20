package com.sun.power.modules.system.user.controller;

import com.sun.power.core.common.entity.BaseDeleteRequestBodyVO;
import com.sun.power.core.common.entity.BaseRequestVo;
import com.sun.power.core.common.entity.PageBean;
import com.sun.power.core.utils.UUIDGenerator;
import com.sun.power.modules.system.role.service.RoleService;
import com.sun.power.modules.system.user.dto.AddUserVo;
import com.sun.power.modules.system.user.dto.QueryUserVo;
import com.sun.power.modules.system.user.dto.UpdatePasswordVo;
import com.sun.power.modules.system.user.dto.UpdateUserVo;
import com.sun.power.modules.system.user.entity.User;
import com.sun.power.modules.system.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 贾涛
 * @Date 2020/10/19 16:35
 * @Version 1.0
 */
@Api(value="/User",tags="系统管理:工作人员管理/密码管理")
@Slf4j
@RestController()
@RequestMapping("/powers/api/{version}/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * 查询列表
     * @param requestVo
     * @return
     */
    @ApiOperation(value = "查询列表",notes = "作者：贾涛，最后更新时间：2019/04/17",httpMethod = "GET")
    @GetMapping("")
    public PageBean<User> findUserAll(QueryUserVo requestVo){
        return userService.findItems(requestVo);

    }

    /**
     * 逻辑批量删除工作人员
     * @param baseDeleteRequestBodyVO
     * @param baseRequestVo
     */
    @ApiOperation(value = "删除工作人员", notes = "作者：贾涛，最后更新时间：2019/04/17", httpMethod = "DELETE")
    @DeleteMapping("")
    public void deleteByIds (@RequestBody BaseDeleteRequestBodyVO baseDeleteRequestBodyVO, BaseRequestVo baseRequestVo){
        userService.deleteByIds(baseDeleteRequestBodyVO,baseRequestVo);
    }
    /**
     * 根据id查询工作人员信息
     * @param id
     * @param baseRequestVo
     * @return
     */
    @ApiOperation(value = "根据id查询工作人员信息", notes = "作者：贾涛，最后更新时间：2019/04/17",httpMethod = "GET")
    @GetMapping("/{id}")
    public User findUserById(@PathVariable(value = "id", required = true) String id, BaseRequestVo baseRequestVo){
        return  userService.findItemById(id,baseRequestVo);
    }
    /**
     * 新增工作人员
     *登陆名和电话号码的唯一性校验
     * @param requestVo
     * @param baseRequestVo
     */
    @ApiOperation(value = "新增工作人员", notes = "作者：贾涛，最后更新时间：2019/04/18",httpMethod = "POST")
    @PostMapping("")
    public void addUser(@RequestBody AddUserVo requestVo, BaseRequestVo baseRequestVo){
        if(userService.phonenumberOnlyCheckout(requestVo.getPhoneNumber())){
            if(userService.idCardOnlyCheckout(requestVo.getIdCard())) {

                requestVo.setId(UUIDGenerator.generate());
                requestVo.setCreateUserId(baseRequestVo.getRequestUserId());
                requestVo.setCreateOrgId(requestVo.getOrganizationId());
                userService.insertItem(requestVo, baseRequestVo);
                roleService.insertRoleUser(requestVo);
            }
        }
    }

    /**
     * 修改工作人员
     * @param requestVo
     * @param baseRequestVo
     */
    @ApiOperation(value = "修改工作人员", notes = "作者：贾涛，最后更新时间：2019/04/18",httpMethod = "PUT")
    @PutMapping("/{id}")
    public void updateUser(@PathVariable(value = "id",required = true)String id, @RequestBody UpdateUserVo requestVo, BaseRequestVo baseRequestVo){
        requestVo.setUpdateUserId(baseRequestVo.getRequestUserId());
        userService.putItemById(id,requestVo,baseRequestVo);
    }
    /**
     * 重置密码
     * @param id
     * @param baseRequestVo
     */
    @ApiOperation( value = "重置密码", notes = "作者：贾涛，最后更新时间：2019/04/18",httpMethod = "PUT")
    @PutMapping("/reset_password/{id}")
    public void resetpassword(@PathVariable(value = "id",required = true) String id, BaseRequestVo baseRequestVo){
        if(id != null){
            userService.resetPassword(id);
        }
    }

    /**
     * 根据id修改密码
     * @param baseRequestVo
     * @return
     */
    @ApiOperation(value = "密码修改", notes = "作者：贾涛，最后更新时间：2019/05/20",httpMethod = "PUT")
    @PutMapping ("/change_password")
    public void checkoutPassword(@RequestBody UpdatePasswordVo updatePasswordVo, BaseRequestVo baseRequestVo){
        userService.updatePassword(updatePasswordVo,baseRequestVo);
    }

}
