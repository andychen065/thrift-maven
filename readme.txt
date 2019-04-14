rmdir /s/q gen-java
thrift --gen <language> <Thrift filename>

thrift -r --gen cpp calc.thrift
thrift -r --gen java tutorial.thrift

<dependency>
  <groupId>org.apache.thrift</groupId>
  <artifactId>libthrift</artifactId>
  <version>0.8.0</version>
</dependency>
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-log4j12</artifactId>
  <version>1.6.1</version>
</dependency>