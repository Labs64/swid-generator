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

import com.labs64.utils.swid.builder.*;
import com.labs64.utils.swid.exception.SwidException;
import com.labs64.utils.swid.support.IdGenerator;
import com.labs64.utils.swid.support.NullIdGenerator;
import org.iso.standards.iso._19770.__2._2014_dis.schema.*;
import org.w3._2000._09.xmldsig_.SignatureType;

import javax.xml.namespace.QName;
import java.math.BigInteger;
import java.util.Map;

/**
 * Default SWID tag processor creates SWID tag with pre-defined mandatory elements.
 * 
 * @see <a href="https://www.iso.org/standard/65666.html">ISO/IEC 19770-2:2015</a> for guidance.
 */
public class DefaultSwidProcessor implements SwidProcessor {

    protected final SoftwareIdentity swidTag;

    protected IdGenerator idGenerator;

    /**
     * Creates SWID Tag default processor.
     */
    public DefaultSwidProcessor() {
        swidTag = new SoftwareIdentity();
        setGenerator(new NullIdGenerator());
    }

    /**
     * Sets the value of the lang property.
     *
     * @param lang
     *     allowed object is
     *     {@link String }
     * @return a reference to this object.
     */
    public DefaultSwidProcessor lang(String lang) {
        swidTag.setLang(lang);
        return this;
    }

    /**
     * Attributes that aren't bound to any typed property on this class.
     *
     * <p>
     * the map is keyed by the name of the attribute and
     * the value is the string value of the attribute.
     * </p>
     *
     * @param key the name of the attribute {@link QName}
     * @param value the String value of the attribute
     * @return a reference to this object.
     */
    public DefaultSwidProcessor otherAttributes(QName key, String value) {
        swidTag.getOtherAttributes().put(key, value);
        return this;
    }

    /**
     * Attributes that aren't bound to any typed property on this class.
     *
     * <p>
     * the map is keyed by the name of the attribute and
     * the value is the string value of the attribute.
     * </p>
     *
     * @param otherAttributes a map containing key/value pairs of attributes to be added to the tag.
     * @return a reference to this object.
     */
    public DefaultSwidProcessor otherAttributes(Map<QName, String> otherAttributes) {
        if (otherAttributes != null) {
            swidTag.getOtherAttributes().putAll(otherAttributes);
        }
        return this;
    }

    /**
     * Set element identifier generator.
     * 
     * @param generator
     *            element identifier generator
     */
    public void setGenerator(final IdGenerator generator) {
        if (generator != null) {
            this.idGenerator = generator;
            swidTag.setTagId(idGenerator.nextId());
        }
    }

    /**
     * <p>
     * Accurately identifies the product (tag: name).
     * </p>
     * 
     * @param name
     *            product title
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setName(final String name) {
        swidTag.setName(name);
        return this;
    }

    /**
     * Identifies the product version (tag: version) using version string.
     * 
     * @param productVersion
     *            product version
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setVersion(final String productVersion) {
        swidTag.setVersion(productVersion);
        return this;
    }

    /**
     * Identifies the tag id (tag: tagId) using id string.
     *
     * @param tagId
     *            tag ID
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setTagId(final String tagId) {
        if (tagId != null) {
            swidTag.setTagId(tagId);
        }
        return this;
    }

    /**
     * Identifies the tag version (tag: tagVersion) using version int.
     *
     * @param tagVersion
     *            product version
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setTagVersion(final BigInteger tagVersion) {
        swidTag.setTagVersion(tagVersion);
        return this;
    }

    /**
     * Identifies whether the swid is corpus (tag: corpus) using boolean.
     *
     * @param corpus
     *            is corpus
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setCorpus(final Boolean corpus) {
        swidTag.setCorpus(corpus);
        return this;
    }

    /**
     * Identifies whether the swid is supplemental (tag: supplemental) using boolean.
     *
     * @param supplemental
     *            is supplemental
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setSupplemental(final Boolean supplemental) {
        swidTag.setSupplemental(supplemental);
        return this;
    }

    /**
     * Identifies whether the swid is patch (tag: patch) using boolean.
     *
     * @param patch
     *            is patch
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setPatch(final Boolean patch) {
        swidTag.setPatch(patch);
        return this;
    }

    /**
     * Identifies the Version scheme (tag: versionScheme) using {@link VersionScheme}.
     *
     * @param versionScheme
     *            {@link VersionScheme}
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setVersionScheme(VersionScheme versionScheme) {
        swidTag.setVersionScheme(versionScheme);
        return this;
    }

    /**
     * Identifies the media (tag: media) as a String.
     *
     * @param media
     *            media from the tag
     * @return a reference to this object.
     */
    public DefaultSwidProcessor setMedia(String media) {
        swidTag.setMedia(media);
        return this;
    }

