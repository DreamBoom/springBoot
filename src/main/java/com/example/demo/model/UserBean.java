package com.example.demo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

@Data
@Slf4j
@Builder
@AllArgsConstructor
@NoArgsConstructor
//格式校验
@Validated
@ApiModel(value = "用户信息")
public class UserBean {
    @ApiModelProperty(value = "用户id")
    private Integer id;
    @ApiModelProperty(value = "用户姓名")
    private String name;
    @ApiModelProperty(value = "用户年龄")
    //格式校验
    @Min(18)
    private Integer age;
}
