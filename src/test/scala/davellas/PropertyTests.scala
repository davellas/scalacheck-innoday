package davellas
import org.scalatest.*
import org.scalacheck.Prop.{forAll, propBoolean}
import org.scalatest.prop.TableDrivenPropertyChecks.whenever
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks
import org.scalatest.flatspec.AnyFlatSpec
import matchers.should.*
import org.scalacheck.{Arbitrary, Gen}

import scala.language.postfixOps

class PropertyTests
    extends AnyFlatSpec
    with ScalaCheckDrivenPropertyChecks
    with Matchers:
  def squareRootGens: Gen[SquareRoot] = for {
    coeff <- Gen.choose(-99999, 99999)
    rad <- Gen.choose(0, 99999)
  } yield SquareRoot(coeff, rad)

  def squareRootGens2: Gen[SquareRootBigInt] = for {
    coeff <- Gen.choose(-99999, 99999)
    rad <- Gen.choose(0, 99999)
  } yield SquareRootBigInt(coeff, rad)

//  it should "have higher radicand than simplified version" in {
//    forAll { (coeff: Int, rad: Int) =>
//      whenever(rad >= 0) {
//        val sr = SquareRoot(coeff, rad)
//        sr.radicand >= simplify(sr).radicand
//      }
//    }
//  }

//  it should "have higher radicand than simplified version 2" in {
//    forAll { (coeff: Int, rad: Int) =>
//      whenever(rad >= 0) {
//        val sr = SquareRootBigInt(coeff, rad)
//        sr.radicand >= simplify(sr).radicand
//      }
//    }
//  }

  it should "work with generators" in {
    forAll(squareRootGens) { (sr: SquareRoot) =>
      sr.radicand >= simplify(sr).radicand
    }
  }

  it should "result in equal numbers" in {
    forAll(squareRootGens) { (sr: SquareRoot) =>
      println(sr)
      val simplified = simplify(sr)
      simplified.coefficient * simplified.radicand * simplified.radicand == sr.coefficient * sr.radicand * sr.radicand
    }
  }

  it should "work with generators2" in {
    forAll(squareRootGens2) { (sr: SquareRootBigInt) =>
      sr.radicand >= simplify(sr).radicand
    }
  }

  it should "result in equal numbers2" in {
    forAll(squareRootGens2) { (sr: SquareRootBigInt) =>
      val simplified = simplify(sr)
      simplified.coefficient * simplified.radicand * simplified.radicand == sr.coefficient * sr.radicand * sr.radicand
    }
  }
