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

package org.apache.shardingsphere.infra.keygen.uuid.algorithm;

import org.apache.shardingsphere.infra.algorithm.context.AlgorithmSQLContext;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

class UUIDKeyGenerateAlgorithmTest {
    
    private final UUIDKeyGenerateAlgorithm algorithm = new UUIDKeyGenerateAlgorithm();
    
    @Test
    void assertGenerateKeys() {
        assertThat(algorithm.generateKeys(mock(AlgorithmSQLContext.class), 1).size(), is(1));
        assertThat(algorithm.generateKeys(mock(AlgorithmSQLContext.class), 1).iterator().next().length(), is(32));
    }
}