package dawid.kotarba.common.model.entities

/**
  * Created by Dawid on 08.07.2016.
  */
trait HasVersion[T] {
  def getVersion(): T
}
