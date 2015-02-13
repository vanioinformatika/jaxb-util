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

# Add Calendar.xjb to your resources /wsdl

```XML
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<jaxb:bindings xmlns:jaxb="http://java.sun.com/xml/ns/jaxb" xmlns:xs="http://www.w3.org/2001/XMLSchema"
               xmlns:xjc="http://java.sun.com/xml/ns/jaxb/xjc" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xmlns:annox="http://annox.dev.java.net"
               xsi:schemaLocation="http://java.sun.com/xml/ns/jaxb http://java.sun.com/xml/ns/jaxb/bindingschema_2_0.xsd"
               version="2.1">
    <jaxb:globalBindings>
        <!-- Use java.util.Calendar instead of javax.xml.datatype.XMLGregorianCalendar for xs:dateTime -->
        <jaxb:javaType name="java.util.Calendar" xmlType="xs:dateTime"
                       parseMethod="javax.xml.bind.DatatypeConverter.parseDateTime"
                       printMethod="javax.xml.bind.DatatypeConverter.printDateTime" />
        <!-- Use java.util.Date instead yyyy-MM-dd format -->
        <jaxb:javaType name="java.util.Date" xmlType="xs:date"
                       printMethod="hu.vanio.jaxb.adapter.SimpleDateFormatter.print"
                       parseMethod="hu.vanio.jaxb.adapter.SimpleDateFormatter.parse"/>

    </jaxb:globalBindings>
</jaxb:bindings>
```XML

# Sample wsimport

Using jaxws-maven-plugin 

```XML
<plugin>
    <groupId>org.jvnet.jax-ws-commons</groupId>
    <artifactId></artifactId>
    <version>2.3</version>
    <dependencies>
	<dependency>
	    <groupId>javax.jws</groupId>
	    <artifactId>jsr181-api</artifactId>
	    <version>1.0-MR1</version>
	    <scope>runtime</scope>
	</dependency>
    </dependencies>
    <executions>
	<execution>
	    <goals>
		<goal>wsimport</goal>
	    </goals>
	    <configuration>
		<extension>true</extension>
		<wsdlDirectory>${basedir}/src/main/resources/wsdl</wsdlDirectory>
		<wsdlFiles>
		    <wsdlFile>YOUR.wsdl</wsdlFile>
		</wsdlFiles>
		<wsdlLocation>/wsdl/*</wsdlLocation>
		<packageName>org.sample.package</packageName>
		<sourceDestDir>${project.build.directory}/generated-sources/wspackage</sourceDestDir>
		<xjcArgs>
		    <xjcArg>-b</xjcArg>
		    <xjcArg>${basedir}/src/main/resources/wsdl/calendar.xjb</xjcArg>
		    <xjcArg>-extension</xjcArg>
		</xjcArgs>
	    </configuration>
	</execution>
    </executions>
</plugin>
  ```
