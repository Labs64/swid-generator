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
package com.labs64.utils.swid.processor;

import org.iso.standards.iso._19770.__2._2009.schema.AbstractComplexType;
import org.iso.standards.iso._19770.__2._2009.schema.KeywordsComplexType;
import org.iso.standards.iso._19770.__2._2009.schema.SoftwareIdentificationTagComplexType;
import org.iso.standards.iso._19770.__2._2009.schema.Token;

/**
 * Extended SWID tag processor creates SWID tag with pre-defined mandatory and some optional elements.
 * 
 * @see <a href="http://www.iso.org/iso/catalogue_detail.htm?csnumber=53670">ISO/IEC 19770-2:2009</a> for guidance.
 */
public class ExtendedSwidProcessor extends DefaultSwidProcessor {

    /**
     * Creates SWID Tag default processor.
     */
    public ExtendedSwidProcessor() {
        super();
    }

    /**
     * Defines application abstract (abstract).
     * 
     * @param abstracts
     *            product abstracts
     * @return a reference to this object.
     */
    public ExtendedSwidProcessor setAbstracts(final String... abstracts) {
        if (abstracts.length > 0) {
            for (String _abstract : abstracts) {
                AbstractComplexType act = new AbstractComplexType();
                act.setValue(_abstract);
                swidTag.getAbstract().add(act);
            }
        }
        return this;
    }

    /**
     * Defines application keywords (keywords).
     * 
     * @param keywords
     *            product keywords
     * @return a reference to this object.
     */
    public ExtendedSwidProcessor setKeywords(final String... keywords) {
        KeywordsComplexType kct = new KeywordsComplexType();
        if (keywords.length > 0) {
            for (String keyword : keywords) {
                kct.getKeyword().add(new Token(keyword, NULL_ID));
            }
        }
        swidTag.setKeywords(kct);
        return this;
    }

    /**
     * Validate whether processor configuration is valid.
     * 
     * @throws com.labs64.utils.swid.exception.SwidException
     *             in case of invalid processor configuration
     */
    public void validate() {
        super.validate();
    }

    @Override
    public SoftwareIdentificationTagComplexType process() {
        validate();
        return swidTag;
    }

}
