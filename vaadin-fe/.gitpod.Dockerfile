# Use a Linux-based base image compatible with Docker Desktop for Windows
FROM ubuntu:latest

# Update package lists and install necessary tools
RUN apt-get update && apt-get install -y \
    wget \
    apt-transport-https \
    gnupg \
    curl \
    software-properties-common

# Install additional dependencies
RUN apt-get update && apt-get install -y \
    libnss3 \
    libnspr4 \
    libatk1.0-0 \
    libatk-bridge2.0-0 \
    libcups2 \
    libdrm2 \
    libxkbcommon0 \
    libxcomposite1 \
    libxdamage1 \
    libxfixes3 \
    libxrandr2 \
    libgbm1 \
    libgtk-3-0 \
    libatspi2.0-0 \
    libx11-xcb-dev

# Clean up package lists
RUN rm -rf /var/lib/apt/lists/*

# Install SDKMAN and Java
RUN curl -s "https://get.sdkman.io" | bash && \
    bash -c "source /root/.sdkman/bin/sdkman-init.sh && \
    sdk install java 17.0.8-amzn && \
    sdk default java 17.0.8-amzn"
