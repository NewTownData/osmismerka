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
import org.junit.jupiter.api.Test;

/**
 *
 * @author Voyta Krizek, https://github.com/NewTownData
 */
public class PointTest {

	@Test
	public void testOpposite1() {
		Point p = new Point(5, 5);
		Point center = new Point(4, 4);
		Point opposite = center.oppositePoint(p);
		assertEquals(new Point(3, 3), opposite);
	}

	@Test
	public void testOpposite2() {
		Point p = new Point(3, 3);
		Point center = new Point(4, 4);
		Point opposite = center.oppositePoint(p);
		assertEquals(new Point(5, 5), opposite);
	}

	@Test
	public void testOpposite3() {
		Point p = new Point(5, 3);
		Point center = new Point(4, 4);
		Point opposite = center.oppositePoint(p);
		assertEquals(new Point(3, 5), opposite);
	}

	@Test
	public void testOpposite4() {
		Point p = new Point(3, 5);
		Point center = new Point(4, 4);
		Point opposite = center.oppositePoint(p);
		assertEquals(new Point(5, 3), opposite);
	}

}
