jaxb-util
=========

JAXB adapter classes and other utilities

* xs:date convert to java.util.Date, and format in XML to __yyyy-MM-dd__
* xs:dateTime convert to java.util.Calendar

Maven settings.xml:

```XML
<profiles>
  <profile>
    <id>bintray</id>
    <repositories>
      <repository>
        <snapshots>
          <enabled>false</enabled>
        </snapshots>
        <id>central</id>
        <name>bintray</name>
        <url>http://dl.bintray.com/vanioinformatika/releases</url>
      </repository>
    </repositories>
    <pluginRepositories>
      <pluginRepository>
        <snapshots>
          <enabled>false</enabled>
        </snapshots>
        <id>central</id>
        <name>bintray-plugins</name>
        <url>http://dl.bintray.com/vanioinformatika/releases</url>
      </pluginRepository>
    </pluginRepositories>
  </profile>
</profiles>
<activeProfiles>
  <activeProfile>bintray</activeProfile>
</activeProfiles>
```

pom.xml:

```XML
<dependency>
    <groupId>hu.vanio.jaxb</groupId>
    <artifactId>jaxb-util</artifactId>
    <version>1.0.0</version>
</dependency>
```
