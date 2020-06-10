package io.mikecroft;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class PodLister {

  @Inject
  protected KubernetesClient client;

  private List<Pod> podList;

  void onStartup(@Observes StartupEvent _ev) {
    this.podList = client.pods().list().getItems();
    System.out.println("Found " + podList.size() + " Pods:");
    for (Pod pod : podList) {
      System.out.println(" * " + pod.getMetadata().getName());
    }
  }

  public String getPods(){
    this.podList = client.pods().list().getItems();
    return JsonbBuilder.create()
            .toJson(podList);
  }
  
}