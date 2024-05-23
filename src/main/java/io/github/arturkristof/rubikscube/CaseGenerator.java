package io.github.arturkristof.rubikscube;

import io.github.arturkristof.rubikscube.model.Facelet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CaseGenerator {

    public List<Facelet> searchCases(final String facelets) {
        final var missingFaceletsFinder = new MissingFaceletsFinder();
        final var missingFaceletCounts = missingFaceletsFinder.getMissingFaceletCounts(facelets);
        final var missingFacelets = listMissingFacelets(missingFaceletCounts);

        return Collections.emptyList();
    }

    private List<Facelet> listMissingFacelets(final Map<Facelet, Integer> missingFaceletCounts) {
        final var missingFacelets = new ArrayList<Facelet>();
        missingFaceletCounts.forEach((key, value) -> {
            for (var i = 0; i < value; ++i) {
                missingFacelets.add(key);
            }
        });
        return missingFacelets;
    }
}
