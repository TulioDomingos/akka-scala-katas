package katas.akka.masterslave

import akka.actor.Actor

/**
 * Created by Tulio Domingos
 */
class Listener extends Actor {
  def receive = {
    case ReversedSentence(sentence) =>
      println(s"Reversed sentence is: $sentence")
      context.system.shutdown()
  }
}
