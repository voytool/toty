package guru.seledka.toty.dao;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import guru.seledka.toty.model.Lesson;
import guru.seledka.toty.model.User;
import guru.seledka.toty.model.UserLesson;

/**
 * Created by Olga on 1/5/2015.
 */
public class OfyService {
  static {
    factory().register(User.class);
    factory().register(Lesson.class);
    factory().register(UserLesson.class);
  }

  public static Objectify ofy() {
    return ObjectifyService.ofy();
  }

  public static ObjectifyFactory factory() {
    return ObjectifyService.factory();
  }
}
