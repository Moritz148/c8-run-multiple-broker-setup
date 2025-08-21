package com.envite.gmt.measurements;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.springframework.stereotype.Component;

@Component
public class Worker {
    @JobWorker(type = "testing1")
    public void dummyWorker1() {
        System.out.println("worker 1 fertig");
    }

    @JobWorker(type = "testing2")
    public void dummyWorker2() {
        System.out.println("worker 2 fertig");
    }

    @JobWorker(type = "testing3")
    public void dummyWorker3() {
        System.out.println("worker 3 fertig");
    }

    @JobWorker(type = "testing4")
    public void dummyWorker4() {
        System.out.println("worker 4 fertig");
    }

    @JobWorker(type = "testing5")
    public void dummyWorker5() {
        System.out.println("worker 5 fertig");
    }

    @JobWorker(type = "testing6")
    public void dummyWorker6() {
        System.out.println("worker 6 fertig");
    }

    @JobWorker(type = "testing7")
    public void dummyWorker7() {
        System.out.println("worker 7 fertig");
    }

    @JobWorker(type = "testing8")
    public void dummyWorker8() {
        System.out.println("worker 8 fertig");
    }

    @JobWorker(type = "testing9")
    public void dummyWorker9() {
        System.out.println("worker 9 fertig");
    }

    @JobWorker(type = "testing10")
    public void dummyWorker10() {
        System.out.println("worker 10 fertig");
    }
//    @JobWorker(type = "job1")
//    public void w1(){
//        System.out.println("job 1 fertig");
//    }
//    @JobWorker(type = "job2")
//    public void w2(){
//        System.out.println("job 2 fertig");
//    }
//    @JobWorker(type = "job3")
//    public void w3(){
//        System.out.println("job 3 fertig");
//    }
//    @JobWorker(type = "job4")
//    public void w4(){
//        System.out.println("job 4 fertig");
//    }
//    @JobWorker(type = "job5")
//    public void w5(){
//        System.out.println("job 5 fertig");
//    }

}
