package com.example.demo.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.util.Date;

/**
 * article
 * @author 
 */
@Data
public class Article{
    @TableId(value="id",type = IdType.AUTO)
    private Integer id;
    private String author;
    private String content;
    private Date creattime;
    private String title;
}