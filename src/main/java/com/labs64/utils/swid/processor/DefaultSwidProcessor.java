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

import org.iso.standards.iso._19770.__2._2009.schema.EntityComplexType;
import org.iso.standards.iso._19770.__2._2009.schema.NumericVersionComplexType;
import org.iso.standards.iso._19770.__2._2009.schema.ProductVersionComplexType;
import org.iso.standards.iso._19770.__2._2009.schema.RegistrationId;
import org.iso.standards.iso._19770.__2._2009.schema.SoftwareIdComplexType;
import org.iso.standards.iso._19770.__2._2009.schema.SoftwareIdentificationTagComplexType;
import org.iso.standards.iso._19770.__2._2009.schema.Token;
import org.iso.standards.iso._19770.__2._2009.schema.UInt;

import com.labs64.utils.swid.exception.SwidException;
import com.labs64.utils.swid.support.IdGenerator;
import com.labs64.utils.swid.support.NullIdGenerator;

/**
 * Default SWID tag processor creates SWID tag with pre-defined mandatory elements.
 * 
 * @see <a href="http://www.iso.org/iso/catalogue_detail.htm?csnumber=53670">ISO/IEC 19770-2:2009</a> for guidance.
 */
public class DefaultSwidProcessor implements SwidProcessor {

    protected final SoftwareIdentificationTagComplexType swidTag;

    protected final IdGenerator idGenerator;

    /**
     * Creates SWID Tag default processor.
     */
    public DefaultSwidProcessor() {
        idGenerator = new NullIdGenerator();
        swidTag = new SoftwareIdentificationTagComplexType();
        swidTag.setId(idGenerator.nextId());
    }

    /**
     * <p>
     * Identifies whether this product needs to match up with an entitlement for a reconciliation to be considered
     * successful (tag: entitlement_required_indicator).
     * </p>
     * <p>
     * Specifies if an entitlement is required to reconcile this product. Example data format: XX = entitlement status (
     * <code>true</code> = entitlement required; <code>false</code> = no entitlement required).
     * </p>
     * 
     * @param entitlementRequiredIndicator
     *            entitlements required indicator
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setEntitlementRequiredIndicator(final boolean entitlementRequiredIndicator) {
        swidTag.setEntitlementRequiredIndicator(
                new org.iso.standards.iso._19770.__2._2009.schema.Boolean(entitlementRequiredIndicator, idGenerator
                        .nextId()));
        return this;
    }

    /**
     * <p>
     * Accurately identifies the product (tag: product_title).
     * </p>
     * 
     * @param productTitle
     *            product title
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setProductTitle(final String productTitle) {
        swidTag.setProductTitle(
                new Token(productTitle, idGenerator.nextId()));
        return this;
    }

    /**
     * Identifies the product version (tag: product_version) using two values – numeric version and version string.
     * 
     * @param productVersion
     *            product version
     * @param productVersionMajor
     *            product major version
     * @param productVersionMinor
     *            product minor version
     * @param productVersionBuild
     *            product build version
     * @param productVersionReview
     *            product review version
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setProductVersion(final String productVersion,
            final long productVersionMajor,
            final long productVersionMinor,
            final long productVersionBuild,
            final long productVersionReview) {
        final NumericVersionComplexType numericVersion = new NumericVersionComplexType(
                new UInt(productVersionMajor, idGenerator.nextId()),
                new UInt(productVersionMinor, idGenerator.nextId()),
                new UInt(productVersionBuild, idGenerator.nextId()),
                new UInt(productVersionReview, idGenerator.nextId()),
                idGenerator.nextId());
        swidTag.setProductVersion(
                new ProductVersionComplexType(
                        new Token(productVersion, idGenerator.nextId()), numericVersion, idGenerator.nextId()));
        return this;
    }

    /**
     * Identifies the creator of the software (tag: software_creator).
     * 
     * @param softwareCreatorName
     *            software creator name
     * @param softwareCreatorRegId
     *            software creator registration ID
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setSoftwareCreator(final String softwareCreatorName, final String softwareCreatorRegId) {
        swidTag.setSoftwareCreator(
                new EntityComplexType(
                        new Token(softwareCreatorName, idGenerator.nextId()),
                        new RegistrationId(softwareCreatorRegId, idGenerator.nextId()),
                        idGenerator.nextId()));
        return this;
    }

    /**
     * Identifies the licensor of the software (tag: software_licensor).
     * 
     * @param softwareLicensorName
     *            software licensor name
     * @param softwareLicensorRegId
     *            software licensor registration ID
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setSoftwareLicensor(final String softwareLicensorName,
            final String softwareLicensorRegId) {
        swidTag.setSoftwareLicensor(
                new EntityComplexType(
                        new Token(softwareLicensorName, idGenerator.nextId()),
                        new RegistrationId(softwareLicensorRegId, idGenerator.nextId()),
                        idGenerator.nextId()));
        return this;
    }

    /**
     * Identifies the specific version of a product (tag: software_id).
     * 
     * @param uniqueId
     *            software unique ID
     * @param tagCreatorRegid
     *            tag creator registration ID
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setSoftwareId(final String uniqueId, final String tagCreatorRegid) {
        swidTag.setSoftwareId(
                new SoftwareIdComplexType(
                        new Token(uniqueId, idGenerator.nextId()),
                        new RegistrationId(tagCreatorRegid, idGenerator.nextId()),
                        idGenerator.nextId()));
        return this;
    }

    /**
     * <p>
     * Identifies the tag creator (tag: tag_creator).
     * </p>
     * <p>
     * Example data format: <i>“regid.2010-04.com.labs64,NLIC”</i> where:
     * <ul>
     * <li>regid = registered id</li>
     * <li>2010-04 = the year and first month the domain was registered (yyyy-mm)</li>
     * <li>com = the upper level domain</li>
     * <li>labs64 = the domain name</li>
     * <li>NLIC = the name of the business unit (BU) that created the SWID tag</li>
     * </ul>
     * <p>
     * Note that everything after the comma ‘,’ is optional and only required if a software title is specific
     * </p>
     * 
     * @param tagCreatorName
     *            tag creator name
     * @param tagCreatorRegId
     *            tag creator registration ID
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setTagCreator(final String tagCreatorName, final String tagCreatorRegId) {
        swidTag.setTagCreator(
                new EntityComplexType(
                        new Token(tagCreatorName, idGenerator.nextId()),
                        new RegistrationId(tagCreatorRegId, idGenerator.nextId()),
                        idGenerator.nextId()));
        return this;
    }

    /**
     * Validate whether processor configuration is valid.
     * 
     * @throws com.labs64.utils.swid.exception.SwidException
     *             in case of invalid processor configuration
     */
    public void validate() {
        if (swidTag.getEntitlementRequiredIndicator() == null) {
            throw new SwidException("'entitlement_required_indicator' is not set");
        }
        if (swidTag.getProductTitle() == null) {
            throw new SwidException("'product_title' is not set");
        }
        if (swidTag.getProductVersion() == null) {
            throw new SwidException("'product_version' is not set");
        }
        if (swidTag.getSoftwareCreator() == null) {
            throw new SwidException("'software_creator' is not set");
        }
        if (swidTag.getSoftwareLicensor() == null) {
            throw new SwidException("'software_licensor' is not set");
        }
        if (swidTag.getSoftwareId() == null) {
            throw new SwidException("'software_id' is not set");
        }
        if (swidTag.getTagCreator() == null) {
            throw new SwidException("'tag_creator' is not set");
        }
    }

    @Override
    public SoftwareIdentificationTagComplexType process() {
        validate();
        return swidTag;
    }

}
