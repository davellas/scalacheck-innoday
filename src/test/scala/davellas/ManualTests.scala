package davellas

import org.junit.Assert.*
import org.junit.Test

class ManualTests:
  @Test def simpleTest(): Unit =
    val tested = SquareRoot(1, 12)
    assertEquals(simplify(tested), SquareRoot(2, 3))
