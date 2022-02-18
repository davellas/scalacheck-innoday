package org.bargsten.pbt

import org.scalacheck.*
import org.scalacheck.Prop.forAll

import scala.math.pow

val smallPositiveInt = for {
  n <- Gen.choose(100, 1000)
  m <- Gen.choose(100, 1000)
  } yield (n, m)


object CalculateCheckTest extends Properties("String") {

  property("abc") = forAll(smallPositiveInt) {
    (c: Int, r: Int) =>
      println(s"r: ($r) c: $c")
//      val x = if(Math.random() > 0.5) true else false
      val (nc, nr) = Calculate.simpifySqRoot(c, r)
      c * pow(r, 2) == nc * pow(nr, 2)
  }

  property("startsWith") = forAll { (a: String, b: String) =>
    (a + b).startsWith(a)
  }

  property("endsWith") = forAll { (a: String, b: String) =>
    (a + b).endsWith(b)
  }

  property("substring") = forAll { (a: String, b: String) =>
    (a + b).substring(a.length) == b
  }

  property("substring") = forAll { (a: String, b: String, c: String) =>
    (a + b + c).substring(a.length, a.length + b.length) == b
  }
}
