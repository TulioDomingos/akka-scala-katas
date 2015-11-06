Akka Kata in Scala
==========
An Akka exercise in Scala inspired by Jonas Boner's [getting started tutorial](http://doc.akka.io/docs/akka/2.0.2/intro/getting-started-first-scala.html)

###Prerequisites
Java 1.6 or later installed on you machine and Java on your `PATH`
You need to make sure that `$JAVA_HOME` environment variable is set to the root of the Java distribution. You also need to make sure that the `$JAVA_HOME/bin` is on your `PATH`

###Objective

The goal of this this exercise is to implement a system that reverses a given sentence using the [Master/Slave pattern](http://www.openloop.com/softwareEngineering/patterns/designPattern/dPattern_MasterSlave.htm) (also known as Divide & Conquer)

The `Master` actor has the following responsibilities: 

- Create child actors (slaves).
- Receive messages from the outside world
- Delegate work to child actors
- Supervise the child actors. (the default supervision strategy is used, supervision is not part of this exercise)

###Flow of the program

- `Master` actor accepts a sentence 
- Split the sentence into chunks of words which are sent out to each `Slave` actor to be processed (reverse each word). 
- When each worker has processed its chunk it sends a result back to the master which aggregates the total result. Order of words aren't important (subtasks do not need coordination)
- Send the aggregated total result (reversed words) to the `Listener`
- `Listener` prints out the result.

###What is already prepared

- `Main.scala`: Creates an ActorSystem, instantiates the Master & the Listener actor, and interacts with the master by sending a message
- `ReverseMessage.scala`: Defines the messages that flow in the system
- `Listener.scala`: The listener actor
- `MasterActor.scala`: The master actor stub
- `SlaveActor.scala`: The slave actor stub
- `SlaveActorSpec.scala`: Slave actor BDD test.

A good starting point is to make the `SlaveActorSpec` pass.

###Running the application

- Clone the repository: https://github.com/TulioDomingos/akka-scala-katas.git
- Change directory: `cd master-slave`
- Execute tests: `./gradlew test`
- Run main class: `./gradlew run`
