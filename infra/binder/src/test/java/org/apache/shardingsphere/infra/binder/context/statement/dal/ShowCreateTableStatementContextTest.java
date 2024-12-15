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

package org.apache.shardingsphere.infra.binder.context.statement.dal;

import org.apache.shardingsphere.infra.binder.context.statement.CommonSQLStatementContext;
import org.apache.shardingsphere.sql.parser.statement.core.segment.generic.bound.TableSegmentBoundInfo;
import org.apache.shardingsphere.sql.parser.statement.core.segment.generic.table.SimpleTableSegment;
import org.apache.shardingsphere.sql.parser.statement.core.segment.generic.table.TableNameSegment;
import org.apache.shardingsphere.sql.parser.statement.core.value.identifier.IdentifierValue;
import org.apache.shardingsphere.sql.parser.statement.mysql.dal.MySQLShowCreateTableStatement;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ShowCreateTableStatementContextTest {
    
    @Test
    void assertNewInstance() {
        MySQLShowCreateTableStatement sqlStatement = new MySQLShowCreateTableStatement();
        TableNameSegment tableNameSegment = new TableNameSegment(0, 0, new IdentifierValue("foo_tbl"));
        tableNameSegment.setTableBoundInfo(new TableSegmentBoundInfo(new IdentifierValue("foo_db"), new IdentifierValue("foo_schema")));
        sqlStatement.setTable(new SimpleTableSegment(tableNameSegment));
        ShowCreateTableStatementContext actual = new ShowCreateTableStatementContext(sqlStatement);
        assertThat(actual, instanceOf(CommonSQLStatementContext.class));
        assertThat(actual.getSqlStatement(), is(sqlStatement));
        assertThat(actual.getTablesContext().getSimpleTables().stream().map(each -> each.getTableName().getIdentifier().getValue()).collect(Collectors.toList()),
                is(Collections.singletonList("foo_tbl")));
    }
}
