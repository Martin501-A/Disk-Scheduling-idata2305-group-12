package ntnu.iir.bidata.idata2305.group12;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

public class Main {
  public static void main(String[] args) {
    Triplet<Boolean, Integer, List<Integer>> triplet = case1();
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