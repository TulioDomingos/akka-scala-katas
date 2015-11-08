package katas.akka.masterslave

import akka.actor.ActorSystem
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{MustMatchers, WordSpecLike}
import akka.testkit.{TestProbe, ImplicitSender, TestActorRef, TestKit}

/**
 * Created by Tulio Domingos
 */
@RunWith(classOf[JUnitRunner])
class MasterActorSpec extends TestKit(ActorSystem("testSystem"))
  with ImplicitSender
  with WordSpecLike
  with MustMatchers {

  "The MasterActor" must {

    "process messages and send the result to its listener" in {
      val probe = TestProbe()
      val master = TestActorRef(new MasterActor(numOfSlaves = 4, probe.ref))
      master ! ReverseSentence("I am on a seafood diet I see food and I eat it")
      expectNoMsg // master should not return messages
      val sentence = probe.expectMsgType[ReversedSentence]

      val words = sentence.s.split(" ")
      words.length mustEqual 13
      words must contain theSameElementsAs Array("I", "no", "a", "ma", "doofaes", "I", "I", "ees", "teid", "doof", "tae", "dna", "ti")
    }
  }

}
