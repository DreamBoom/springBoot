package com.example.demo.controller;

import com.example.demo.model.UserBean;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/rest")
@RestController
public class HelloController {
    //查询
//    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    @GetMapping("/user")
    public AjaxResponse getUser(@RequestParam String id){
        Integer integer = Integer.valueOf(id);
        UserBean zs = UserBean
                .builder()
                .id(integer)
                .age(12)
                .name("zs")
                .build();
        return AjaxResponse.success(zs);
    }
    //新增
    //@RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public AjaxResponse saveUser(@RequestBody UserBean userBean){
        return AjaxResponse.success();
    }

    //修改
    //@RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public AjaxResponse upDataUser(@RequestBody UserBean userBean){
        if(userBean.getId()==null){
            return AjaxResponse.error();
        }
        return AjaxResponse.success();
    }

    //删除
    //@RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    @DeleteMapping("/user/{id}")
    public AjaxResponse deleteUser(@PathVariable("id") Integer id){
        if(id == 1){
            return AjaxResponse.error();
        }
        return AjaxResponse.success();
    }
}
