package guru.seledka.toty.presentation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Servlet to serve initial HTML page.
 */
public class IndexHtmlServlet extends HttpServlet {
  private static final String INDEX_HTML = "index.html";
  private static final String CONTENT_TYPE = "text/html";

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try(InputStream inputStream = getClass().getResource(INDEX_HTML).openStream()){
      response.setContentType(CONTENT_TYPE);
      PrintWriter out = response.getWriter();
      response.setStatus(HttpServletResponse.SC_OK);
      out.write(convertStreamToString(inputStream));
    }
  }

  /**
   * The reason it works is because Scanner iterates over tokens in the stream, and in this case we separate tokens
   * using "beginning of the input boundary" (\A) thus giving us only one token for the entire contents of the stream.
   * See https://weblogs.java.net/blog/pat/archive/2004/10/stupid_scanner_1.html for reference.
   * @param inputStream stream to read data from
   * @return contents of the stream as a string
   */
  private static String convertStreamToString(InputStream inputStream) {
    Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
    return scanner.hasNext() ? scanner.next() : "";
  }
}
