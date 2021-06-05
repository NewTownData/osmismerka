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
public class SimpleNode implements Node {

	private final Point point;

	public SimpleNode(Point point) {
		this.point = point;
	}

	@Override
	public Point getPoint() {
		return point;
	}

	@Override
	public int getWordPosition() {
		return 0;
	}

	@Override
	public Node getPrevious() {
		return null;
	}

	@Override
	public List<Node> expand(char[][] area, char[] word) {
		if (1 >= word.length) {
			throw new IllegalStateException("Out of word bounds");
		}

		char c = word[1];
		List<Node> nodes = new ArrayList<>();
		for (int i = Math.max(point.getY() - 1, 0); i < Math.min(point.getY() + 2, area.length); i++) {
			for (int j = Math.max(point.getX() - 1, 0); j < Math.min(point.getX() + 2,
					area[i].length); j++) {
				if (i == point.getY() && j == point.getX()) {
					continue;
				}
				if (area[i][j] == c) {
					nodes.add(new AdvancedNode(new Point(j, i), 1, this));
				}
			}
		}
		return nodes;
	}

	@Override
	public String toString() {
		return "SimpleNode{" + "point=" + point + '}';
	}

}
