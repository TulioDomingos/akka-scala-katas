package katas.akka.masterslave

import akka.actor._

/**
 * Created by Tulio Domingos
 */
object Main extends App {

  val system = ActorSystem("ReverseSentenceSystem")

  val listener = system.actorOf(Props[Listener], name = "listener")

  val master = system.actorOf(Props(new MasterActor(numOfSlaves = 4, listener)), name = "master")

  master ! ReverseSentence("I stepped on a Corn Flake now I'm a Cereal Killer")
}
