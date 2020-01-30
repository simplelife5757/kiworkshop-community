package community.tag.api.dto;

import community.tag.domain.Tag;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.LinkedList;
import java.util.List;

@Getter
public class TagsRequestDto {
  private @NotEmpty List<String> names;
  private @NotEmpty String postPath;
  private @Min(1) Long postId;

  public List<Tag> createTags() {
    List<Tag> tags = new LinkedList<>();
    for (String name: names) {
      Tag tag = Tag.builder()
          .name(name)
          .postPath(postPath)
          .postId(postId).build();
      tags.add(tag);
    }
    return tags;
  }
}
