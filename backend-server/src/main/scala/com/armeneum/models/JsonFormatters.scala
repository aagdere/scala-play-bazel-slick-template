package com.armeneum.models

import com.armeneum.testrepo.{ PlayerInsertRequest, PlayerRow }
import play.api.http.{ ContentTypeOf, ContentTypes, Writeable }
import play.api.libs.functional.syntax.toFunctionalBuilderOps
import play.api.libs.json._

import java.time.format.DateTimeFormatter
import java.time.{ LocalDate, LocalDateTime }
import scala.util.{ Failure, Success, Try }

object JsonFormatters {

  object DateTimeHelper {
    val isoLocalDateTimeFormat: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    def fromString(string: String): LocalDateTime     = LocalDateTime.parse(string, isoLocalDateTimeFormat)
    def toDateString(dateTime: LocalDateTime): String = dateTime.format(isoLocalDateTimeFormat)
  }

  object LocalDateHelper {
    val localDateFormat: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE

    def fromString(string: String): LocalDate = LocalDate.parse(string, localDateFormat)
    def toDateString(date: LocalDate): String = date.format(localDateFormat)
  }

  val dateReads: Reads[LocalDate] = {
    case JsString(dateStr) =>
      Try(LocalDateHelper.fromString(dateStr)) match {
        case Success(dateTime)  => JsSuccess(dateTime)
        case Failure(exception) => JsError(exception.getMessage)
      }
    case _: JsValue => throw new IllegalStateException("")
  }

  val dateTimeReads: Reads[LocalDateTime] = {
    case JsString(dateStr) =>
      Try(DateTimeHelper.fromString(dateStr)) match {
        case Success(dateTime)  => JsSuccess(dateTime)
        case Failure(exception) => JsError(exception.getMessage)
      }
    case _: JsValue => throw new IllegalStateException("")
  }

  val playerReads: Reads[PlayerInsertRequest] =
    (
      (__ \ "name").read[String] and
        (__ \ "country").read[String] and
        (__ \ "dob").readNullable[LocalDate](dateReads)
    )(PlayerInsertRequest.apply _)

  val playerWrites: Writes[PlayerRow] = playerRow =>
    Json.obj(
      "id"      -> playerRow.id,
      "name"    -> playerRow.name,
      "country" -> playerRow.country,
      "dob"     -> playerRow.dob.map(_.toString)
    )

  val longWrites: Writes[Long] = long => JsNumber(long)

  implicit class WritesHelper[A](writes: Writes[A]) {
    def toListWrites(): Writes[List[A]] = {
      implicit val iWrites: Writes[A] = writes
      Writes.iterableWrites2[A, List[A]]
    }

    def toWriteable(): Writeable[A] = {
      val contentType = ContentTypeOf[A](Some(ContentTypes.JSON))
      val transform   = Writeable.writeableOf_JsValue.transform.compose(writes.writes)
      Writeable(transform)(contentType)
    }

    def wrapWithResult(): Writes[A] =
      writes.transform(jsValue => Json.obj("result" -> jsValue))
  }
}
