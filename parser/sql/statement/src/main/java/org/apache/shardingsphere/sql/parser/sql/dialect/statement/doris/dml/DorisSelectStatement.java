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

package org.apache.shardingsphere.sql.parser.sql.dialect.statement.doris.dml;

import lombok.Setter;
import org.apache.shardingsphere.sql.parser.sql.common.segment.dml.pagination.limit.LimitSegment;
import org.apache.shardingsphere.sql.parser.sql.common.segment.dml.predicate.LockSegment;
import org.apache.shardingsphere.sql.parser.sql.common.segment.generic.WindowSegment;
import org.apache.shardingsphere.sql.parser.sql.common.segment.generic.WithSegment;
import org.apache.shardingsphere.sql.parser.sql.common.segment.generic.table.SimpleTableSegment;
import org.apache.shardingsphere.sql.parser.sql.common.statement.dml.SelectStatement;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.doris.DorisStatement;

import java.util.Optional;

/**
 * Doris select statement.
 */
@Setter
public final class DorisSelectStatement extends SelectStatement implements DorisStatement {
    
    private SimpleTableSegment table;
    
    private LimitSegment limit;
    
    private LockSegment lock;
    
    private WindowSegment window;
    
    private WithSegment withSegment;
    
    /**
     * Get order by segment.
     *
     * @return order by segment
     */
    public Optional<LimitSegment> getLimit() {
        return Optional.ofNullable(limit);
    }
    
    /**
     * Get lock segment.
     *
     * @return lock segment
     */
    public Optional<LockSegment> getLock() {
        return Optional.ofNullable(lock);
    }
    
    /**
     * Get window segment.
     *
     * @return window segment
     */
    public Optional<WindowSegment> getWindow() {
        return Optional.ofNullable(window);
    }
    
    /**
     * Get simple table segment.
     *
     * @return simple table segment
     */
    public Optional<SimpleTableSegment> getTable() {
        return Optional.ofNullable(table);
    }
    
    /**
     * Get with segment.
     *
     * @return with segment.
     */
    public Optional<WithSegment> getWithSegment() {
        return Optional.ofNullable(withSegment);
    }
}
