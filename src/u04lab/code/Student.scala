package u04lab.code

import java.time.Year

import Lists._
import u04lab.code.Lists.List.{Cons, Nil, append, contains, length, map} // import custom List type (not the one in Scala stdlib)

trait Student {
  def name: String
  def year: Int
  def enrolling(course: Course*): Unit // the student participates to a Course
  def courses: List[String] // names of course the student participates to
  def hasTeacher(teacher: String): Boolean // is the student participating to a course of this teacher?
}

trait Course {
  def name: String
  def teacher: String
}

object Student {
  def apply(name: String, year: Int = 2017): Student = StudentImpl(name, year)
}

object Course {
  def apply(name: String, teacher: String): Course = CourseImpl(name, teacher)
}

case class CourseImpl(name:String, teacher:String) extends Course


case class StudentImpl(name:String, year: Int) extends Student {
//in case class parameters are public immutable

  //test auxiliary constructor, but apply method forces only one constructor
  def this() {
    this("anonimo", 2021)
    println (" auxiliary constructor used" )
  }

  var _courses: List[Course] = Nil()

  override def courses: List[String] = map(_courses)(course => course.name)

  override def enrolling(course: Course*): Unit =   course foreach ( course => _courses = Cons(course, _courses) )

  override def hasTeacher(teacher: String): Boolean = contains(map(_courses)(course => course.teacher))(teacher)  //anzichè passare la lista di corsi passo la lista di insegnanti

  //test new function, but unreachable!
  def isFollowing(): Boolean = length(courses)!=0
}


object Try extends App {
  val cPPS = Course("PPS","Viroli")
  val cPCD = Course("PCD","Ricci")
  val cSDR = Course("SDR","D'Angelo")
  val s1 = Student("mario",2015)
  val s2 = Student("gino",2016)
  val s3 = Student("rino") //defaults to 2017
  s1.enrolling(cPPS)
  s1.enrolling(cPCD)
  s2.enrolling(cPPS)
  s3.enrolling(cPPS)
  s3.enrolling(cPCD)
  s3.enrolling(cSDR)
  println(s1.courses, s2.courses, s3.courses) // (Cons(PCD,Cons(PPS,Nil())),Cons(PPS,Nil()),Cons(SDR,Cons(PCD,Cons(PPS,Nil()))))
  println(s1.hasTeacher("Ricci")) // true
}

/** Hints:
  * - simply implement Course, e.g. with a case class
  * - implement Student with a StudentImpl keeping a private Set of courses
  * - try to implement in StudentImpl method courses with map
  * - try to implement in StudentImpl method hasTeacher with map and find
  * - check that the two println above work correctly
  * - refactor the code so that method enrolling accepts a variable argument Course*
  */
