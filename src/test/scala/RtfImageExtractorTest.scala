import org.scalatest.{DiagrammedAssertions, FlatSpec}

class RtfImageExtractorTest extends FlatSpec with DiagrammedAssertions {

  "a rtf extractor" should "extract metadata" in {
    val result: String = new RtfImageExtractor().parseRtf("/rtf_image_test.rtf")
    assert(result == """Hello,
                       |
                       |This is a test document in RTF Format.
                       |There are two images in this message.
                       |A JPG like this:
                       |
                       |And a PNG like this:
                       |
                       |Cheers!
                       |
                       |""".stripMargin)
  }

  it should "return an image from the resource" in {
    new RtfImageExtractor().extractImageExample("/rtf_image_test.rtf")
  }
}
