package rw.entity

import javax.persistence.Column
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
  @Column(unique=true)
  var email: String = _



}
