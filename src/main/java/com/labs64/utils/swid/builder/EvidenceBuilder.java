package com.labs64.utils.swid.builder;

import org.iso.standards.iso._19770.__2._2014_dis.schema.Evidence;
import org.iso.standards.iso._19770.__2._2014_dis.schema.Meta;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.List;

import static com.labs64.utils.swid.support.JAXBUtils.convertDateToXMLGregorianCalendar;

public class EvidenceBuilder extends BaseElementBuilder<Evidence, EvidenceBuilder> {

    public EvidenceBuilder directoryOrFileOrProcess(Meta directoryOrFileOrProcess) {
        item.getDirectoryOrFileOrProcess().add(directoryOrFileOrProcess);
        return this;
    }

    public EvidenceBuilder directoryOrFileOrProcess(List<Meta> directoryOrFileOrProcess) {
        if (directoryOrFileOrProcess != null) {
            item.getDirectoryOrFileOrProcess().addAll(directoryOrFileOrProcess);
        }
        return this;
    }

    public EvidenceBuilder date(Date date) {
        return date(convertDateToXMLGregorianCalendar(date));
    }

    public EvidenceBuilder date(XMLGregorianCalendar date) {
        item.setDate(date);
        return this;
    }

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
