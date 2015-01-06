package guru.seledka.toty.presentation;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import guru.seledka.toty.dao.OfyService;
import guru.seledka.toty.model.Lesson;
import guru.seledka.toty.model.User;
import guru.seledka.toty.model.UserLesson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Servlet to serve initial HTML page.
 */
public class IndexHtmlServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User user = new User();
    user.setEmail("olga.not.1958@gmail.com");
    Key<User> userKey = OfyService.ofy().save().entity(user).now();

    Lesson lesson = new Lesson();
    lesson.setId("test-lesson");
    Key<Lesson> lessonKey = OfyService.ofy().save().entity(lesson).now();

    UserLesson userLesson = new UserLesson();
    userLesson.setId("user-lesson-id");
    userLesson.setUserKey(userKey);
    userLesson.setLessonRef(Ref.create(lessonKey));
    OfyService.ofy().save().entity(userLesson).now();

    InputStream is = getClass().getResource("index.html").openStream();
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    resp.setStatus(200);
    out.write(convertStreamToString(is));
    out.close();
  }

  static String convertStreamToString(java.io.InputStream is) {
    java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
    return s.hasNext() ? s.next() : "";
  }
}
