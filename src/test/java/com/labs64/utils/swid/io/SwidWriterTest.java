/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.labs64.utils.swid.io;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringWriter;

import org.iso.standards.iso._19770.__2._2009.schema.SoftwareIdentificationTagComplexType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 */
public class SwidWriterTest {

    private static SwidWriter underTest;

    @BeforeClass
    public static void setup() {
        underTest = new SwidWriter();
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testWriteOutputStream() {
        ByteArrayOutputStream destination = new ByteArrayOutputStream();
        underTest.write(new SoftwareIdentificationTagComplexType(), destination);
        assertTrue(destination.size() > 0);
    }

    @Test
    public void testWriteFile() {
        File destination = new File("target/regid.2010-64.com.labs64_swidlib_test.swidtag");
        underTest.write(new SoftwareIdentificationTagComplexType(), destination);
        assertTrue(destination.length() > 0);
    }

    @Test
    public void testWriteWriter() {
        StringWriter destination = new StringWriter();
        underTest.write(new SoftwareIdentificationTagComplexType(), destination);
        assertTrue(destination.toString().length() > 0);
    }

}
