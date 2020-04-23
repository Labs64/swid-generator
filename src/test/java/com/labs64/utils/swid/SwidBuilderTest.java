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
package com.labs64.utils.swid;

import com.labs64.utils.swid.builder.*;
import com.labs64.utils.swid.exception.SwidException;
import com.labs64.utils.swid.io.SwidWriter;
import com.labs64.utils.swid.processor.DefaultSwidProcessor;
import com.labs64.utils.swid.support.JAXBUtils;
import com.labs64.utils.swid.support.SequentialIdGenerator;
import com.labs64.utils.swid.support.SwidUtils;
import org.iso.standards.iso._19770.__2._2014_dis.schema.ObjectFactory;
import org.iso.standards.iso._19770.__2._2014_dis.schema.SoftwareIdentity;
import org.iso.standards.iso._19770.__2._2014_dis.schema.VersionScheme;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.StringWriter;
import java.math.BigInteger;
import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

//import org.iso.standards.iso._19770.__2._2009.schema.ObjectFactory;
//import org.iso.standards.iso._19770.__2._2009.schema.SoftwareIdentificationTagComplexType;

/**
 */
public class SwidBuilderTest {

    private static ObjectFactory objectFactory;

    private static SwidBuilder underTest;

    @BeforeClass
    public static void setup() {
        objectFactory = new ObjectFactory();
        underTest = new SwidBuilder();
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testBuild() {
        assertNotNull(underTest.build(() -> new SoftwareIdentity()));
    }

    @Test(expected = SwidException.class)
    public void testNullProcessor() {
        underTest.build(null);
    }

    @Test
    public void testBuildWriteToString() {
        SoftwareIdentity swidElement = underTest.build(() -> new SoftwareIdentity());
        final String out = JAXBUtils.writeObjectToString(objectFactory.createSoftwareIdentity(swidElement));
        System.out.println(out);
        assertTrue(out.contains("SoftwareIdentity"));
    }

    @Test
    public void testBuilderUseCase() {
        // prepare SWID Tag processor
        final String regid = SwidUtils.generateRegId("2010-04", "com.labs64");
        DefaultSwidProcessor processor = new DefaultSwidProcessor();
        processor.setGenerator(new SequentialIdGenerator(0, 1, "e", null));
        processor.setName("NetLicensing")
                .setVersion("2.1.0")
                .setVersionScheme(VersionScheme.UNKNOWN)
                .setSupplemental(true)
                .addEntity(new EntityBuilder().name("Labs64")
                        .role("softwareCreator")
                        .role("softwareLicensor")
                        .role("tagCreator")
                        .build())
                .addLink(new LinkBuilder().rel("supplemental")
                        .href("swid:other-swid-tag")
                        .build())
                .addMetaData(new SoftwareMetaBuilder().description("This is what it's about")
                        .entitlementDataRequired(true)
                        .revision("3")
                        .build())
                .addEvidence(new EvidenceBuilder()
                        .deviceId("123-a")
                        .date(new Date())
                        .directoryOrFileOrProcess(new FileBuilder()
                                .name("File.xml")
                                .size(BigInteger.TEN)
                                .version("3")
                                .build())
                        .build())
                .addPayload(new PayloadBuilder()
                        .directory(new DirectoryBuilder()
                                .root("/data")
                                .key(true)
                                .location("/folder")
                                .build())
                        .build());

        // create builder and pass processor as build param
        SwidBuilder builder = new SwidBuilder();
        SoftwareIdentity swidTag = builder.build(processor);

        // output resulting object
        SwidWriter writer = new SwidWriter();
        StringWriter out = new StringWriter();
        writer.write(swidTag, out);

        System.out.println(out);
    }

}
