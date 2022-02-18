package davellas

case class SquareRoot(coefficient: Int, radicand: Int):
  require(radicand >= 0)

def simplify(sr: SquareRoot): SquareRoot =
  (2 to sr.radicand).foldLeft(sr) { (simplified, i) =>
    if simplified.radicand % (i * i) == 0 then
      SquareRoot(simplified.coefficient * i, simplified.radicand / (i * i))
    else simplified
  }
