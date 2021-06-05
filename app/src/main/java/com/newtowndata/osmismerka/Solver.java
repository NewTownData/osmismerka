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

/**
 *
 * @author Voyta Krizek, https://github.com/NewTownData
 */
public class Solver {

	public String solve(String areaString, String dictString) {
		String[] areaRows = areaString.split("\\s");
		String[] dict = dictString.split("\\s");
		return solve(areaRows, dict);
	}

	public String solve(String[] areaRows, String[] dict) {
		char[][] area = new char[areaRows.length][];
		for (int i = 0; i < areaRows.length; i++) {
			area[i] = areaRows[i].toCharArray();
		}
		return solve(area, dict);
	}

	public String solve(char[][] area, String[] dict) {
		if (dict == null || dict.length < 1) {
			throw new IllegalArgumentException("dict");
		}

		Finder f = new Finder(area);
		for (String word : dict) {
			f.foundWord(word);
		}

		return f.createResult();
	}
}
