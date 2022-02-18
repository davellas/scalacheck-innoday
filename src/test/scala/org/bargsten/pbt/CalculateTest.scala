package org.bargsten.pbt

import org.scalacheck.*
import org.scalacheck.Arbitrary.arbitrary
import org.scalacheck.Gen.*
import org.scalacheck.Prop.{forAll, propBoolean}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatestplus.scalacheck.Checkers

import scala.math.pow

val smallPositiveInt = for (n <- Gen.choose(100, 1000)) yield n

class CalculateTest extends AnyFlatSpec with Checkers {
  it should "hold" in {
    check(forAll(smallPositiveInt, smallPositiveInt) { (c: Int, r: Int) =>
        println(s"r: ($r) c: $c")
        val (nc, nr) = Calculate.simpifySqRoot(c, r)
        c * pow(r, 2) == nc * pow(nr, 2)
    })
  }
}

//      (r > 0 && r < 1000 && c < 1000 && c > 0) ==> {
