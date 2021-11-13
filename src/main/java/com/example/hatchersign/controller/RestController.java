package com.example.hatchersign.controller;

import com.example.hatchersign.service.ditieService;
import com.example.hatchersign.service.mailService;
import io.itit.itf.okhttp.FastHttpClient;
import io.itit.itf.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;


@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private mailService mailService;
    @Autowired
    private ditieService detieSsevice;

    @GetMapping("/run")
    public String run(@RequestParam(value = "date",required = false) String date, @RequestParam(value = "time",required = false)String time) throws Exception {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        //创建日历对象
        Calendar calendar = new GregorianCalendar();
        //明天日期
        calendar.setTime(new Date());
        //得倒今天的日期
        calendar.add(calendar.DATE, +1);
        //格式化
        String tomorrow = ft.format(calendar.getTime());
        tomorrow = tomorrow.replaceAll("[[\\s-:punct:]]","");
        System.out.println("tomorrow"+tomorrow);
        if(time==null||"".equals(time)){
            time="0740-0750";
        }
       String result = detieSsevice.CreateAppointment(tomorrow,time);
        if(result.contains("沙河")){
            System.out.println("预约成功！正在发送邮件...");
            mailService.sendSimpleMail("865204206@qq.com",result);
            System.out.println("预约成功！邮件发送成功");
        }else{
            System.out.println("预约失败！正在发送邮件...");
            mailService.sendSimpleMail("865204206@qq.com",result);
            System.out.println("预约失败！邮件发送成功");
        }
      return  result;

    }
    @GetMapping("/setToken")
    public String setToken(@RequestParam(value = "token") String token) {
        detieSsevice.setToken(token);

        return  "token设置成功";

    }
//
//    public static void main(String[] args) throws Exception {
//        String url="https://webapi.mybti.cn/Appointment/CreateAppointment";
//        Map<String,String> map =new HashMap();
//        map.put("Content-Type","application/json;charset=utf-8");
//        map.put("Authorization"," ZTdkYzg1MDktZWY2Yy00NzNlLWE4YTgtZGFkZmM3MzY0NDQ4LDE2MzEyNjYyMzIxMDEseVQ3NCtrYkJxcU5DRGtOSW5oMFRTeEZjd3VNPQ==");
//        map.put("Origin","https://webui.mybti.cn");
//        map.put("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 14_6 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 MicroMessenger/8.0.12(0x18000c27) NetType/WIFI Language/zh_CN");
//
//
//        Response response= FastHttpClient.
//                post().addHeaders(map).
//                body("{\n" +
//                        "  \"lineName\": \"昌平线\",\n" +
//                        "  \"snapshotWeekOffset\": 0,\n" +
//                        "  \"stationName\": \"沙河站\",\n" +
//                        "  \"enterDate\": \"20210906\",\n" +
//                        "  \"snapshotTimeSlot\": \"0630-0930\",\n" +
//                        "  \"timeSlot\": \"0740-0750\"\n" +
//                        "}").
//                url(url).
//                build().
//                execute();
//
//        System.out.println(response.string());
//    }

    public String CreateAppointment(String date,String time) throws Exception {
        String url="https://webapi.mybti.cn/Appointment/CreateAppointment";
        Map<String,String> map =new HashMap();
        map.put("Content-Type","application/json;charset=utf-8");
        map.put("Authorization"," ZTdkYzg1MDktZWY2Yy00NzNlLWE4YTgtZGFkZmM3MzY0NDQ4LDE2MzEyNjYyMzIxMDEseVQ3NCtrYkJxcU5DRGtOSW5oMFRTeEZjd3VNPQ==");
        map.put("Origin","https://webui.mybti.cn");
        map.put("User-Agent","Mozilla/5.0 (iPhone; CPU iPhone OS 14_6 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 MicroMessenger/8.0.12(0x18000c27) NetType/WIFI Language/zh_CN");
        Response response= FastHttpClient.
                post().addHeaders(map).
                body("{\n" +
                        "  \"lineName\": \"昌平线\",\n" +
                        "  \"snapshotWeekOffset\": 0,\n" +
                        "  \"stationName\": \"沙河站\",\n" +
                        "  \"enterDate\": \""+date+"\",\n" +
                        "  \"snapshotTimeSlot\": \"0630-0930\",\n" +
                        "  \"timeSlot\": \"0740-0750\"\n" +
                        "}").
                url(url).
                build().
                execute();
        return response.string();
    }

}
