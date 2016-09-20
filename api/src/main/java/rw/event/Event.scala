package rw.event

import java.time.LocalDateTime
import javax.persistence._

import rw.entity.{Contact, SequenceId}

@Entity
@Table
class Event(n: String, t: LocalDateTime) extends SequenceId {

  var name: String = n

  var time: LocalDateTime = t

  // For JPA
  def this() {
    this("", null)
  }


}
