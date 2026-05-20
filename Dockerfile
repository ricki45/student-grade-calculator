FROM tomcat:9.0-jdk11

# Limit memory for Render's free tier (512 MB)
ENV JAVA_OPTS="-Xmx256m"

# Remove default webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your WAR file as ROOT.war (runs at root context)
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
