package genesis.util.page;

import genesis.util.constant.GenesisConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 *
 *
 * @author GansaleZz
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageFilter {

    @NotNull
    @Builder.Default
    private int page = 0;

    @NotNull
    @Builder.Default
    private int items = GenesisConstants.INTEGER_MAX;

    private long count;
}