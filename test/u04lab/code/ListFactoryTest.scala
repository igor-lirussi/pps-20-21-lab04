package u04lab.code

import org.junit.jupiter.api.Test
import u04lab.code.Lists.{List}

class ListFactoryTest {

  @Test
  def listFactoryTest(): Unit = {
    val c1 = "c1"
    val c2 = "c2"
    val c3 = "c3"
    val courses = List.apply(c1 , c2 , c3 )

    println(courses)
  }

}
