package com.armeneum

import slick.jdbc.PostgresProfile.api._
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import slick.ast.BaseTypedType
import slick.jdbc.JdbcType

package object testrepo {

  case class TestClass(a: Int, b: String)

  case class PlayerInsertRequest(name: String, country: String, dob: Option[DateTime]) {
    def toRow(): PlayerRow =
      PlayerRow(
        id = 0L, // Overwritted by autoinc
        name = name,
        country = country,
        dob = dob
      )
  }

  implicit val dateTimeMapper: JdbcType[DateTime] with BaseTypedType[DateTime] = {
    val dateTimeFormat = DateTimeFormat.forPattern("yyyy-MM-dd")

    MappedColumnType.base[DateTime, String](
      tmap = _.toString(dateTimeFormat),
      tcomap = DateTime.parse(_, dateTimeFormat)
    )
  }

  case class PlayerRow(id: Long, name: String, country: String, dob: Option[DateTime])

  class PlayerTable(tag: Tag) extends Table[PlayerRow](tag, None, "players") {
    override def *                         = (id, name, country, dateOfBirth) <> (PlayerRow.tupled, PlayerRow.unapply)
    val id: Rep[Long]                      = column[Long]("player_id", O.AutoInc, O.PrimaryKey)
    val name: Rep[String]                  = column[String]("name")
    val country: Rep[String]               = column[String]("country")
    val dateOfBirth: Rep[Option[DateTime]] = column[Option[DateTime]]("date_of_birth")
  }
}
