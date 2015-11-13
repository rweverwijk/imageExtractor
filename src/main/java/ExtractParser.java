import org.apache.tika.exception.TikaException;
import org.apache.tika.io.IOUtils;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AbstractParser;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class ExtractParser extends AbstractParser {
  private int att = 0;

  public Set<MediaType> getSupportedTypes(ParseContext context) {
    // Everything AutoDetect parser does
    return new AutoDetectParser().getSupportedTypes(context);
  }

  public void parse(
      InputStream stream, ContentHandler handler,
      Metadata metadata, ParseContext context)
      throws IOException, SAXException, TikaException {
    // Stream to a new file
    File f = new File("out-" + (++att) + ".bin");
    FileOutputStream fout = new FileOutputStream(f);
    IOUtils.copy(stream, fout);
    fout.close();
  }
}