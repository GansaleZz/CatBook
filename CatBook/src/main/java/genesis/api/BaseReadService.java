package genesis.api;

import genesis.bean.GenesisBean;
import genesis.util.page.PageFilter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Default read methods of entity.
 *
 * @author GansaleZz
 */
public interface BaseReadService<T extends GenesisResponseDTO, K extends GenesisBean, S extends GenesisParametersContainer> {

    @GetMapping("/{ID}")
    EntityModel<T> findByID(@PathVariable long ID);

    @GetMapping({"/", ""})
    CollectionModel<EntityModel<T>> findAll(PageFilter pageFilter, S container, BindingResult bindingResult);
}
