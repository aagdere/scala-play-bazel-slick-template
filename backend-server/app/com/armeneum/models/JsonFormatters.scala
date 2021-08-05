package com.armeneum.models

import com.armeneum.testrepo.{ PlayerInsertRequest, PlayerRow }
import org.joda.time.DateTime
import play.api.http.{ ContentTypeOf, ContentTypes, Writeable }
import play.api.libs.json._
import play.api.libs.functional.syntax._

object JsonFormatters {

  val dateTimeReads: Reads[DateTime] = Json.reads[String].map { dateStr =>
    ???
  }

  val playerReads: Reads[PlayerInsertRequest] =
    (
      (__ \ "name").read[String] and
        (__ \ "country").read[String] and
        (__ \ "dob").readNullable[DateTime](dateTimeReads)
    )(PlayerInsertRequest.apply _)

  val playerWrites: Writes[PlayerRow] = playerRow =>
    Json.obj(
      "id"      -> playerRow.id,
      "name"    -> playerRow.name,
      "country" -> playerRow.country,
      "dob"     -> playerRow.dob.map(_.toString)
    )

  val longWriteable: Writeable[Long] = {
    val longWrites: Writes[Long] = long => JsNumber(long)
    val contentType              = ContentTypeOf[Long](Some(ContentTypes.JSON))
    val transform                = Writeable.writeableOf_JsValue.transform.compose(longWrites.writes)
    Writeable(transform)(contentType)
  }

  val playerWriteable: Writeable[PlayerRow] = {
    val contentType = ContentTypeOf[PlayerRow](Some(ContentTypes.JSON))
    val transform   = Writeable.writeableOf_JsValue.transform.compose(playerWrites.writes)
    Writeable(transform)(contentType)
  }

  def listWriteable[A](singleWrites: Writes[A]): Writeable[List[A]] = {
    implicit val iWrites: Writes[A] = singleWrites
    val listWrites                  = Writes.iterableWrites2[A, List[A]]
    val contentType                 = ContentTypeOf[List[A]](Some(ContentTypes.JSON))
    val transform                   = Writeable.writeableOf_JsValue.transform.compose(listWrites.writes)
    Writeable(transform)(contentType)
  }
}
