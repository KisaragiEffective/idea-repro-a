package com.github.kisaragieffective.reproduce.idea.a

// derived from https://github.com/GiganticMinecraft/SeichiAssist/blob/53ca2d17ada36255b0ab8eb6e001e54dc9c72588/src/main/scala/com/github/unchama/generic/algebra/typeclasses/PositiveInt.scala
// Licensed under GPLv3, authors: Kory__3 and KisaragiEffective
import cats.Order
import simulacrum.typeclass

/**
 * 正のIntと同型な型のクラス。
 *
 * すべての正のnについて、
 *
 *   - `wrapPositive(n).asInt = n`
 *
 * を満たす。
 */
@typeclass trait PositiveInt[T] {

  /**
   * 正整数を包む。非正整数については例外を投げる。
   */
  def wrapPositive(int: Int): T

  /**
   * [[T]] を正整数に変換する。
   */
  def asInt(t: T): Int

}

object PositiveInt {
  implicit def positiveIntHasOrder[T: PositiveInt]: Order[T] = Order.by(PositiveInt[T].asInt)

  def callImplicitApply[T: PositiveInt]: PositiveInt[T] = PositiveInt[T]

  def callExplicitApply[T: PositiveInt]: PositiveInt[T] = PositiveInt.apply[T]
}
