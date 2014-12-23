# SoftWare IDentification (SWID) Tags Generator

[![Stories in Ready](https://badge.waffle.io/labs64/swid-generator.svg?label=ready&title=Ready)](http://waffle.io/labs64/swid-generator)
[![Build Status](https://travis-ci.org/Labs64/swid-generator.svg)](https://travis-ci.org/Labs64/swid-generator)
[![Dependency Status](https://www.versioneye.com/user/projects/547b7586b22f9052cf0000f4/badge.svg?style=flat)](https://www.versioneye.com/user/projects/547b7586b22f9052cf0000f4)

Generate SoftWare IDentification (SWID) Tags according to [ISO/IEC 19770-2:2009](http://www.iso.org/iso/home/store/catalogue_tc/catalogue_detail.htm?csnumber=53670)

## Quick Start

The recommended way to get started using [`swid-generator`](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.labs64.utils%22) in your project is with a dependency management system – the Maven snippet below can be copied and pasted into your build.

```xml
<dependencies>
  <dependency>
    <groupId>com.labs64.utils</groupId>
    <artifactId>swid-generator</artifactId>
    <version>0.1.0</version>
  </dependency>
</dependencies>
```

## Examples

To generate SoftWare IDentification (SWID) Tag please use this example ([gist](https://gist.github.com/r-brown/9fe6fa117131a82ae2d9)):
```java
// prepare SWID Tag processor
SwidProcessor processor = new DefaultSwidProcessor();
((DefaultSwidProcessor) processor).setEntitlementRequiredIndicator(true)
        .setProductTitle("NetLicensing")
        .setProductVersion("2.2.0", 2, 2, 0, 0)
        .setSoftwareCreator("Labs64", "regid.2010-01.com.labs64")
        .setSoftwareLicensor("Labs64", "regid.2010-01.com.labs64")
        .setSoftwareId("NLIC", "regid.2010-01.com.labs64")
        .setTagCreator("Labs64", "regid.2010-01.com.labs64");

// create builder and pass processor as build param
SwidBuilder builder = new SwidBuilder();
SoftwareIdentificationTagComplexType swidTag = builder.build(processor);

// output resulting object
SwidWriter writer = new SwidWriter();
StringWriter out = new StringWriter();
writer.write(swidTag, out);

System.out.println(out);
```

...this generates following SoftWare IDentification (SWID) Tag:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<software_identification_tag xmlns:ns2="http://www.w3.org/2000/09/xmldsig#" xmlns="http://standards.iso.org/iso/19770/-2/2009/schema.xsd">
    <entitlement_required_indicator>true</entitlement_required_indicator>
    <product_title>NetLicensing</product_title>
    <product_version>
        <name>2.2.0</name>
        <numeric>
            <major>2</major>
            <minor>2</minor>
            <build>0</build>
            <review>0</review>
        </numeric>
    </product_version>
    <software_creator>
        <name>Labs64</name>
        <regid>regid.2010-01.com.labs64</regid>
    </software_creator>
    <software_licensor>
        <name>Labs64</name>
        <regid>regid.2010-01.com.labs64</regid>
    </software_licensor>
    <software_id>
        <unique_id>NLIC</unique_id>
        <tag_creator_regid>regid.2010-01.com.labs64</tag_creator_regid>
    </software_id>
    <tag_creator>
        <name>Labs64</name>
        <regid>regid.2010-01.com.labs64</regid>
    </tag_creator>
</software_identification_tag>
```

## Compatibility

This library is compatible with J2SE 1.6 or newer. All dependencies are handled by Maven.
