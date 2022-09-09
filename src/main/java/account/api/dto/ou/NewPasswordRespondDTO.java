package account.api.dto.ou;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class NewPasswordRespondDTO {
    private String email;
    private String status;
}
