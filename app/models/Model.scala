package models

import org.squeryl.{Schema, KeyedEntity}
import org.squeryl.annotations.Column

case class Bar(
                @Column("name") name: Option[String]
                )
  extends KeyedEntity[Int] {
  val id: Int = 0
}

case class User(
                 @Column("user_name") name: Option[String],
                 @Column("user_address") address: Option[String],
                 @Column("user_email") email: Option[String]
                 )
  extends KeyedEntity[Int] {
  val id: Int = 0
}

object AppDB extends Schema {
  val barTable = table[Bar]("bar")
  val userTable = table[User]("user")
}