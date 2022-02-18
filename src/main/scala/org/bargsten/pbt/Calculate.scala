package org.bargsten.pbt

object Calculate {

  def simpifySqRoot(coeff: Int, radicant: Int): (Int, Int) = {
    if(radicant < 0) throw new IllegalArgumentException()
    var (c, r) = (coeff, radicant)

    (2 to radicant).foreach(i => {
      if (r % (i * i) == 0) {
        c = c * i
        r = r / (i * i)
      }
    })

    (c, r)
  }

}
