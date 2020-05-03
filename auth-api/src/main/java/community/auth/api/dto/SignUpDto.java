package community.auth.api.dto;

import community.auth.model.Social;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SignUpDto implements SocialResourceRequestDto {
  private @NotNull Social.Provider provider;
  private @NotEmpty String providerAccessToken;
}
