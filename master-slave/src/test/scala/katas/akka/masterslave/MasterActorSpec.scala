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

    s"process messages and send result of type $ReversedSentence to its listener" in {
      val probe = TestProbe()
      val master = TestActorRef(new MasterActor(numOfSlaves = 4, probe.ref))
      master ! ReverseSentence("I am on a seafood diet. I see food, and I eat it")
      expectNoMsg // master should not return messages
      probe.expectMsgType[ReversedSentence]
    }
  }

}
