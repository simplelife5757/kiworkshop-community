package community.tag.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import community.tag.api.dto.TagsRequestDto;
import community.tag.service.TagService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static community.tag.api.dto.TagRequestDtoTest.getTagsRequestDtoFixture;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TagController.class)
class TagControllerTest {
  private @Autowired MockMvc mvc;
  private @MockBean TagService tagService;
  private @Autowired ObjectMapper objectMapper;

  @Test
  void createTags_ValidInput_ValidOutput() throws Exception{
    // given
    int tagNums = 2;
    List<Long> tagIds = new ArrayList<>();
    tagIds.add(1L);
    tagIds.add(2L);

    TagsRequestDto tagsRequestDto = getTagsRequestDtoFixture(tagNums);
    given(tagService.createTags(any(TagsRequestDto.class))).willReturn(tagIds);
    // then
    this.mvc.perform(post("/tags")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(tagsRequestDto)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").value(tagIds));
  }

  @Test
  void createTag_NullFields_StatusBadRequest() throws Exception{
    // given
    TagsRequestDto tagsRequestDto = new TagsRequestDto();

    // then
    this.mvc.perform(post("/tag")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(tagsRequestDto)))
        .andExpect(status().isBadRequest());
  }
}