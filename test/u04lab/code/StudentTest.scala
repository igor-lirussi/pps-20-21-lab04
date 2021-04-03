package u04lab.code

import org.junit.jupiter.api.Assertions.{assertEquals, assertTrue}
import org.junit.jupiter.api.Test
import u04lab.code.Lists.List.Cons
import u04lab.code.Lists.List.{Cons, Nil}
import u04lab.code.Try.{cPCD, cPPS, cSDR, s1, s2, s3}

class StudentTest {

  @Test
  def studentTest1: Unit = {
    //val s1 = StudentImpl() //todo
    //assertEquals(s1, StudentImpl("anonimo", 2021))
  }


  @Test
  def studentTest(): Unit = {
    val cPPS = Course("PPS","Viroli")
    val cPCD = Course("PCD","Ricci")
    val cSDR = Course("SDR","D'Angelo")
    val s1 = Student("mario",2015)
    assertEquals(Nil() , s1.courses)
    val s2 = Student("gino",2016)
    val s3 = Student("rino") //defaults to 2017
    assertEquals(s3.year, 2017)
    s1.enrolling(cPPS)
    s1.enrolling(cPCD)
    s2.enrolling(cPPS)
    s3.enrolling(cPPS)
    s3.enrolling(cPCD)
    s3.enrolling(cSDR)
    println(s1.courses, s2.courses, s3.courses) // (Cons(PCD,Cons(PPS,Nil())),Cons(PPS,Nil()),Cons(SDR,Cons(PCD,Cons(PPS,Nil()))))
    assertEquals(Cons("PCD",Cons("PPS", Nil())) , s1.courses)
    assertEquals(Cons("PPS",Nil()) , s2.courses)
    assertEquals(Cons("SDR",Cons("PCD",Cons("PPS",Nil()))) , s3.courses)
    //assertTrue(s1.hasTeacher("Ricci"))
  }

}
