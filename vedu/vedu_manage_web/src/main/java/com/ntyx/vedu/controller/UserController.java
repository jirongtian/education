package com.ntyx.vedu.controller;
import com.github.pagehelper.PageInfo;
import com.ntyx.vedu.entity.User;
import com.ntyx.vedu.service.UserService;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    /**
     * 查询用户表数据
     */
    @RequestMapping(value = "/list" , name = "用户查询")
    public ResponseEntity<PageInfo> list(@RequestParam(defaultValue = "1") Integer page , @RequestParam(defaultValue = "5") Integer pageSize){
        //分页数据
        PageInfo pageInfo = userService.findAll(page, pageSize);
        return ResponseEntity.ok(pageInfo);
    }
     /**
      * 保存或修改
     */
    @RequestMapping(value = "/edit" ,name = "保存或修改" )
    public ResponseEntity<Void> edit(User user) throws Exception {

        //如果user的id为null说明新增
        if(user.getId()==null){
            userService.save(user);
        }else{
            userService.update(user);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

     /**
      * 删除用户
     */
    @RequestMapping(value = "/delete" ,name = "删除用户")
    public ResponseEntity<String> delete(@RequestParam(name = "id") Integer id ){
        userService.delete(id);
        String msg="success";
        return  ResponseEntity.ok(msg);
    }

     /**
      * 跳转用户修改页面
     */
    @GetMapping(value = "/toUpdate" ,name = "用户修改页面" )
    public ResponseEntity<User> FindUserById(@RequestParam(name = "id") Integer id){//根据id查询需要修改的数据
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

}
