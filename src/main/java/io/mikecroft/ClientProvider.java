package io.mikecroft;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.inject.Singleton;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@ApplicationScoped
public class ClientProvider {

  @Produces
  @Named("namespace")
  protected String findNamespace() throws IOException {
    return new String(Files.readAllBytes(Paths.get("/var/run/secrets/kubernetes.io/serviceaccount/namespace")));
  }

  @Produces
  protected KubernetesClient newClient(@Named("namespace") String namespace) {
    return new DefaultKubernetesClient().inNamespace(namespace);
  }
}