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
package com.labs64.utils.swid.io;

import com.labs64.utils.swid.support.JAXBUtils;
import org.iso.standards.iso._19770.__2._2014_dis.schema.ObjectFactory;
import org.iso.standards.iso._19770.__2._2014_dis.schema.SoftwareIdentity;

import java.io.File;
import java.util.Date;

/**
 * A writer for SoftWare IDentification (SWID) Tags
 * {@link org.iso.standards.iso._19770.__2._2014_dis.schema.SoftwareIdentity}.
 */
public class SwidWriter {

    private static final ObjectFactory objectFactory = new ObjectFactory();

    /**
     * Write the object into an output stream.
     * 
     * @param swidTag
     *            The SWID Tag object to be written.
     * @param output
     *            SWID Tag will be added to this stream.
     * 
     * @throws com.labs64.utils.swid.exception.SwidException
     *             If any unexpected problem occurs during the writing.
     * @throws IllegalArgumentException
     *             If any of the method parameters are null
     */
    public void write(final SoftwareIdentity swidTag, final java.io.OutputStream output) {
        JAXBUtils.writeObject(objectFactory.createSoftwareIdentity(swidTag), output, getComment());
    }

    /**
     * Write the object into a file.
     * 
     * @param swidTag
     *            The root of content tree to be written.
     * @param file
     *            File to be written. If this file already exists, it will be overwritten.
     * 
     * @throws com.labs64.utils.swid.exception.SwidException
     *             If any unexpected problem occurs during the writing.
     * @throws IllegalArgumentException
     *             If any of the method parameters are null
     */
    public void write(final SoftwareIdentity swidTag, final File file) {
        JAXBUtils.writeObject(objectFactory.createSoftwareIdentity(swidTag), file, getComment());
    }

    /**
     * Write the object into a Writer.
     * 
     * @param swidTag
     *            The root of content tree to be written.
     * @param writer
     *            SWID Tag will be sent to this writer.
     * 
     * @throws com.labs64.utils.swid.exception.SwidException
     *             If any unexpected problem occurs during the writing.
     * @throws IllegalArgumentException
     *             If any of the method parameters are null
     */
    public void write(final SoftwareIdentity swidTag, final java.io.Writer writer) {
        JAXBUtils.writeObject(objectFactory.createSoftwareIdentity(swidTag), writer, getComment());
    }

    private String getComment() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("<!-- Created by:   SoftWare IDentification (SWID) Tags Generator -->").append("\n");
        sb.append("<!-- Creator URL:  http://l64.cc/swid -->").append("\n");
        sb.append("<!-- Created Date: ").append(new Date().toString()).append(" -->").append("\n");
        return sb.toString();
    }

}
