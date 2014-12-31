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

import org.iso.standards.iso._19770.__2._2009.schema.SoftwareIdentificationTagComplexType;

/**
 * Interface for SWID Tags processors. Given source is processed and converted into the common SWID tag object
 * {@link SoftwareIdentificationTagComplexType}.
 */
public interface SwidProcessor {

    static final String NULL_ID = null;

    /**
     * Process the provided source, returning a SWID tag object.
     * 
     * @return SWID tag object.
     */
    SoftwareIdentificationTagComplexType process();

}
