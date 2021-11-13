package com.example.hatchersign.auartz;

import com.example.hatchersign.service.ditieService;
import com.example.hatchersign.service.mailService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
@Service
public class ThreadClass implements Runnable{
@Autowired
private ditieService ditieService;
@Autowired
private mailService mailService;

    @SneakyThrows
    @Override
    public void run() {
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            //创建日历对象
            Calendar calendar = new GregorianCalendar();
            //明天日期
            calendar.setTime(new Date());
            //得倒今天的日期
            calendar.add(calendar.DATE, +1);
            //格式化
            String tomorrow = ft.format(calendar.getTime());
            tomorrow = tomorrow.replaceAll("[[\\s-:punct:]]", "");
            System.out.println("tomorrow" + tomorrow);
            for (int i = 0; i < 10000; i++) {
                //延迟10ms
            Thread.sleep(500);
                String time="0730-0740";

                String result = ditieService.CreateAppointment(tomorrow, time);
                System.out.println("已预约提交" + i + "次:" + result);
                if (result.contains("A2口")||result.contains("-1024")) {
                    System.out.println("[预约成功!]：" + result);
                    System.out.println("预约成功！正在发送邮件...");
                    mailService.sendSimpleMail("865204206@qq.com", result);
                    System.out.println("预约成功！邮件发送成功");
                    break;
                }
                if(result.contains("-1025")){
                    System.out.println("当前为周末或者维护时间不允许预约！任务结束!!");
                    break;
                }
                if(result.contains("401")){
                    System.out.println("token已经过期！请更新token!!");
                    mailService.sendSimpleMail("865204206@qq.com","[预约失败!] token已经过期，请重新抓包替换token");
                    break;
                }
            }
            System.out.println("任务结束:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}