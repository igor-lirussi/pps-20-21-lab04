package u04lab.code

import u04lab.code.Lists.List
import u04lab.code.Lists.List.{Nil, append, _}
import u04lab.code.Optionals.Option
import u04lab.code.Streams.Stream
import u04lab.code.Streams.Stream.{Empty, streamFromList, take}

import scala.util.Random

trait PowerIterator[A] {
  def next(): Option[A]
  def allSoFar(): List[A]
  def reversed(): PowerIterator[A]
}

trait PowerIteratorsFactory {

  def incremental(start: Int, successive: Int => Int): PowerIterator[Int]
  def fromList[A](list: List[A]): PowerIterator[A]
  def randomBooleans(size: Int): PowerIterator[Boolean]
}

class PowerIteratorsFactoryImpl extends PowerIteratorsFactory {

    override def incremental(start: Int, successive: Int => Int): PowerIterator[Int] = PowerIteratorImpl(Stream.iterate(start)(successive))

  override def fromList[A](list: List[A]): PowerIterator[A] = PowerIteratorImpl(streamFromList(list))

  override def randomBooleans(size: Int): PowerIterator[Boolean] = PowerIteratorImpl(take(Stream.generate(Random.nextBoolean()))(size))

}

//implementazione
case class PowerIteratorImpl[A](var stream: Stream[A]) extends PowerIterator[A] {
  private var listOldElems:List[A] = Nil()

  override def next(): Optionals.Option[A] = stream match {
    case Stream.Cons(h, t) => //se lo stream contiene qualcosa
      listOldElems = append(listOldElems, List.Cons(h(), Nil())) //aggiungo la testa alla history
      stream = t() //lo stream avanza di uno, perdendo la testa
      Option.Some(h()) //ritorno la testa
    case _ => Option.empty  //se  lo stream non ha testa e coda, è vuoto e torno empty
  }

  override def allSoFar(): List[A] = listOldElems

    //reverse sulla history
  override def reversed(): PowerIterator[A] = PowerIteratorImpl(streamFromList(reverse(listOldElems)))
}
