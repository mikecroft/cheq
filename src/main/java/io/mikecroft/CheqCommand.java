package io.mikecroft;

import javax.inject.Inject;
import picocli.CommandLine;

import io.fabric8.kubernetes.api.model.Pod;
import java.util.List;

@CommandLine.Command
public class CheqCommand implements Runnable {

    @Inject
    PodLister podLister;

    public void getPods() {
        List<Pod> podList = podLister.getPods();
        for (Pod pod : podList) {
            System.out.println(pod.getMetadata().getName());
        }
    }

    @Override
    public void run(){
        getPods();
    }
}