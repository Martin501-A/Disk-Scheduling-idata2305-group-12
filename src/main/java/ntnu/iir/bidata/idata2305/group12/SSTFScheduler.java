package ntnu.iir.bidata.idata2305.group12;

import java.util.List;

/**
 * Represents a scheduler that gives the new position based the
 * address with the shortest seek time.
 */
public class SSTFScheduler implements DiscScheduler{

  public SSTFScheduler() {

  }

  /**
   * Gives the new address with the shortest distance from
   * the head position.
   *
   * @param headPosition The current head position of the disk.
   * @param requests The addresses the scheduler will choose from.
   * @return The address closest to the head position.
   */
  @Override
  public Integer getNewPosition(Integer headPosition, List<Integer> requests) {
    int nearestPostion = headPosition;
    int distance = 200;
    for (int i : requests) {
      if (Math.abs(headPosition - i) < distance) {
        nearestPostion = i;
        distance = Math.abs(headPosition - i);
      }
    }
    return nearestPostion;
  }
}
