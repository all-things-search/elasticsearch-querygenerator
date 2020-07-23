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

package de.picturesafe.search.querygenerator.configuration;

import de.picturesafe.search.elasticsearch.FieldConfigurationProvider;
import de.picturesafe.search.elasticsearch.IndexPresetConfigurationProvider;
import de.picturesafe.search.elasticsearch.config.impl.StandardIndexPresetConfiguration;
import de.picturesafe.search.elasticsearch.impl.StaticFieldConfigurationProvider;
import de.picturesafe.search.elasticsearch.impl.StaticIndexPresetConfigurationProvider;
import de.picturesafe.search.spring.configuration.DefaultAggregationConfiguration;
import de.picturesafe.search.spring.configuration.DefaultClientConfiguration;
import de.picturesafe.search.spring.configuration.DefaultQueryConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Collections;

@Configuration
@Import({DefaultClientConfiguration.class, DefaultQueryConfiguration.class, DefaultAggregationConfiguration.class})
public class ElasticsearchConfiguration {

    @Bean
    IndexPresetConfigurationProvider indexPresetConfigurationProvider() {
        return new StaticIndexPresetConfigurationProvider(new StandardIndexPresetConfiguration()); // ToDo
    }

    @Bean
    FieldConfigurationProvider settingsFieldConfigurationProvider() {
        return new StaticFieldConfigurationProvider(Collections.emptyMap()); // ToDo
    }
}