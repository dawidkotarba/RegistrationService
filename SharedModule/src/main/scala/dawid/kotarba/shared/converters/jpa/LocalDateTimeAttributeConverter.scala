package dawid.kotarba.shared.converters.jpa

import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.{AttributeConverter, Converter}


/**
  * Created by Dawid on 12.08.2016.
  */

@Converter(autoApply = true)
class LocalDateTimeAttributeConverter extends AttributeConverter[LocalDateTime, Timestamp] {
  override def convertToDatabaseColumn(attribute: LocalDateTime): Timestamp =
    if (attribute == null) null else Timestamp.valueOf(attribute)

  override def convertToEntityAttribute(dbData: Timestamp): LocalDateTime =
    if (dbData == null) null else dbData.toLocalDateTime
}
