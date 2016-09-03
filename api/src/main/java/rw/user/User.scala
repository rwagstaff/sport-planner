package rw.user

import javax.persistence.{Entity, OneToMany, Table}

import rw.entity.{Contact, SequenceId}
import rw.friend.Friend

import scala.collection.JavaConversions._

@Entity
@Table
class User(n: String, e: String) extends SequenceId with Contact {

  name = n
  email = e

  // For JPA
  def this() = this(null, null)

  @OneToMany(mappedBy = "owner")
  var friends: java.util.List[Friend] = _

  def setFriends(fs: List[Friend]): Unit = {
    friends = fs.toList
  }
}
