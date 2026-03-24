package ntnu.iir.bidata.idata2305.group12;

import java.util.List;

/**
 * SCAN Scheduler (Elevator Algorithm).
 * The disk head moves in a given direction until the end of the disk (0 or 199),
 * servicing requests along the way, then reverses its direction.
 */
public class SCANScheduler implements DiskScheduler {

  private boolean movingRight;
  private static final int MAX_CYLINDER = 199;
  private static final int MIN_CYLINDER = 0;

  /**
   * Constructor initializes the initial moving direction of the disk head.
   * @param initialDirection true for moving right, false for moving left
   */
  public SCANScheduler(boolean initialDirection) {
    this.movingRight = initialDirection;
  }

  @Override
  public Integer getNewPosition(Integer headPosition, List<Integer> requests) {
    Integer nextPosition = null;
    int minDistance = Integer.MAX_VALUE;

    // Find the closest request in the CURRENT direction
    for (int req : requests) {
      if (movingRight && req >= headPosition) {
        int dist = req - headPosition;
        if (dist < minDistance) {
          minDistance = dist;
          nextPosition = req;
        }
      } else if (!movingRight && req <= headPosition) {
        int dist = headPosition - req;
        if (dist < minDistance) {
          minDistance = dist;
          nextPosition = req;
        }
      }
    }

    if (nextPosition != null) {
      // If a request is found in the current direction, remove it from the queue and move towards it
      requests.remove(requests.indexOf(nextPosition));
      return nextPosition;
    } else {
      // No more requests in the current direction.
      // Change the moving direction.
      movingRight = !movingRight;

      // According to SCAN rules, we must travel to the very edge of the disk before changing direction
      if (!movingRight) {
        // We were moving right, requests are exhausted, change direction to left.
        // So we must visit cylinder 199.
        if (headPosition != MAX_CYLINDER) {
          return MAX_CYLINDER;
        } else {
          // If we are already at 199, recursively look for the next request in the new direction
          return getNewPosition(headPosition, requests);
        }
      } else {
        // We were moving left, requests are exhausted, change direction to right.
        // So we must visit cylinder 0.
        if (headPosition != MIN_CYLINDER) {
          return MIN_CYLINDER;
        } else {
          return getNewPosition(headPosition, requests);
        }
      }
    }
  }

  @Override
  public String getName() {
    return "SCAN (Elevator Algorithm)";
  }
}
