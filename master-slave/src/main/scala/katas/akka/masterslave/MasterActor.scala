package katas.akka.masterslave

import akka.actor.{Props, Actor, ActorRef}
import akka.routing.{RoundRobinPool, RoundRobinRouter}

/**
 * Created by Tulio Domingos
 */
class MasterActor(numOfSlaves: Int, listener: ActorRef) extends Actor {

  var numOfWords: Int = _

  var numOfCompletedWords: Int = _

  var reversedSentence: String = ""

  val workerRouter = context.actorOf(
    Props[SlaveActor].withRouter(RoundRobinPool(numOfSlaves)), name = "slaveActorRouter"
  )

  def receive = ???
}
