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

package org.apache.shardingsphere.data.pipeline.cdc.distsql.parser.facade;

import org.apache.shardingsphere.data.pipeline.cdc.distsql.parser.core.CDCDistSQLLexer;
import org.apache.shardingsphere.data.pipeline.cdc.distsql.parser.core.CDCDistSQLParser;
import org.apache.shardingsphere.data.pipeline.cdc.distsql.parser.core.CDCDistSQLStatementVisitor;
import org.apache.shardingsphere.distsql.parser.engine.spi.DistSQLParserFacade;
import org.apache.shardingsphere.sql.parser.api.ASTNode;
import org.apache.shardingsphere.sql.parser.api.parser.SQLLexer;
import org.apache.shardingsphere.sql.parser.api.parser.SQLParser;
import org.apache.shardingsphere.sql.parser.api.visitor.SQLVisitor;

/**
 * CDC DistSQL parser facade.
 */
public final class CDCDistSQLParserFacade implements DistSQLParserFacade {
    
    @Override
    public Class<? extends SQLLexer> getLexerClass() {
        return CDCDistSQLLexer.class;
    }
    
    @Override
    public Class<? extends SQLParser> getParserClass() {
        return CDCDistSQLParser.class;
    }
    
    @Override
    public Class<? extends SQLVisitor<ASTNode>> getVisitorClass() {
        return CDCDistSQLStatementVisitor.class;
    }
    
    @Override
    public String getType() {
        return "CDC";
    }
}