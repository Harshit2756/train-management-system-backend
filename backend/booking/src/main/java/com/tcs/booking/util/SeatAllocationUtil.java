package com.tcs.booking.util;

import java.util.List;

public class SeatAllocationUtil {

  public static List<String> allocateSeats(int count, String seatClass) {
    // Dummy implementation: return seat numbers as S1, S2, ...
    return java.util.stream.IntStream
      .rangeClosed(1, count)
      .mapToObj(i -> seatClass + i)
      .toList();
  }
}
