package katas.akka.masterslave

import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestActorRef, TestKit}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{MustMatchers, WordSpecLike}

/**
 * Created by Tulio Domingos
 */
@RunWith(classOf[JUnitRunner])
class SlaveActorSpec extends TestKit(ActorSystem("testSystem"))
  with ImplicitSender
  with WordSpecLike
  with MustMatchers {

  "The SlaveActor" must {

    "Reverse a word that it receives" in {

      val actorRef = TestActorRef[SlaveActor]
      actorRef ! ReverseWord("mamamia")
      expectMsg(ReversedWord("aimamam"))
    }
  }

}

