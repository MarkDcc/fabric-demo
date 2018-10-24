package com.example.demo.config;

import io.fabric8.kubernetes.api.model.Namespace;
import io.fabric8.kubernetes.api.model.NamespaceSpec;
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
    Config config = new ConfigBuilder().withMasterUrl("https://ampfvm36.hpeswlab.net:8443").withCaCertFile("C:/MyFile/Learn/self-learn-code/test-fabric-auth/ca.crt").withClientKeyFile("C:/MyFile/Learn/self-learn-code/test-fabric-auth/server.key").withClientCertFile("C:/MyFile/Learn/self-learn-code/test-fabric-auth/server.crt").build();
    KubernetesClient client = new DefaultKubernetesClient(config);

    public void showResource(){
//        NamespaceList myNs = client.namespaces().list();
//        log.info(caCert);
//        log.info("name"+name);
        System.out.println(client);
        ServiceList myServices = client.services().list();
        Namespace myns = client.namespaces().createNew()
                .withNewMetadata()
                .withName("myns")
                .addToLabels("a", "label")
                .endMetadata()
                .done();
        Namespace mynsg = (Namespace) client.namespaces().withName("myns");
        System.out.println("namespace"+mynsg);
//        Boolean mynsd = client.namespaces().withName("myns").delete();


//        client.services().inNamespace("kube-system");
//        log.info("Kubernetes client {} opened.", client);
//        log.info(String.valueOf(myNs));
//        System.out.println(mynsd);
//        System.out.println(myNsServices);
        System.out.println(myServices);
    }


}
