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
package com.labs64.utils.swid.io;

import com.labs64.utils.swid.support.SwidUtils;
import org.iso.standards.iso._19770.__2._2014_dis.schema.SoftwareIdentity;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringWriter;

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
        underTest.write(new SoftwareIdentity(), destination);
        assertTrue(destination.size() > 0);
    }

    @Test
    public void testWriteFile() {
        final String regid = SwidUtils.generateRegId("2010-04", "com.labs64");
        final String tagFile = SwidUtils.generateSwidFileName(regid, "NetLicensing", "210");
        File destination = new File("target/" + tagFile);
        underTest.write(new SoftwareIdentity(), destination);
        assertTrue(destination.length() > 0);
    }

    @Test
    public void testWriteWriter() {
        StringWriter destination = new StringWriter();
        underTest.write(new SoftwareIdentity(), destination);
        assertTrue(destination.toString().length() > 0);
    }

}
