package rw.event

import org.springframework.data.jpa.repository.JpaRepository

trait EventRepository extends JpaRepository[Event, Integer] {

}
