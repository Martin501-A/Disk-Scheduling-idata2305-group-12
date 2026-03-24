package ntnu.iir.bidata.idata2305.group12;

import java.util.ArrayList;
import java.util.List;

public class Disk {
  private DiscScheduler scheduler;
  private List<Integer> requests;
  private List<Integer> requestOrder;
  private Integer travelDistance;
  private Integer headPosition;
  private Boolean direction; // Right is true, left is false.

  public Disk(Integer headPosition, Boolean direction, DiscScheduler scheduler) {
    this.scheduler = scheduler;
    this.direction = direction;
    this.headPosition = headPosition;
    this.requests = new ArrayList<>();
    this.requestOrder = new ArrayList<>();
    this.requestOrder.add(headPosition);
    travelDistance = 0;
  }

  public void addRequests(List<Integer> requests) {
    this.requests = requests;
  }

  public void start() {
    while (!requests.isEmpty()) {
      Integer newPosition = scheduler.getNewPosition(headPosition, requests);;
      Integer oldPosition = headPosition;
      this.travelDistance += Math.abs(newPosition - oldPosition);
      headPosition = newPosition;
      requestOrder.add(newPosition);
    };
  }

  /**
   * Print the following:
   *
   */
  public void printOutputs() {


  }
}
