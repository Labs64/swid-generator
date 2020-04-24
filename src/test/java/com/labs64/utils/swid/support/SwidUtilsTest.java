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

import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.labs64.utils.swid.exception.SwidException;

import static org.junit.Assert.assertEquals;

/**
 */
public class SwidUtilsTest {

    @BeforeClass
    public static void setup() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testGenerateDomainDate() throws Exception {
        String date_s = "2010-04-13 01:02:03.0";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        assertEquals("2010-04", SwidUtils.generateDomainDate(dateFormat.parse(date_s)));
    }

    @Test(expected = SwidException.class)
    public void testGenerateDomainDateNull() {
        assertEquals("regid.null.null", SwidUtils.generateDomainDate(null));
    }

    @Test
    public void testGenerateRegId() {
        assertEquals("regid.2010-04.com.labs64", SwidUtils.generateRegId("2010-04", "com.labs64"));
    }

    @Test(expected = SwidException.class)
    public void testGenerateRegIdNull() {
        assertEquals("regid.null.null", SwidUtils.generateRegId(null, null));
    }

    @Test(expected = SwidException.class)
    public void testGenerateRegIdEmpty() {
        assertEquals("regid..", SwidUtils.generateRegId("", ""));
    }

    @Test
    public void testGenerateRegIdSuffix() {
        assertEquals("regid.2010-04.com.labs64,NLIC", SwidUtils.generateRegId("2010-04", "com.labs64", "NLIC"));
    }

    @Test
    public void testGenerateSwidFileName() {
        final String regid = SwidUtils.generateRegId("2010-04", "com.labs64");
        assertEquals("regid.2010-04.com.labs64_NetLicensing-210.swidtag",
                SwidUtils.generateSwidFileName(regid, "NetLicensing", "210"));
    }

    @Test
    public void testGenerateSwidFileNameExtension() {
        final String regid = SwidUtils.generateRegId("2010-04", "com.labs64");
        assertEquals("regid.2010-04.com.labs64_NetLicensing-210.swidtag",
                SwidUtils.generateSwidFileName(regid, "NetLicensing", "210", SwidUtils.SWIDTAG_FILE_EXTENSION));
    }

    @Test
    public void testRevertDomainName() {
        assertEquals("com.labs64", SwidUtils.revertDomainName("https://www.labs64.com"));
        assertEquals("com.labs64", SwidUtils.revertDomainName("https://www.labs64.com/"));
        assertEquals("com.labs64", SwidUtils.revertDomainName("https://www.labs64.com/"));
        assertEquals("com.labs64", SwidUtils.revertDomainName("www.labs64.com"));
        assertEquals("com.labs64", SwidUtils.revertDomainName("labs64.com"));
        assertEquals("com.labs64", SwidUtils.revertDomainName("https://www.labs64.com/netlicensing"));
        assertEquals("com.labs64", SwidUtils.revertDomainName("https://www.labs64.com#netlicensing"));
        assertEquals("com.labs64", SwidUtils.revertDomainName("https://www.labs64.com?netlicensing"));
        assertEquals("io.netlicensing", SwidUtils.revertDomainName("netlicensing.io"));
        assertEquals("io.netlicensing", SwidUtils.revertDomainName("https://netlicensing.io"));
    }

    @Test(expected = SwidException.class)
    public void testRevertDomainNameNull() {
        SwidUtils.revertDomainName(null);
    }

    @Test(expected = SwidException.class)
    public void testRevertDomainNameEmpty() {
        SwidUtils.revertDomainName("");
    }

}
