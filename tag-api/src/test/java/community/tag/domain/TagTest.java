package community.tag.domain;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

public class TagTest {
  public static Tag getTagFixture(Long id) {
    Tag tag = Tag.builder().name("name").postPath("postPath").postId(1L).build();
    ReflectionTestUtils.setField(tag, "id", id);
    return tag;
  }

  public static List<Tag> getTagsFixture(int tagNums) {
    List<Tag> tags = new ArrayList<>();
    for (int i=0; i<tagNums; i++) {
      tags.add(getTagFixture((long) i));
    }
    return tags;
  }

  @Test
  void build_ValidInput_ValidOutput() {
    // given
    Tag tag = Tag.builder()
          .name("name")
          .postPath("postPath")
          .postId(1L).build();
    // then
    then(tag).hasNoNullFieldsOrPropertiesExcept("id")
        .hasFieldOrPropertyWithValue("name","name")
        .hasFieldOrPropertyWithValue("postPath", "postPath")
        .hasFieldOrPropertyWithValue("postId", 1L);
  }

  @Test
  void build_EmptyName_ThrowException() {
    // given
    thenThrownBy(() ->
        Tag.builder()
            .name("")
            .postPath("postPath")
            .postId(1L).build()
    ).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void build_EmptyPostPath_ThrowException() {
    // given
    thenThrownBy(() ->
        Tag.builder()
            .name("name")
            .postPath("")
            .postId(1L).build()
    ).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void build_EmptyPostId_ThrowException() {
    // given
    thenThrownBy(() ->
        Tag.builder()
            .name("name")
            .postPath("postPath").build()
    ).isInstanceOf(IllegalArgumentException.class);
  }
}