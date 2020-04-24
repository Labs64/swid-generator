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
package com.labs64.utils.swid.processor;

import com.labs64.utils.swid.builder.EntityBuilder;
import com.labs64.utils.swid.exception.SwidException;
import com.labs64.utils.swid.support.JAXBUtils;
import com.labs64.utils.swid.support.SequentialIdGenerator;
import com.labs64.utils.swid.support.SwidUtils;
import org.iso.standards.iso._19770.__2._2014_dis.schema.ObjectFactory;
import org.iso.standards.iso._19770.__2._2014_dis.schema.SoftwareIdentity;
import org.iso.standards.iso._19770.__2._2014_dis.schema.VersionScheme;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 */
public class DefaultSwidProcessorTest {

    private static ObjectFactory objectFactory;

    private DefaultSwidProcessor underTest;

    @BeforeClass
    public static void setup() {
        objectFactory = new ObjectFactory();
    }

    @Before
    public void setUp() {
        underTest = new DefaultSwidProcessor();
    }

    @Test(expected = SwidException.class)
    public void testProcessorEmpty() {
        underTest.process();
    }

    @Test(expected = SwidException.class)
    public void testProcessorIncomplete() {
        underTest.setName("NetLicensing");
        underTest.process();
    }

    @Test
    public void testProcessorFull() {
        underTest.setGenerator(new SequentialIdGenerator());
        final String regid = SwidUtils.generateRegId("2010-04", "com.labs64");
        underTest.setName("NetLicensing")
                .setVersion("2.1.0")
                .addEntity(new EntityBuilder().name("Labs64")
                        .role("softwareCreator")
                        .role("softwareLicensor")
                        .role("tagCreator")
                        .build())
                .setVersionScheme(VersionScheme.UNKNOWN);

        SoftwareIdentity swidElement = underTest.process();
        assertNotNull(swidElement);
        final String out = JAXBUtils.writeObjectToString(objectFactory.createSoftwareIdentity(swidElement));
        System.out.println(out);
    }

}
