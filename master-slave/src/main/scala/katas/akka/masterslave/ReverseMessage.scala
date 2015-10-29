package katas.akka.masterslave

/**
 * Created by Tulio Domingos
 */
sealed trait ReverseMessage

case class ReverseSentence(s: String) extends ReverseMessage

case class ReversedSentence(s: String) extends ReverseMessage

case class ReverseWord(w: String) extends ReverseMessage

case class ReversedWord(w: String) extends ReverseMessage
