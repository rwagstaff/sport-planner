package rw.event

import javax.persistence._

import rw.entity.{Contact, SequenceId}

@Entity
@Table
class Event(n: String) extends SequenceId {

  var name: String = n

  // For JPA
  def this() {
    this("")
  }


}
