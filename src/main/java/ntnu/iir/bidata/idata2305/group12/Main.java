package ntnu.iir.bidata.idata2305.group12;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

public class Main {
  public static void main(String[] args) {
    System.out.println("=== Testing Disk Scheduling Algorithms ===\n");

    // Run simulation for all three cases from the assignment
    runSimulation("Case 1", case1());
    runSimulation("Case 2", case2());
    runSimulation("Case 3", case3());
  }

  public static void runSimulation(String caseName, Triplet<Boolean, Integer, List<Integer>> triplet) {
    System.out.println("--- " + caseName + " ---");

    // Extract initial data
    Boolean initialDirection = triplet.getValue0();
    Integer initialHeadPosition = triplet.getValue1();
    List<Integer> requests = triplet.getValue2();

    // 1. To test FCFS:
//     DiskScheduler scheduler = new FCFSScheduler();

    // 2. To test SSTF:
    // DiskScheduler scheduler = new SSTFScheduler();

    // 3. To test SCAN:
    DiskScheduler scheduler = new SCANScheduler(initialDirection);


    // Initialize the disk and start processing
    Disk disk = new Disk(initialHeadPosition, initialDirection, scheduler);
    disk.addRequests(requests);
    disk.start();
    disk.printOutputs();
    System.out.println();
  }

  public static Triplet<Boolean, Integer, List<Integer>> case1() {
    List<Integer> requests = new ArrayList<>();
    requests.add(98);
    requests.add(183);
    requests.add(37);
    requests.add(122);
    requests.add(14);
    requests.add(124);
    requests.add(65);
    requests.add(67);
    return new Triplet<>(true,53, requests);
  }

  public static Triplet<Boolean, Integer, List<Integer>> case2() {
    List<Integer> requests = new ArrayList();
    requests.add(45);
    requests.add(48);
    requests.add(52);
    requests.add(90);
    requests.add(150);
    requests.add(160);
    return new Triplet<>(true,50, requests);
  }

  public static Triplet<Boolean, Integer, List<Integer>> case3() {
    List<Integer> requests = new ArrayList();
    requests.add(10);
    requests.add(12);
    requests.add(14);
    requests.add(16);
    requests.add(100);
    requests.add(102);
    return new Triplet<>(true,15, requests) ;
  }
}