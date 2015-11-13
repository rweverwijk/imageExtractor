import org.scalatest.{DiagrammedAssertions, FlatSpec}

class RtfImageExtractorTest extends FlatSpec with DiagrammedAssertions {

  "a rtf extractor" should "extract metadata" in {
    val result: String = new RtfImageExtractor().parseRtf("/rtf_image_test.rtf")
    assert(result == """Hallo,
                       |
                       |Dit is een test document, met tekst en een plaatje.
                       |
                       |Groeten Kris
                       |
                       |
                       |En Ron
                       |
                       |
                       |
                       |""".stripMargin)
  }

  it should "return an image from the resource" in {
    new RtfImageExtractor().extractImageExample("/rtf_image_test.rtf")
//    assert(image.length === 12345)
  }
}
