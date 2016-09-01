package rw.user

import org.springframework.data.jpa.repository.JpaRepository


trait UserRepository extends JpaRepository[User, Integer]  {


}
