package org.example.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JSONUtil {
    private  static  ObjectMapper m=new ObjectMapper();
    //将Java对象序列化成JSON字符串,序列化
    public  static  String  serialize(Object o) throws JsonProcessingException {
        return m.writeValueAsString(o);
    }
    //反序列化,将输入流中的JSON字符串反序列化为Java对象
    public  static <T> T  deserialize(InputStream is,Class<T> c) throws IOException {
       return m.readValue(is,c);
    }
}
