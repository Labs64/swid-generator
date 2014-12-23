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

import org.iso.standards.iso._19770.__2._2009.schema.ObjectFactory;
import org.iso.standards.iso._19770.__2._2009.schema.SoftwareIdentificationTagComplexType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.labs64.utils.swid.exception.SwidException;
import com.labs64.utils.swid.processor.SwidProcessor;
import com.labs64.utils.swid.support.JAXBUtils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
        assertNotNull(underTest.build(new SwidProcessor() {
            @Override
            public SoftwareIdentificationTagComplexType process() {
                return new SoftwareIdentificationTagComplexType();
            }
        }));
    }

    @Test(expected = SwidException.class)
    public void testNullProcessor() {
        underTest.build(null);
    }

    @Test
    public void testBuildWriteToString() {
        SoftwareIdentificationTagComplexType swidElement = underTest.build(new SwidProcessor() {
            @Override
            public SoftwareIdentificationTagComplexType process() {
                return new SoftwareIdentificationTagComplexType();
            }
        });
        final String out = JAXBUtils.writeObjectToString(objectFactory.createSoftwareIdentificationTag(swidElement));
        System.out.println(out);
        assertTrue(out.contains("software_identification_tag"));
    }

}
