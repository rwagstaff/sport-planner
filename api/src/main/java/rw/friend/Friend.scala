package rw.friend

import javax.persistence.Entity
import javax.persistence.Table

import rw.entity.{Contact, SequenceId}

@Entity
@Table class Friend(n: String) extends SequenceId with Contact {

  name = n

  // For JPA
  def this() {
    this("")
  }


}