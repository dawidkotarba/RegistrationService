package dawid.kotarba.shared.model.entities

/**
  * Created by Dawid on 08.07.2016.
  */
trait HasId[T] extends Serializable {
  def getId(): T
}