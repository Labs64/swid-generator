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

import com.labs64.utils.swid.exception.SwidException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Support class provides convenient methods for working with SWID entities.
 */
public final class SwidUtils {

    public static final String SWIDTAG_FILE_EXTENSION = "swidtag";
    private static final String DELIMITER = ".";

    /**
     * Generate domain date in format <code>'yyyy-MM'</code>.
     * 
     * @param domainDate
     *            the domain date
     * @return generated domain date in format <code>'yyyy-MM'</code>; e.g. <code>'2010-04'</code>
     */
    public static String generateDomainDate(final Date domainDate) {
        if (domainDate == null) {
            throw new SwidException("domainDate isn't defined");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        return dateFormat.format(domainDate);
    }

    /**
     * Generate RegId.
     * 
     * @param domainCreationDate
     *            the date at which the item creating the regid first owned the domain that is also used in the regid
     *            in year-month format; e.g. 2010-04
     * @param reverseDomainName
     *            the domain of the item, in reverse order; e.g. com.labs64
     * @return generated RegId
     */
    public static String generateRegId(final String domainCreationDate, final String reverseDomainName) {
        return generateRegId(domainCreationDate, reverseDomainName, null);
    }

    /**
     * Generate RegId with additional suffix.
     * 
     * @param domainCreationDate
     *            the date at which the item creating the regid first owned the domain that is also used in the regid
     *            in year-month format; e.g. 2010-04
     * @param reverseDomainName
     *            the domain of the item, in reverse order; e.g. com.labs64
     * @param suffix
     *            additional sub-entities that are added as a suffix to the RegId
     * @return generated RegId
     */
    public static String generateRegId(final String domainCreationDate, final String reverseDomainName,
            final String suffix) {
        if (StringUtils.isBlank(domainCreationDate)) {
            throw new SwidException("domainCreationDate isn't defined");
        }
        if (StringUtils.isBlank(reverseDomainName)) {
            throw new SwidException("reverseDomainName isn't defined");
        }

        StringBuilder res = new StringBuilder()
                .append("regid")
                .append(DELIMITER)
                .append(domainCreationDate)
                .append(DELIMITER)
                .append(reverseDomainName);
        if (StringUtils.isNotBlank(suffix)) {
            res.append(",").append(suffix);
        }

        return res.toString();
    }

    /**
     * <p>
     * Generate SWID tag file name.
     * </p>
     * <p>
     * Example: <code>&lt;regid&gt;_&lt;product_name&gt;‐&lt;unique_software_identifier&gt;.swidtag</code>
     * </p>
     * 
     * @param regId
     *            the regid value
     * @param productName
     *            the product name
     * @param uniqueSoftwareId
     *            the unique software identifier
     * @return SWID tag file name
     */
    public static String generateSwidFileName(final String regId, final String productName,
            final String uniqueSoftwareId) {
        return generateSwidFileName(regId, productName, uniqueSoftwareId, null);
    }

    /**
     * <p>
     * Generate SWID tag file name.
     * </p>
     * <p>
     * Example: <code>&lt;regid&gt;_&lt;product_name&gt;‐&lt;unique_software_identifier&gt;.swidtag</code>
     * </p>
     * 
     * @param regId
     *            the regid value
     * @param productName
     *            the product name
     * @param uniqueSoftwareId
     *            the unique software identifier
     * @param extension
     *            file extension; if not defined the default file extension will be used: <i>.swidtag</i>
     * @return SWID tag file name
     */
    public static String generateSwidFileName(final String regId, final String productName,
            final String uniqueSoftwareId, final String extension) {
        StringBuilder res = new StringBuilder()
                .append(regId)
                .append("_")
                .append(productName)
                .append("-")
                .append(uniqueSoftwareId).append(".");
        if (StringUtils.isNotBlank(extension)) {
            res.append(extension);
        } else {
            res.append(SWIDTAG_FILE_EXTENSION);
        }

        return res.toString();
    }

    /**
     * <p>
     * Revert given URL according to the <a href="http://en.wikipedia.org/wiki/Reverse_domain_name_notation">Reverse
     * domain name notation</a>
     * </p>
     * <p>
     * 
     * @see <a
     *      href="http://en.wikipedia.org/wiki/Reverse_domain_name_notation">http://en.wikipedia.org/wiki/Reverse_domain_name_notation</a>
     *      </p>
     * 
     * @param domainName
     *            the domain name to be reverted
     * @return reverted domain name
     */
    public static String revertDomainName(final String domainName) {
        if (StringUtils.isBlank(domainName)) {
            throw new SwidException("domainName isn't defined");
        }

        try {
            URI uri = new URI(StringUtils.prependIfMissing(domainName, "http://", "https://"));
            String hostName = StringUtils.removeStart(uri.getHost(), "www.");

            String[] domainNameSplit = StringUtils.split(hostName, ".");
            CollectionUtils.reverseArray(domainNameSplit);
            return StringUtils.join(domainNameSplit, ".");
        } catch (URISyntaxException e) {
            throw new SwidException("Cannot revert domain name");
        }
    }

}
