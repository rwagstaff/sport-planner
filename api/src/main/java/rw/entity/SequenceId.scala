package rw.entity

import javax.persistence.{GeneratedValue, Id}

import scala.beans.BeanProperty

trait SequenceId {
  @GeneratedValue
  @BeanProperty
  @Id
  var id: Int = _
}
