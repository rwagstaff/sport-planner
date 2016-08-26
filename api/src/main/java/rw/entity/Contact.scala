package rw.entity

import javax.validation.constraints.NotNull

import org.hibernate.validator.constraints.Email

import scala.beans.BeanProperty

trait Contact {

  @NotNull
  @BeanProperty
  var name: String = _

  @NotNull
  @BeanProperty
  @Email
  var email: String = _



}
