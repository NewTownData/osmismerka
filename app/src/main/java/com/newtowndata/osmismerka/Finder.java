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
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Voyta Krizek, https://github.com/NewTownData
 */
public class Finder {

	private final char[][] area;
	private final boolean[][] usedFields;
	private final LinkedList<Node> openList = new LinkedList<>();

	public Finder(char[][] area) {
		validateArea(area);
		this.area = area;

		this.usedFields = new boolean[area.length][];
		for (int i = 0; i < area.length; i++) {
			this.usedFields[i] = new boolean[area[i].length];
		}
	}

	private void validateArea(char[][] area) {
		if (area == null || area.length < 1) {
			throw new IllegalArgumentException("area");
		}

		int len = area[0].length;
		for (int i = 1; i < area.length; i++) {
			if (len != area[i].length) {
				throw new IllegalArgumentException("area is not rectangular!");
			}
		}
	}

	public void foundWord(String word) {
		List<Node> inits = findInits(word.charAt(0));
		for (Node init : inits) {
			if (findString(init, word)) {
				return;
			}
		}
		throw new IllegalStateException("No string found for word '" + word + "'");
	}

	private List<Node> findInits(char c) {
		List<Node> inits = new ArrayList<>();
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[i].length; j++) {
				if (area[i][j] == c) {
					inits.add(new SimpleNode(new Point(j, i)));
				}
			}
		}
		return inits;
	}

	public String createResult() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[i].length; j++) {
				if (!usedFields[i][j]) {
					sb.append(area[i][j]);
				}
			}
		}
		return sb.toString();
	}

	private boolean findString(Node init, String word) {
		char[] wordChars = word.toCharArray();
		openList.clear();
		openList.add(init);
		while (!openList.isEmpty()) {
			Node n = openList.removeFirst();
			List<Node> expanded = n.expand(area, wordChars);
			for (Node expandedNode : expanded) {
				if (expandedNode.getWordPosition() == wordChars.length - 1) { // result
					fillUsedFields(expandedNode);
					return true;
				}
				openList.addFirst(expandedNode);
			}
		}
		return false;
	}

	private void fillUsedFields(Node expandedNode) {
		while (expandedNode != null) {
			Point pt = expandedNode.getPoint();
			usedFields[pt.getY()][pt.getX()] = true;
			expandedNode = expandedNode.getPrevious();
		}
	}

}
