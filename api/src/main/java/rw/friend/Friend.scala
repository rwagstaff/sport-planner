package rw.friend

import javax.persistence._

import rw.entity.{Contact, SequenceId}
import rw.user.User

@Entity
@Table class Friend(n: String, o: User) extends SequenceId with Contact {

  name = n

  // For JPA
  def this() = this("", null)

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "OWNER_ID")
  var owner: User = o


}