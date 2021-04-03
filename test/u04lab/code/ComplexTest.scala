package u04lab.code

import org.junit.jupiter.api.Assertions.{assertEquals, assertFalse, assertTrue}
import org.junit.jupiter.api.Test

class ComplexTest {

  @Test
  def testComplex1(): Unit = {
    val comp1= new ComplexImpl(2,4)
    val comp2= new ComplexImpl(3,6)

    assertFalse(comp1==comp2)

    //equalità tra riferimenti non essendo definito l'equals
    assertFalse(new ComplexImpl(3,6) == new ComplexImpl(3,6))

    println(new ComplexImpl(3,6).toString)
  }

  @Test
  def testComplex2(): Unit = {

    //uguaglianza semantica essendo case class
    assertTrue(new ComplexImpl2(3,6) == new ComplexImpl2(3,6))
    assertFalse(new ComplexImpl2(6,3) == new ComplexImpl2(3,6))


    //non serve la new
    assertTrue( ComplexImpl2(3,6) ==  ComplexImpl2(3,6))

    //usando il companion obj fornito come factory
    assertTrue(Complex(3,6) == Complex(3,6))

    //toString implementata dal case class
    assertEquals("ComplexImpl2(3.0,6.0)",new ComplexImpl2(3,6).toString)
  }
}
