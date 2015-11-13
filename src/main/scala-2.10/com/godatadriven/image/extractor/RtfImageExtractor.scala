package com.godatadriven.image.extractor

import java.io.{InputStream, OutputStream}

import org.apache.tika.detect.DefaultDetector
import org.apache.tika.extractor.EmbeddedDocumentExtractor
import org.apache.tika.io.TikaInputStream
import org.apache.tika.metadata.Metadata
import org.apache.tika.parser.{AutoDetectParser, ParseContext, Parser}
import org.apache.tika.sax.{BodyContentHandler, EmbeddedContentHandler}
import org.xml.sax.ContentHandler
import org.xml.sax.helpers.DefaultHandler

class RtfImageExtractor {

  def extractImageExample(path: String): Unit = {
    val metadata: Metadata = new Metadata()
    val input = TikaInputStream.get(getClass.getResourceAsStream(path))

    val detector = new DefaultDetector()
    val parser: AutoDetectParser = new AutoDetectParser(detector)

    val context: ParseContext = new ParseContext()
    context.set(classOf[Parser], parser)
    context.set(classOf[EmbeddedDocumentExtractor], new FileEmbeddedDocumentExtractor)
    this.process(input, System.out, metadata, context)
    val handler = new EmbeddedContentHandler(new BodyContentHandler())
  }

  def parseRtf(path: String): String = {
    val parser: AutoDetectParser = new AutoDetectParser()
    val handler: BodyContentHandler = new BodyContentHandler()
    val metadata: Metadata = new Metadata()
    try {
      val stream: InputStream = getClass.getResourceAsStream(path)
      parser.parse(stream, handler, metadata)
      handler.toString
    }
  }

  @throws(classOf[Exception])
  def process(input: InputStream, output: OutputStream, metadata: Metadata, context: ParseContext) {
    val p: AutoDetectParser = new AutoDetectParser()

    val handler: ContentHandler = new DefaultHandler()
    p.parse(input, handler, metadata, context)
  }
}
