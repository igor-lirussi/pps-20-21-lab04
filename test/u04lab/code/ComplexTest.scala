package u04lab.code

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse}
import org.junit.jupiter.api.Test

class ComplexTest {

  @Test
  def testComplex1(): Unit = {
    val comp1= new ComplexImpl(2,4)
    val comp2= new ComplexImpl(3,6)

    //equalità tra riferimenti non essendo definito l'equals
    assertFalse(new ComplexImpl(3,6) == new ComplexImpl(3,6))

    println(new ComplexImpl(3,6).toString)

  }

}
