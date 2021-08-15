package com.armeneum

import db.SlickPgPostgresProfile.api._

import java.time.{LocalDate, ZonedDateTime}

package object testrepo {

  case class TestClass(a: Int, b: String)

  case class PlayerInsertRequest(name: String, country: String, dob: Option[LocalDate]) {
    def toRow(): PlayerRow =
      PlayerRow(
        id = 0L, // Overwritten by autoinc
        name = name,
        country = country,
        dob = dob,
        created = ZonedDateTime.now()
      )
  }

  object DatabaseMappers {
//    // Example db type mapper (we don't need this since Slick 3.3 has a built-in LocalDateTime mapper)
//    implicit val dateTimeMapper: JdbcType[LocalDateTime] with BaseTypedType[LocalDateTime] =
//      MappedColumnType.base[LocalDateTime, String](
//        tmap = DateTimeHelper.toDateString,
//        tcomap = DateTimeHelper.fromString
//      )
  }

  case class PlayerRow(id: Long, name: String, country: String, dob: Option[LocalDate], created: ZonedDateTime)

// Uncomment this when you add your first custom db type mapper
//  import DatabaseMappers._

  class PlayerTable(tag: Tag) extends Table[PlayerRow](tag, None, "players") {
    override def *           = (id, name, country, dateOfBirth, created) <> (PlayerRow.tupled, PlayerRow.unapply)
    val id: Rep[Long]        = column[Long]("player_id", O.AutoInc, O.PrimaryKey)
    val name: Rep[String]    = column[String]("name")
    val country: Rep[String] = column[String]("country")
    val dateOfBirth: Rep[Option[LocalDate]] = column[Option[LocalDate]]("date_of_birth")
    val created: Rep[ZonedDateTime]         = column[ZonedDateTime]("created")
  }
}
