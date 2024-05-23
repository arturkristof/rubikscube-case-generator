package io.github.arturkristof.rubikscube;

import io.github.arturkristof.rubikscube.model.Facelet;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class MissingFaceletsFinder {

    final static private Integer MAX_FACELET_COUNT = 9;

    Map<Facelet, Integer> getMissingFaceletCounts(final String facelets) {
        final var faceletsCount = new HashMap<Facelet, Integer>();
        facelets.chars().forEach(c -> {
            final var facelet = Facelet.of((char) c);
            faceletsCount.merge(facelet, 1, Integer::sum);
        });

        return faceletsCount.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(Facelet.X))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> MAX_FACELET_COUNT - entry.getValue()
                ));
    }
}
