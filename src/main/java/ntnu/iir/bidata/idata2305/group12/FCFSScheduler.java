package ntnu.iir.bidata.idata2305.group12;

import java.util.List;

/**
 * Scheduler that gives the new position based on the first request in the list.
 */
public class FCFSScheduler implements DiskScheduler {

  /**
   * Calculates the new position based on scheduler type.
   *
   * @param headPosition current head position
   * @param requests list of requests to the disk scheduler
   * @return the new position.
   */
  @Override
  public Integer getNewPosition(Integer headPosition, List<Integer> requests) {
    return requests.removeFirst();
  }

  @Override
  public String getName() {
    return "First Come First Serve";
  }
}
