package com.envite.gmt.measurements;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.Topology;
import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Deployment(resources = "classpath:benchmark.bpmn")
public class MeasurementsApplication implements CommandLineRunner {

    private final ZeebeClient zeebeClient;

    private static final Logger LOG = LoggerFactory.getLogger(MeasurementsApplication.class);
    public MeasurementsApplication(ZeebeClient zeebeClient) {
        this.zeebeClient = zeebeClient;
    }

//    private final ZeebeClient zeebeClient = ZeebeClient.newClientBuilder()
//            .gatewayAddress("zeebe-gateway:26500")
//            .usePlaintext()
//            .build();


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MeasurementsApplication.class, args);

        context.close();
    }

    @Override
    public void run(String... args) throws Exception {
        if(zeebeClient==null){
            System.out.println("Zeebe Client not set");
            return;
        }
        /*final Topology topology = zeebeClient.newTopologyRequest().send().join();

        System.out.println("Topology:");
        topology
                .getBrokers()
                .forEach(
                        b -> {
                            System.out.println("    " + b.getAddress());
                            b.getPartitions()
                                    .forEach(
                                            p ->
                                                    System.out.println(
                                                            "      " + p.getPartitionId() + " - " + p.getRole()));
                        });*/
        var bpmnProcessId = "benchmarkTest";
        for (int i = 1; i < 101; i++) {
            LOG.info("Prozessinstanz #" + i +" gestartet");
            zeebeClient.newCreateInstanceCommand()
                    .bpmnProcessId(bpmnProcessId)
                    .latestVersion()
                    .withResult()
                    .send()
                    .join();
            LOG.info("Prozessinstanz #" + i +" beendet");
        }

    }

}
