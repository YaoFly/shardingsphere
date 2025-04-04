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

package org.apache.shardingsphere.sql.parser.statement.core.segment.generic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.shardingsphere.sql.parser.statement.core.segment.SQLSegment;
import org.apache.shardingsphere.sql.parser.statement.core.segment.generic.bound.TableSegmentBoundInfo;
import org.apache.shardingsphere.sql.parser.statement.core.value.identifier.IdentifierValue;

import java.util.Optional;

/**
 * Owner segment.
 */
@RequiredArgsConstructor
@Getter
@Setter
public final class OwnerSegment implements SQLSegment {
    
    private final int startIndex;
    
    private final int stopIndex;
    
    private final IdentifierValue identifier;
    
    private OwnerSegment owner;
    
    private TableSegmentBoundInfo tableBoundInfo;
    
    /**
     * Get owner.
     *
     * @return owner segment
     */
    public Optional<OwnerSegment> getOwner() {
        return Optional.ofNullable(owner);
    }
    
    /**
     * Get table bound info.
     *
     * @return table bound info
     */
    public Optional<TableSegmentBoundInfo> getTableBoundInfo() {
        return Optional.ofNullable(tableBoundInfo);
    }
}
