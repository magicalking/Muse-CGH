package main

import utilities.{CubicCurve, Vec2}

/**
  * An extension to CubicCurve with Drawing information
  */
case class InkCurve(curve: CubicCurve, dots: Int, startWidth: Double, endWidth: Double,
                    alignTangent: Boolean = true, isStrokeBreak: Boolean = false) {
  def setPoint(id: Int, p: Vec2) = {
    val nc = curve.setPoint(id, p)
    this.copy(curve = nc)
  }

  def connectNext = !isStrokeBreak
}

object InkCurve{
  val minimalWidth = 0.001

  val initDots = 50

  val initWidth = 0.05

  val initCurve = InkCurve(CubicCurve(Vec2.zero, Vec2(0.5,0), Vec2(0.5,-1), Vec2(1,-1)), initDots, initWidth, initWidth)
}