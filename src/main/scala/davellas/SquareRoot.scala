package davellas

case class SquareRoot(coefficient: Int, radicand: Int):
  require(radicand >= 0)

def simplify(sr: SquareRoot): SquareRoot =
  (2 to sr.radicand).foldLeft(sr) { (simplified, i) =>
    if simplified.radicand % (i * i) == 0 then
      SquareRoot(simplified.coefficient * i, simplified.radicand / (i * i))
    else simplified
  }

case class SquareRootBigInt(coefficient: BigInt, radicand: BigInt):
  require(radicand >= 0)

def simplify(sr: SquareRootBigInt): SquareRootBigInt =
  (2 to sr.radicand.toInt).foldLeft(sr) { (simplified, i) =>
    val big = BigInt(i)
    val squared = big.pow(2)
    if simplified.radicand % squared == 0 then
      SquareRootBigInt(
        simplified.coefficient * big,
        simplified.radicand / squared
      )
    else simplified
  }
