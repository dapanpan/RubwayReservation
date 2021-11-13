package com.example.hatchersign.service;

import io.itit.itf.okhttp.FastHttpClient;
import io.itit.itf.okhttp.Response;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ditieService {
    public  static String  Authorization ="";

    public String CreateAppointment(String date,String time) throws Exception {
        String yuanyuan="YmZkZDgyNjQtMzA3OC00YWE4LTgzYWYtMWMyMWQzOWJmMTVlLDE2MzMyNTU0ODQ1NDcsTFdBdC9qSDQzNkpDdWZyTi8xK0FNZk13bkdJPQ==";
        String url="https://webapi.mybti.cn/Appointment/CreateAppointment";
        Map<String,String> map =new HashMap();
        map.put("Content-Type","application/json;charset=utf-8");
        map.put("Authorization",Authorization);
        map.put("Origin","https://webui.mybti.cn");
        map.put("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 14_6 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 MicroMessenger/8.0.12(0x18000c27) NetType/WIFI Language/zh_CN");
        String body="{\n" +
                "  \"lineName\": \"昌平线\",\n" +
                "  \"snapshotWeekOffset\": 0,\n" +
                "  \"stationName\": \"沙河站\",\n" +
                "  \"enterDate\": \""+date+"\",\n" +
                "  \"snapshotTimeSlot\": \"0630-0930\",\n" +
                "  \"timeSlot\": \""+time+"\"\n" +
                "}";
        System.out.println("提交的数据体为："+body);
        Response response= FastHttpClient.
                post().addHeaders(map).
                body(body).
                url(url).
                build().
                execute();
        return response.string();
    }


    public void setToken(String token)  {
        Authorization =token;
        System.out.println("设置的token为：  "+token);
    }

}
