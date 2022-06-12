package com.jd.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

import lombok.experimental.UtilityClass;

/**
 * @author Jaedoo Lee
 */
@UtilityClass
public class CollectionUtils extends org.springframework.util.CollectionUtils {

    public static <T, R> List<R> map(Collection<T> collection, Function<? super T, ? extends R> mapper) {
        return collection.stream().filter(Objects::nonNull).map(mapper).collect(Collectors.toList());
    }

    public static <T, R, E> Map<E, List<R>> mapGrouping(Collection<T> collection, Function<? super T, ? extends R> mapper, Function<? super R, ? extends E> mapper1) {
        return collection.stream().filter(Objects::nonNull).map(mapper).collect(Collectors.groupingBy(mapper1));
    }

    public static <T> T reduce(Collection<T> collection, T identity, BinaryOperator<T> accumulator) {
        return collection.stream().filter(Objects::nonNull).reduce(identity, accumulator);
    }

}
