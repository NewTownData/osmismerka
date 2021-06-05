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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Voyta Krizek, https://github.com/NewTownData
 */
public class AdvancedNode extends SimpleNode {

	private final int wordPosition;
	private final Node previous;

	public AdvancedNode(Point point, int wordPosition, Node previous) {
		super(point);
		this.wordPosition = wordPosition;
		this.previous = previous;
	}

	@Override
	public Node getPrevious() {
		return previous;
	}

	@Override
	public int getWordPosition() {
		return wordPosition;
	}

	@Override
	public List<Node> expand(char[][] area, char[] word) {
		if (wordPosition + 1 >= word.length) {
			throw new IllegalStateException("Out of word bounds");
		}

		Point opposite = getPoint().oppositePoint(previous.getPoint());
		List<Node> nodes = new ArrayList<>(1);
		if (opposite.getX() < 0 || opposite.getY() < 0 || opposite.getY() >= area.length
				|| opposite.getX() >= area[0].length) {
			return nodes;
		}

		if (area[opposite.getY()][opposite.getX()] == word[wordPosition + 1]) {
			nodes.add(new AdvancedNode(opposite, wordPosition + 1, this));
		}

		return nodes;
	}

	@Override
	public String toString() {
		return "AdvancedNode{" + "point=" + getPoint() + ", wordPosition=" + wordPosition
				+ ", previous=" + previous + '}';
	}

}
