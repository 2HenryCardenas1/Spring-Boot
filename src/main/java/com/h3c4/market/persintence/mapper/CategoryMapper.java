package com.h3c4.market.persintence.mapper;

import com.h3c4.market.domain.Category;
import com.h3c4.market.persintence.entity.Categoria;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings(
            {
                    @Mapping(source = "id", target = "categoryId"),
                    @Mapping(source = "descripcion", target = "category"),
                    @Mapping(source = "estado", target = "active"),
            }
    )
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);

}
