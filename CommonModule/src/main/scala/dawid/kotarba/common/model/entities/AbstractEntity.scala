package dawid.kotarba.common.model.entities

import java.lang.Long
import javax.persistence._

/**
  * Created by Dawid on 08.07.2016.
  */
trait AbstractEntity extends HasId[Long] with HasVersion[Integer] {

  @Id
  @Column(name = "ID")
  @GeneratedValue(generator = "PK", strategy = GenerationType.SEQUENCE)
  protected val id: Long = null

  @Version
  protected val version: Integer = null

  override def getId(): Long = id

  override def getVersion(): Integer = version

}
