package guru.seledka.toty.model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Load;
import com.googlecode.objectify.annotation.Parent;

/**
 * Created by Olga on 1/5/2015.
 */
@Entity
@Cache
public class UserLesson {
  @Id
  private String id;
  @Parent
  private Key<User> userKey;
  @Load(Lesson.class)
  private Ref<Lesson> lessonRef;
  private String notes;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Key<User> getUserKey() {
    return userKey;
  }

  public void setUserKey(Key<User> userKey) {
    this.userKey = userKey;
  }

  public Ref<Lesson> getLessonRef() {
    return lessonRef;
  }

  public void setLessonRef(Ref<Lesson> lessonRef) {
    this.lessonRef = lessonRef;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
