/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.sharding.merge.dql.groupby.aggregation;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctGroupConcatAggregationUnit implements AggregationUnit {
    
    private static final String DEFAULT_SEPARATOR = ",";
    
    private final Collection<Comparable<?>> values = new HashSet<>();
    
    private String separator;
    
    public DistinctGroupConcatAggregationUnit(final String separator) {
        this.separator = separator;
    }
    
    @Override
    public void merge(final List<Comparable<?>> values) {
        if (null == values || null == values.get(0)) {
            return;
        }
        this.values.add(values.get(0));
    }
    
    @Override
    public Comparable<?> getResult() {
        if (null == separator) {
            separator = DEFAULT_SEPARATOR;
        }
        return values.stream().map(Object::toString).collect(Collectors.joining(separator));
    }
}