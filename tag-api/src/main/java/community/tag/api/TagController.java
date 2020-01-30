package community.tag.api;

import community.tag.api.dto.TagsRequestDto;
import community.tag.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/tags")
public class TagController {
  private final TagService tagService;

  @PostMapping
  public List<Long> create(@RequestBody @Valid TagsRequestDto tagsRequestDto) {
    return tagService.createTags(tagsRequestDto);
  }
}
