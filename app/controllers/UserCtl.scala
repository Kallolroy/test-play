package controllers

import play.api.mvc._

import play.api.data.Form
import play.api.data.Forms.{mapping, text, optional}

import org.squeryl.PrimitiveTypeMode._
import models.{AppDB, User}
import play.api.libs.json.Json

/**
 * Created by kr on 1/22/2015.
 */
object UserCtl extends Controller {
  val userForm = Form(
    mapping(
      "name" -> optional(text),
      "address" -> optional(text),
      "email" -> optional(text)
    )(User.apply)(User.unapply)
  )

  def index = Action {
    Ok(views.html.user(userForm))
  }

  def getUsers = Action {
    implicit val userWrites = Json.writes[User]
    val json = inTransaction {
      val users = from(AppDB.userTable)(userTable =>
        select(userTable)
      )
      Json.toJson(users)
    }
    Ok(json)
  }

  def addUser = Action { implicit request =>
    userForm.bindFromRequest.value map { user =>
      inTransaction(AppDB.userTable insert user)
      Redirect(routes.UserCtl.index())
    } getOrElse BadRequest
  }

}
