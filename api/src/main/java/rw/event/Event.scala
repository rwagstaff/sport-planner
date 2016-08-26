package rw.event

import javax.persistence._

import rw.entity.{Contact, SequenceId}

@Entity
@Table
class Event(n: String) extends SequenceId with Contact {

  name = n

  // For JPA
  def this() {
    this("")
  }


}
