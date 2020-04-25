# SoftWare IDentification (SWID) Tags Generator (Java Library)

[![Build Status](https://travis-ci.org/Labs64/swid-generator.svg)](https://travis-ci.org/Labs64/swid-generator)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.labs64.utils/swid-generator/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/com.labs64.utils/swid-generator)
[![Apache License 2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://github.com/Labs64/swid-generator/blob/master/LICENSE)

Generate SoftWare IDentification (SWID) Tags according to [ISO/IEC 19770-2:2015](https://www.iso.org/standard/65666.html)

## What are SWID Tags?

SoftWare IDentification (SWID) Tags record unique information about an installed software application, including its name, edition, version, whether it’s part of a bundle and more. SWID tags support software inventory and asset management initiatives. The structure of SWID tags is specified in international standard [ISO/IEC 19770-2:2015](https://www.iso.org/standard/65666.html).

## Quick Start

The recommended way to get started using [`swid-generator`](https://maven-badges.herokuapp.com/maven-central/com.labs64.utils/swid-generator) in your project is by adding it as dependency in your build system:

Maven:
```xml
<dependencies>
  <dependency>
    <groupId>com.labs64.utils</groupId>
    <artifactId>swid-generator</artifactId>
    <version>x.y.z</version>
  </dependency>
</dependencies>
```
Gradle:
```gradle
dependencies {
    compile 'com.labs64.utils:swid-generator:x.y.z'
}
```


## Examples

To generate SoftWare IDentification (SWID) Tag ([gist](https://gist.github.com/henryean/df736f2e044c6222c3784edd02c1b91d)):
```java
// prepare SWID Tag processor
DefaultSwidProcessor processor = new DefaultSwidProcessor();
processor.setGenerator(new SequentialIdGenerator(0, 1, "e", null));
processor.setName("NetLicensing")
        .setVersion("2.1.0")
        .setVersionScheme(VersionScheme.UNKNOWN)
        .setSupplemental(true)
        .addEntity(new EntityBuilder().name("Labs64")
                .role("softwareCreator")
                .role("softwareLicensor")
                .role("tagCreator")
                .build())
        .addLink(new LinkBuilder().rel("supplemental")
                .href("swid:other-swid-tag")
                .build())
        .addMetaData(new SoftwareMetaBuilder().description("This is what it's about")
                .entitlementDataRequired(true)
                .revision("3")
                .build())
        .addEvidence(new EvidenceBuilder()
                .deviceId("123-a")
                .date(new Date())
                .directoryOrFileOrProcess(new FileBuilder()
                        .name("File.xml")
                        .size(BigInteger.TEN)
                        .version("3")
                        .build())
                .build())
        .addPayload(new PayloadBuilder()
                .directory(new DirectoryBuilder()
                        .root("/data")
                        .key(true)
                        .location("/folder")
                        .build())
                .build());
// create builder and pass processor as build param
SwidBuilder builder = new SwidBuilder();
SoftwareIdentity swidTag = builder.build(processor);
// output resulting object
SwidWriter writer = new SwidWriter();
StringWriter out = new StringWriter();
writer.write(swidTag, out);

System.out.println(out);
```

...this generates the following SoftWare IDentification (SWID) Tag:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<SoftwareIdentity name="NetLicensing" supplemental="true" tagId="e_1" version="2.1.0" versionScheme="unknown" xmlns="http://standards.iso.org/iso/19770/-2/2014-DIS/schema.xsd" xmlns:ns2="http://www.w3.org/2000/09/xmldsig#">
    <Entity name="Labs64" role="softwareCreator softwareLicensor tagCreator"/>
    <Link href="swid:other-swid-tag" rel="supplemental"/>
    <Meta description="This is what it's about" entitlementDataRequired="true" revision="3"/>
    <Evidence date="2020-04-24Z" xml:lang="123-a">
        <File name="File.xml" size="10" version="3"/>
    </Evidence>
    <Payload>
        <Directory key="true" location="/folder" root="/data"/>
    </Payload>
</SoftwareIdentity>
```

## Compatibility

This library requires J2SE 1.8 or newer. All dependencies handled by Maven.

## Links
- Spec: IT asset management — Part 2: Software Identification Tag: https://www.iso.org/standard/65666.html
- SoftWare IDentification (SWID) Tags Generator (Maven Plugin): https://github.com/Labs64/swid-maven-plugin

## Contributing

Fork the repository and make some changes. Once you're done with your changes send a pull request and check [CI validation status](https://travis-ci.org/github/Labs64/swid-generator/).
Thanks!

### Contributors and Supporters

Thank you to all the [contributors](https://github.com/Labs64/swid-generator/graphs/contributors) on this project. Your help is much appreciated!

- [Labs64 NetLicensing](https://netlicensing.io) - Innovative License Management Solution
- [GuideChimp](https://github.com/Labs64/GuideChimp) - A simple, lightweight, clean and small library for creating guided product tours for your web app.
- [@henryean](https://github.com/henryean) - Upgrade library to the next specification version [ISO/IEC 19770-2:2015](https://www.iso.org/standard/65666.html)


## Bugs and Feedback

For bugs, questions and discussions please use the [GitHub Issues](https://github.com/Labs64/swid-generator/issues).

## License

This library is open-sourced software licensed under the [Apache License 2.0](LICENSE).
