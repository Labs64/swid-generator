package com.labs64.utils.swid.builder;

import org.iso.standards.iso._19770.__2._2014_dis.schema.Directory;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Evidence;
import org.iso.standards.iso._19770.__2._2014_dis.schema.File;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Meta;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.List;

import static com.labs64.utils.swid.support.JAXBUtils.convertDateToXMLGregorianCalendar;

public class EvidenceBuilder extends BaseElementBuilder<Evidence, EvidenceBuilder> {

    /**
     * adds a {@link Directory}, {@link File} or {@link Process} object.
     *
     * @param directoryOrFileOrProcess
     * @return reference to this object
     */
    public EvidenceBuilder directoryOrFileOrProcess(Meta directoryOrFileOrProcess) {
        item.getDirectoryOrFileOrProcess().add(directoryOrFileOrProcess);
        return this;
    }

    /**
     * adds a list of {@link Directory}, {@link File} and {@link Process} objects.
     *
     * @param directoryOrFileOrProcess
     * @return reference to this object
     */
    public EvidenceBuilder directoryOrFileOrProcess(List<Meta> directoryOrFileOrProcess) {
        if (directoryOrFileOrProcess != null) {
            item.getDirectoryOrFileOrProcess().addAll(directoryOrFileOrProcess);
        }
        return this;
    }

    /**
     * Sets the value of the date property.
     *
     * @param date
     *     allowed object is
     *     {@link Date }
     *
     */
    public EvidenceBuilder date(Date date) {
        return date(convertDateToXMLGregorianCalendar(date));
    }

    /**
     * Sets the value of the date property.
     *
     * @param date
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public EvidenceBuilder date(XMLGregorianCalendar date) {
        item.setDate(date);
        return this;
    }

    /**
     * Sets the value of the deviceId property.
     *
     * @param deviceId
     *     allowed object is
     *     {@link String }
     *
     */
    public EvidenceBuilder deviceId(String deviceId) {
        item.setLang(deviceId);
        return this;
    }

    @Override
    protected void validate() {
        // Do nothing
    }

    @Override
    protected Evidence makeItem() {
        return new Evidence();
    }
}
