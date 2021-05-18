package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JSONResponse { //统一返回前端的数据
    //业务操作是否成功
    private  boolean success; //前端解析响应用
    //业务数据
    private Object data;
    //错误码
    private String  code;
    //错误消息
    private String message;

}
