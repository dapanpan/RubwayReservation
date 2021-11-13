package com.example.hatchersign.auartz;

import com.example.hatchersign.service.ditieService;
import com.example.hatchersign.service.mailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class DitieQuartz {
    @Autowired
    private ditieService ditieService;
    @Autowired
    private mailService mailService;
    @Autowired
    private ThreadClass threadClass;
    //中午12点 time="0740-0750" 跑
    @Scheduled(cron = "57 57 11 * * ?")
    public void Scheduled12_1() throws Exception {
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
        for (int i = 0; i < 1000; i++) {
            //延迟10ms
//            Thread.sleep(10);
           String time="0740-0750";

            String result = ditieService.CreateAppointment(tomorrow, time);
            System.out.println("已预约提交"+i+"次:"+result);
            if (result.contains("A2口")||result.contains("-1024")) {
                System.out.println("[预约成功!]：" + result);
                System.out.println("预约成功！正在发送邮件...");
                mailService.sendSimpleMail("865204206@qq.com",result);
                System.out.println("预约成功！邮件发送成功");
                break;
            }
            if(result.contains("-1025")){
                System.out.println("当前为周末或者维护时间不允许预约！任务结束!!");
                break;
            }
        }
        System.out.println("任务结束:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
    //中午12点  time="0730-0740"; 跑
    @Scheduled(cron = "57 57 11 * * ?")
    public void Scheduled12_2() throws Exception {
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
        for (int i = 0; i < 1000; i++) {
            //延迟10ms
//            Thread.sleep(10);
            String time="0730-0740";

            String result = ditieService.CreateAppointment(tomorrow, time);
            System.out.println("已预约提交"+i+"次:"+result);
            if (result.contains("A2口")||result.contains("-1024")) {
                System.out.println("[预约成功!]：" + result);
                System.out.println("预约成功！正在发送邮件...");
                mailService.sendSimpleMail("865204206@qq.com",result);
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
    //晚上八点跑 time="0740-0750"
    @Scheduled(cron = "57 57 19 * * ?")
    public void Scheduled8_1() throws Exception {
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
        for (int i = 0; i < 1000; i++) {
            //延迟10ms
//            Thread.sleep(10);
            String time="0740-0750";

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

    //晚上八点跑 time="0730-0740""
    @Scheduled(cron = "57 57 19 * * ?")
    public void Scheduled8_2() throws Exception {
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
        for (int i = 0; i < 1000; i++) {
            //延迟10ms
//            Thread.sleep(10);
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

    //自定义时间跑
    @Scheduled(cron = "15 02 15 * * ?")
    public void Scheduled() throws Exception {
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
        for (int i = 0; i < 1000; i++) {
            //延迟10ms
//            Thread.sleep(10);
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


    //自定义 多线程 时间跑
    @Scheduled(cron = "00 33 17 * * ?")
    public void ScheduledThread() throws Exception {

        //创建固定线程个数为十个的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //执行线程,最多十个
        executorService.execute(threadClass);//适合适用于Runnable
        executorService.execute(threadClass);//适合适用于Runnable
        executorService.execute(threadClass);//适合适用于Runnable
        executorService.execute(threadClass);//适合适用于Runnable
        executorService.execute(threadClass);//适合适用于Runnable


        //executorService.submit();//适合使用于Callable
        //关闭线程池
        executorService.shutdown();

    }

}

