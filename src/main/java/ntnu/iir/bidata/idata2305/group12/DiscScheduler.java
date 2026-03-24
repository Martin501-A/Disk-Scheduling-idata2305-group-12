package ntnu.iir.bidata.idata2305.group12;

import java.util.List;

public interface DiscScheduler {

  /**
   * Calculates the new position based on scheduler type.
   *
   * @return the new position.
   */
  public Integer getNewPosition(Integer headPosition, List<Integer> requests);
}
