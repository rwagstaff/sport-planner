FROM ubuntu:latest
MAINTAINER Richard Wagstaff

# Install Java 
RUN apt-get update && apt-get install -y software-properties-common python-software-properties
RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections
RUN add-apt-repository ppa:webupd8team/java
RUN apt-get update && apt-get install -y oracle-java8-installer

# Define commonly used JAVA_HOME variable
#ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

RUN mkdir /usr/share/sport/

COPY /build /usr/share/sport/

RUN chmod +x /usr/share/sport/libs/*.jar

EXPOSE 8080

WORKDIR /usr/share/sport/

ENTRYPOINT ["java"]

CMD ["-jar libs/sport-planner-0.1.0.jar"]


