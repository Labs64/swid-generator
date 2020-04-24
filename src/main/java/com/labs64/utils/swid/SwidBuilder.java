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
package com.labs64.utils.swid;

import com.labs64.utils.swid.exception.SwidException;
import com.labs64.utils.swid.processor.SwidProcessor;
import org.iso.standards.iso._19770.__2._2014_dis.schema.SoftwareIdentity;

/**
 * A builder for creating a SoftWare IDentification (SWID) Tags {@link SoftwareIdentity}.
 */
public final class SwidBuilder {

    /**
     * Build SoftWare IDentification (SWID) Tag.
     * 
     * @param processor
     *            {@link SwidProcessor} implementation
     * @throws SwidException
     * @return SoftWare IDentification (SWID) Tag {@link SoftwareIdentity} object
     */
    public SoftwareIdentity build(final SwidProcessor processor) {
        if (processor == null) {
            throw new SwidException("processor is null");
        }
        return processor.process();
    }

}
