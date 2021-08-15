package com.armeneum.models

import org.scalatest.flatspec.AnyFlatSpec
import java.time.{ LocalDate, LocalDateTime }

class JsonFormattersSpec extends AnyFlatSpec {
  import JsonFormatters._

  behavior of "DateHelper"

  it must "Parse a Date to and from a string" in {
    val dateOriginal: LocalDate = LocalDate.now()
    println(s"dateOriginal: $dateOriginal")

    val dateString = LocalDateHelper.toDateString(dateOriginal)
    println(s"dateString: $dateString")

    val dateAfterMapper: LocalDate = LocalDateHelper.fromString(dateString)
    println(s"dateAfterMapper: $dateAfterMapper")

    assert(dateOriginal === dateAfterMapper)
  }

  behavior of "DateTimeHelper"

  it must "Parse a LocalDateTime to and from a string" in {

    val dateTimeOriginal: LocalDateTime = LocalDateTime.now()
    println(s"dateTimeOriginal: $dateTimeOriginal")

    val dateTimeString = DateTimeHelper.toDateString(dateTimeOriginal)
    println(s"dateTimeString: $dateTimeString")

    val dateTimeAfterMapper: LocalDateTime = DateTimeHelper.fromString(dateTimeString)
    println(s"dateTimeAfterMapper: $dateTimeAfterMapper")

    assert(dateTimeOriginal === dateTimeAfterMapper)
  }
}
