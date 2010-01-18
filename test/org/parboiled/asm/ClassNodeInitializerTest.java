/*
 * Copyright (C) 2009 Mathias Doenitz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.parboiled.asm;

import org.objectweb.asm.tree.MethodNode;
import static org.parboiled.test.TestUtils.assertEqualsMultiline;
import org.testng.annotations.Test;

import java.io.IOException;

public class ClassNodeInitializerTest {

    @Test
    public void test() throws IOException {
        ParserClassNode classNode = new ParserClassNode(TestParser.class);
        new ClassNodeInitializer(classNode).initialize();

        StringBuilder sb = new StringBuilder();
        for (Object method : classNode.methods) sb.append(((MethodNode) method).name).append(',');
        assertEqualsMultiline(sb.toString(), "twoActionsRule,inputLine,expression,term,factor,atom,squareRoot," +
                "parens,number,digit,whiteSpace,newline,eoi,any,empty,");
    }

}
