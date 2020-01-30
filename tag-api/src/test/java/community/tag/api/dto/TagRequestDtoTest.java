package community.tag.api.dto;

import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

public class TagRequestDtoTest {
  public static TagsRequestDto getTagsRequestDtoFixture(int tagNums) {
    List<String> tagNames= new ArrayList<>();
    for (int i=0; i<tagNums; i++) {
      String tagName = "tagName" + i;
      tagNames.add(tagName);
    }
    TagsRequestDto tagsRequestDto = new TagsRequestDto();

    ReflectionTestUtils.setField(tagsRequestDto, "names", tagNames);
    ReflectionTestUtils.setField(tagsRequestDto, "postPath", "simplelife");
    ReflectionTestUtils.setField(tagsRequestDto, "postId", 1L);

    return tagsRequestDto;
  }
}