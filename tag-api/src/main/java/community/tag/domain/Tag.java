package community.tag.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Tag {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String postPath;
  private Long postId;

  @Builder
  private Tag(String name, String postPath, Long postId) {
    Assert.hasLength(name, "name should not be empty");
    Assert.hasLength(postPath, "postPath should not be empty");
    Assert.notNull(postId, "postId should not be null");

    this.name = name;
    this.postPath = postPath;
    this.postId = postId;
  }
}
