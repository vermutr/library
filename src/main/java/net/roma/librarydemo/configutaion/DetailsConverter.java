package net.roma.librarydemo.configutaion;

import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DetailsConverter {

    private final MapperFactory mapperFactory;

    public <T> T convert(final Object from, final Class<T> to) {
        mapperFactory.classMap(from.getClass(), to).byDefault();
        return mapperFactory.getMapperFacade().map(from, to);
    }

    public <T> List<T> convertList(final List<?> from, final Class<T> to) {
        mapperFactory.classMap(from.getClass(), to).byDefault();
        return mapperFactory.getMapperFacade().mapAsList(from, to);
    }
}