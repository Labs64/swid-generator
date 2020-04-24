/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.labs64.utils.swid.support;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 */
public class SequentialIdGeneratorTest {

    private IdGenerator underTest;

    @BeforeClass
    public static void setup() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testNextId() {
        underTest = new SequentialIdGenerator();
        assertEquals("1", underTest.nextId());
        assertEquals("2", underTest.nextId());
        assertEquals("3", underTest.nextId());
    }

    @Test
    public void testNextIdOffset() {
        underTest = new SequentialIdGenerator(1, 10, null, null);
        assertEquals("11", underTest.nextId());
        assertEquals("21", underTest.nextId());
        assertEquals("31", underTest.nextId());
    }

    @Test
    public void testNextIdZeroOffset() {
        underTest = new SequentialIdGenerator(1, 0, null, null);
        assertEquals("1", underTest.nextId());
        assertEquals("1", underTest.nextId());
        assertEquals("1", underTest.nextId());
    }

    @Test
    public void testNextIdPrefix() {
        underTest = new SequentialIdGenerator(0, 1, "e", null);
        assertEquals("e_1", underTest.nextId());
        assertEquals("e_2", underTest.nextId());
        assertEquals("e_3", underTest.nextId());
    }

    @Test
    public void testNextIdSuffix() {
        underTest = new SequentialIdGenerator(0, 1, null, "e");
        assertEquals("1_e", underTest.nextId());
        assertEquals("2_e", underTest.nextId());
        assertEquals("3_e", underTest.nextId());
    }

}
