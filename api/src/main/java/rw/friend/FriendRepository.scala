package rw.friend

import org.springframework.data.jpa.repository.JpaRepository

trait FriendRepository extends JpaRepository[Friend, Integer]
