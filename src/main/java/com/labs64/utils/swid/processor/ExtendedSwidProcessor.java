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

import java.util.Date;

import org.iso.standards.iso._19770.__2._2009.schema.AbstractComplexType;
import org.iso.standards.iso._19770.__2._2009.schema.DateTime;
import org.iso.standards.iso._19770.__2._2009.schema.KeywordsComplexType;
import org.iso.standards.iso._19770.__2._2009.schema.SoftwareIdentificationTagComplexType;
import org.iso.standards.iso._19770.__2._2009.schema.SupportedLanguagesComplexType;
import org.iso.standards.iso._19770.__2._2009.schema.Token;

import com.labs64.utils.swid.support.JAXBUtils;

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
     * Defines product abstract (tag: abstract).
     * 
     * @param abstractList
     *            product abstracts
     * @return a reference to this object.
     */
    public ExtendedSwidProcessor setAbstract(final String... abstractList) {
        if (abstractList.length > 0) {
            for (String _abstract : abstractList) {
                AbstractComplexType act = new AbstractComplexType();
                act.setValue(_abstract);
                swidTag.getAbstract().add(act);
            }
        }
        return this;
    }

    /**
     * Defines product keywords (tag: keywords).
     * 
     * @param keywordList
     *            product keywords
     * @return a reference to this object.
     */
    public ExtendedSwidProcessor setKeywords(final String... keywordList) {
        KeywordsComplexType kct = new KeywordsComplexType();
        if (keywordList.length > 0) {
            for (String keyword : keywordList) {
                kct.getKeyword().add(new Token(keyword, idGenerator.nextId()));
            }
        }
        swidTag.setKeywords(kct);
        return this;
    }

    /**
     * Defines product data source (tag: data_source).
     * 
     * @param dataSource
     *            product data source
     * @return a reference to this object.
     */
    public ExtendedSwidProcessor setDataSource(final String dataSource) {
        swidTag.setDataSource(new Token(dataSource, idGenerator.nextId()));
        return this;
    }

    /**
     * Defines product family (tag: product_family).
     * 
     * @param productFamily
     *            product family
     * @return a reference to this object.
     */
    public ExtendedSwidProcessor setProductFamily(final String productFamily) {
        swidTag.setProductFamily(new Token(productFamily, idGenerator.nextId()));
        return this;
    }

    /**
     * Defines product identifiers (tag: product_id).
     * 
     * @param productIdList
     *            product identifiers
     * @return a reference to this object.
     */
    public ExtendedSwidProcessor setProductId(final String... productIdList) {
        if (productIdList.length > 0) {
            for (String productId : productIdList) {
                swidTag.getProductId().add(new Token(productId, idGenerator.nextId()));
            }
        }
        return this;
    }

    /**
     * Defines product release date (tag: release_date).
     * 
     * @param releaseDate
     *            product release date
     * @return a reference to this object.
     */
    public ExtendedSwidProcessor setReleaseDate(final Date releaseDate) {
        swidTag.setReleaseDate(new DateTime(JAXBUtils.convertDateToXMLGregorianCalendar(releaseDate), idGenerator
                .nextId()));
        return this;
    }

    /**
     * Defines product release identifier (tag: release_id).
     * 
     * @param releaseId
     *            product release identifier
     * @return a reference to this object.
     */
    public ExtendedSwidProcessor setReleaseId(final String releaseId) {
        swidTag.setReleaseId(new Token(releaseId, idGenerator.nextId()));
        return this;
    }

    /**
     * Defines product serialNumber (tag: serial_number).
     * 
     * @param serialNumber
     *            product serialNumber
     * @return a reference to this object.
     */
    public ExtendedSwidProcessor setSerialNumber(final String serialNumber) {
        swidTag.setSerialNumber(new Token(serialNumber, idGenerator.nextId()));
        return this;
    }

    /**
     * Defines product stock keeping unit (tag: sku).
     * 
     * @param sku
     *            product stock keeping unit
     * @return a reference to this object.
     */
    public ExtendedSwidProcessor setSku(final String sku) {
        swidTag.setSku(new Token(sku, idGenerator.nextId()));
        return this;
    }

    /**
     * Defines product supported languages (tag: supported_languages).
     * 
     * @param supportedLanguagesList
     *            product supported languages
     * @return a reference to this object.
     */
    public ExtendedSwidProcessor setSupportedLanguages(final String... supportedLanguagesList) {
        SupportedLanguagesComplexType slct = new SupportedLanguagesComplexType();
        if (supportedLanguagesList.length > 0) {
            for (String supportedLanguage : supportedLanguagesList) {
                slct.getLanguage().add(new Token(supportedLanguage, idGenerator.nextId()));
            }
        }
        swidTag.setSupportedLanguages(slct);
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
