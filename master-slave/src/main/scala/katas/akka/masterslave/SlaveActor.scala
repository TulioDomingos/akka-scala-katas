package katas.akka.masterslave

import akka.actor.Actor

/**
 * Created by Tulio Domingos
 */
class SlaveActor extends Actor {
  def receive = {
    case ReverseWord(word: String) => sender ! ReversedWord(word.reverse)
  }
}
