package com.example.demo.config;

import io.fabric8.kubernetes.api.model.ServiceList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ConfigurationProperties
public class ClusterConfig {
    Config config = new ConfigBuilder().withMasterUrl("https://ampfvm37.hpeswlab.net:6443").withCaCertFile("C:/MyFile/Learn/self-learn-code/test-fabric-auth/ca.crt").withClientKeyFile("C:/MyFile/Learn/self-learn-code/test-fabric-auth/apiserver.key").withClientCertFile("C:/MyFile/Learn/self-learn-code/test-fabric-auth/apiserver.crt").build();
    KubernetesClient client = new DefaultKubernetesClient(config);

    public void showResource(){
//        NamespaceList myNs = client.namespaces().list();
//        log.info(caCert);
//        log.info("name"+name);
        System.out.println(client);
        ServiceList myServices = client.services().list();


        client.services().inNamespace("kube-system");
//        log.info("Kubernetes client {} opened.", client);
//        log.info(String.valueOf(myNs));
//        System.out.println(myNs);
//        System.out.println(myNsServices);
        System.out.println(myServices);
    }


}
