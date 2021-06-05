/**
 * Copyright 2021 Voyta Krizek, https://github.com/NewTownData
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.newtowndata.osmismerka;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Voyta Krizek, https://github.com/NewTownData
 */
public class NodeTest {

	@Test
	public void testExpand() {
		char[][] area =
				{{'a', 'b', 'c', 'd'}, {'e', 'f', 'g', 'h'}, {'i', 'j', 'k', 'l'}, {'m', 'n', 'o', 'p'}};

		Node n = new SimpleNode(new Point(1, 1));
		List<Node> expanded = n.expand(area, new char[] {'f', 'g', 'h'});
		assertEquals(new Point(2, 1), expanded.get(0).getPoint());
		assertEquals(1, expanded.get(0).getWordPosition());
		assertEquals(new Point(1, 1), expanded.get(0).getPrevious().getPoint());

	}

}
