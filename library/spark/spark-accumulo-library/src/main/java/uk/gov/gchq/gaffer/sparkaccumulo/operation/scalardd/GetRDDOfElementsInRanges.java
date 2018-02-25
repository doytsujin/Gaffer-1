/*
 * Copyright 2016 Crown Copyright
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
package uk.gov.gchq.gaffer.sparkaccumulo.operation.scalardd;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.spark.rdd.RDD;

import uk.gov.gchq.gaffer.commonutil.pair.Pair;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.Since;
import uk.gov.gchq.gaffer.operation.graph.SeededGraphFilters;
import uk.gov.gchq.gaffer.operation.io.InputOutput;
import uk.gov.gchq.gaffer.operation.io.MultiInput;
import uk.gov.gchq.gaffer.spark.serialisation.TypeReferenceSparkImpl;

import java.util.Map;

@JsonPropertyOrder(value = {"class", "input", "view"}, alphabetic = true)
@Since(version = "1.0.0")
public class GetRDDOfElementsInRanges implements
        InputOutput<Iterable<? extends Pair<? extends ElementId, ? extends ElementId>>, RDD<Element>>,
        MultiInput<Pair<? extends ElementId, ? extends ElementId>>,
        SeededGraphFilters {

    private Iterable<? extends Pair<? extends ElementId, ? extends ElementId>> input;
    private IncludeIncomingOutgoingType inOutType;
    private View view;
    private DirectedType directedType;
    private Map<String, String> options;

    @Override
    public Iterable<? extends Pair<? extends ElementId, ? extends ElementId>> getInput() {
        return input;
    }

    @Override
    public void setInput(final Iterable<? extends Pair<? extends ElementId, ? extends ElementId>> input) {
        this.input = input;
    }

    @Override
    public TypeReference<RDD<Element>> getOutputTypeReference() {
        return new TypeReferenceSparkImpl.RDDElement();
    }

    @Override
    public IncludeIncomingOutgoingType getIncludeIncomingOutGoing() {
        return inOutType;
    }

    @Override
    public void setIncludeIncomingOutGoing(final IncludeIncomingOutgoingType inOutType) {
        this.inOutType = inOutType;
    }

    @Override
    public View getView() {
        return view;
    }

    @Override
    public void setView(final View view) {
        this.view = view;
    }

    @Override
    public DirectedType getDirectedType() {
        return directedType;
    }

    @Override
    public void setDirectedType(final DirectedType directedType) {
        this.directedType = directedType;
    }

    @Override
    public Map<String, String> getOptions() {
        return options;
    }

    @Override
    public void setOptions(final Map<String, String> options) {
        this.options = options;
    }

    @Override
    public GetRDDOfElementsInRanges shallowClone() {
        return new GetRDDOfElementsInRanges.Builder()
                .input(input)
                .inOutType(inOutType)
                .view(view)
                .directedType(directedType)
                .options(options)
                .build();
    }

    public static class Builder extends BaseBuilder<GetRDDOfElementsInRanges, Builder>
            implements InputOutput.Builder<GetRDDOfElementsInRanges, Iterable<? extends Pair<? extends ElementId, ? extends ElementId>>, RDD<Element>, Builder>,
            MultiInput.Builder<GetRDDOfElementsInRanges, Pair<? extends ElementId, ? extends ElementId>, Builder>,
            SeededGraphFilters.Builder<GetRDDOfElementsInRanges, Builder> {
        public Builder() {
            super(new GetRDDOfElementsInRanges());
        }
    }
}
