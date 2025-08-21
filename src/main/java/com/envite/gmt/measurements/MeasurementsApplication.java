package com.envite.gmt.measurements;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Deployment(resources = "classpath:benchmark.bpmn")
public class MeasurementsApplication implements CommandLineRunner {

    private final ZeebeClient zeebeClient;

    public MeasurementsApplication(ZeebeClient zeebeClient) {
        this.zeebeClient = zeebeClient;
    }

//    private final ZeebeClient zeebeClient = ZeebeClient.newClientBuilder()
//            .gatewayAddress("zeebe-gateway:26500")
//            .usePlaintext()
//            .build();


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MeasurementsApplication.class, args);

//        context.close();
    }

    @Override
    public void run(String... args) throws Exception {
        if(zeebeClient==null){
            System.out.println("Zeebe Client not set");
            return;
        }

        var bpmnProcessId = "benchmark4";
        for (int i = 1; i < 201; i++) {
            System.out.println("instanz nr. " + i +" gestartet");
            zeebeClient.newCreateInstanceCommand()
                    .bpmnProcessId(bpmnProcessId)
                    .latestVersion()
                    .withResult()
                    .send()
                    .join();
        }

    }

}
