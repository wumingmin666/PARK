package com.tjnu.park01.service.Impl;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CarportService implements com.tjnu.park01.service.CarportService {
    @Override
    public String getmessage_all() {

        return null;
    }
    /*
    获取token
    该方法在服务器启动时要自动执行且要定时每隔一个时间断执行
    该方法的返回值之后要放入全局作用域"X-Auth-Token"
     */
    @Override
    public String getToken() {
        String url="https://iam.cn-north-4.myhuaweicloud.com/v3/auth/tokens";
        String body ="{\"auth\":{\"identity\":{\"methods\":[\"password\"],\"password\":{\"user\":{\"name\":" +
                "\"wmm01\",\"password\":\"13850982142wmm.\",\"domain\":{\"name\":\"hw_008615059997639_01\" }}}}," +
                " \"scope\":{\"project\":{\"name\": \"cn-north-4\"}}}}";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/json");
        HttpEntity httpEntity=new HttpEntity(body,headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> res=restTemplate.postForEntity(url,body,String.class);
        String token=res.getHeaders().get("X-Subject-Token").get(0);
        return token;
    }
}
