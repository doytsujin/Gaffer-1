/*
 * Copyright 2017 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.gov.gchq.gaffer.data.graph.function.walk;

import com.google.common.collect.Iterables;

import uk.gov.gchq.gaffer.data.graph.Walk;
import uk.gov.gchq.koryphe.function.KorypheFunction;

/**
 * An {@code ExtractWalkVertex} is a utility {@link KorypheFunction},
 * for simplifying the extraction of the starting Vertex from a {@link Walk} object.
 */
public class ExtractWalkVertex extends KorypheFunction<Walk, Object> {
    @Override
    public Object apply(final Walk walk) {
        if (null == walk) {
            throw new IllegalArgumentException("Walk cannot be null");
        }
        return Iterables.get(walk.getEntities().get(0), 0).getVertex();
    }
}
