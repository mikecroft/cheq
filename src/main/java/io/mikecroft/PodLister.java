package io.mikecroft;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PodLister {

  @Inject
  protected KubernetesClient client;

  public List<Pod> getPods(){
    List<Pod> podList = client.pods().list().getItems();
    return podList;
  }
  
}