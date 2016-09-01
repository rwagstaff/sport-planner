package rw.friend

import rw.user.User

object FriendTest {

  def testFriends(u : User) = List(new Friend("friend 1", u), new Friend("friend 2", u), new Friend("friend 3", u))

}