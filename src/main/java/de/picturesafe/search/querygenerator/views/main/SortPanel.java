/*
 * Copyright 2020 picturesafe media/data/bank GmbH
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

package de.picturesafe.search.querygenerator.views.main;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import de.picturesafe.search.elasticsearch.config.FieldConfiguration;
import de.picturesafe.search.parameter.SortOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SortPanel extends HorizontalLayout {

    private final List<? extends FieldConfiguration> fieldConfigurations;
    private final List<SortOptionPanel> sortOptionPanels = new ArrayList<>();
    private final Button addButton;

    public SortPanel(List<? extends FieldConfiguration> fieldConfigurations) {
        this.fieldConfigurations = fieldConfigurations;
        addSortOptionPanel();

        addButton = new Button(VaadinIcon.PLUS.create());
        addButton.addClickListener(e -> addSortOptionPanel());
        add(addButton);
        setVerticalComponentAlignment(Alignment.END, addButton);
    }

    private void addSortOptionPanel() {
        final SortOptionPanel sortOptionPanel = new SortOptionPanel(fieldConfigurations);
        addComponentAtIndex(sortOptionPanels.size(), sortOptionPanel);
        sortOptionPanels.add(sortOptionPanel);

        if (sortOptionPanels.size() == 4) {
            addButton.setEnabled(false);
        }
    }

    public List<SortOption> getSortOptions() {
        return sortOptionPanels.stream().map(SortOptionPanel::getSortOption).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
