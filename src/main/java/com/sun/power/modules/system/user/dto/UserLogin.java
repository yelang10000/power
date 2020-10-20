package com.sun.power.modules.system.user.dto;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author 贾涛
 * @Date 2020/10/15 15:16
 * @Version 1.0
 */
@Data
public class UserLogin extends SerializableSerializer {
    @ApiModelProperty(value="id")
    private String id;



    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value="登录日期")
    private Date dateOfLogin;

}