    /**
     * <p>
     *     adds a {@link ResourceCollection} object to the swid tag
     * </p>
     * <p>
     *     See {@link PayloadBuilder} for generating an item
     * </p>
     *
     * @param payload
     *            {@link ResourceCollection}
     * @return a reference to this object.
     */
    public DefaultSwidProcessor addPayload(final ResourceCollection payload) {
        swidTag.getEntityOrEvidenceOrLink().add(payload);
        return this;
    }

    /**
     * <p>
     *     adds an {@link SoftwareMeta} object to the swid tag
     * </p>
     * <p>
     *     See {@link SoftwareMetaBuilder} for generating an item
     * </p>
     *
     * @param softwareMeta
     *            {@link SoftwareMeta}
     * @return a reference to this object.
     */
    public DefaultSwidProcessor addMetaData(SoftwareMeta softwareMeta) {
        swidTag.getEntityOrEvidenceOrLink().add(softwareMeta);
        return this;
    }

    /**
     * <p>
     *     adds an {@link Entity} object to the swid tag
     * </p>
     * <p>
     *     See {@link EntityBuilder} for generating an item
     * </p>
     *
     * @param entity
     *            {@link Entity}
     * @return a reference to this object.
     */
    public DefaultSwidProcessor addEntity(final Entity entity) {
        swidTag.getEntityOrEvidenceOrLink().add(entity);
        return this;
    }

    /**
     * <p>
     *     adds an {@link Evidence} object to the swid tag
     * </p>
     * <p>
     *     See {@link EvidenceBuilder} for generating an evidence object
     * </p>
     *
     * @param evidence
     *            {@link Evidence}
     * @return a reference to this object.
     */
    public DefaultSwidProcessor addEvidence(final Evidence evidence) {
        swidTag.getEntityOrEvidenceOrLink().add(evidence);
        return this;
    }

    /**
     * <p>
     *     adds an {@link Link} object to the swid tag
     * </p>
     * <p>
     *     See {@link LinkBuilder} for generating an link object
     * </p>
     *
     * @param link
     *            {@link Link}
     * @return a reference to this object.
     */
    public DefaultSwidProcessor addLink(final Link link) {
        swidTag.getEntityOrEvidenceOrLink().add(link);
        return this;
    }

    /**
     * <p>
     *     adds an {@link SignatureType} object to the swid tag
     * </p>
     *
     * @param signature
     *            {@link SignatureType}
     * @return a reference to this object.
     */
    public DefaultSwidProcessor addSignature(final SignatureType signature) {
        swidTag.getEntityOrEvidenceOrLink().add(signature);
        return this;
    }

    /**
     * Validate whether processor configuration is valid.
     * 
     * @throws com.labs64.utils.swid.exception.SwidException
     *             in case of invalid processor configuration
     */
    public void validate() {
        if (swidTag.getName() == null) {
            throw new SwidException("'product_title' is not set");
        }
        if (swidTag.getTagId() == null) {
            throw new SwidException("'tag_id' is not set");
        }
    }

    @Override
    public SoftwareIdentity process() {
        validate();
        return swidTag;
    }

}
