# Demo App – CI/CD Pipeline with Jenkins, SonarQube, Docker & AWS EC2

This project demonstrates a complete **DevOps CI/CD Pipeline** using modern DevOps tools and automation practices.

The pipeline automates:

* Build
* Testing
* Code Quality Analysis
* Docker Image Creation
* Security Scanning
* Deployment on AWS EC2

---

# Tech Stack

| Tool        | Purpose                     |
| ----------- | --------------------------- |
| GitHub      | Source Code Management      |
| Jenkins     | CI/CD Automation            |
| Maven       | Build Tool                  |
| SonarQube   | Code Quality Analysis       |
| Trivy       | Container Security Scanning |
| Docker      | Containerization            |
| AWS EC2     | Cloud Hosting               |
| Java 17     | Runtime Environment         |
| Spring Boot | Backend Framework           |

---

# CI/CD Workflow

```text id="0a0mzw"
Developer Pushes Code to GitHub
            ↓
GitHub Webhook Triggers Jenkins
            ↓
Jenkins Pulls Latest Source Code
            ↓
Maven Builds Spring Boot Application
            ↓
SonarQube Performs Code Analysis
            ↓
Docker Builds Application Image
            ↓
Trivy Scans Docker Image
            ↓
Docker Image Pushed to DockerHub
            ↓
Application Container Deployed on AWS EC2
```

---

# Project Structure

```text id="yl7lh0"
demo-app/
│
├── src/
├── target/
├── Dockerfile
├── Jenkinsfile
├── pom.xml
└── README.md
```

---

# Jenkins Pipeline Stages

The Jenkins pipeline performs the following stages:

1. Checkout Code
2. Build Application
3. SonarQube Analysis
4. Docker Build
5. Trivy Security Scan
6. Docker Push
7. Deploy Container

---

# Prerequisites

Before running this project, ensure the following are installed:

* Java 17
* Maven
* Docker
* Jenkins
* SonarQube
* Git

---

# Build the Application

Run the following Maven command:

```bash id="91c8f0"
mvn clean package
```

Generated JAR file:

```text id="zz5a0v"
target/demo-app-0.0.1-SNAPSHOT.jar
```

---

# Run Application Locally

```bash id="p7ayll"
java -jar target/demo-app-0.0.1-SNAPSHOT.jar
```

Application URL:

```text id="u4myci"
http://localhost:8081
```

---

# Docker Commands

## Build Docker Image

```bash id="zq6gmg"
docker build -t ckshetty4/demo-app:latest .
```

## Run Docker Container

```bash id="4n03vi"
docker run -d -p 8081:8081 --name demo-app-container ckshetty4/demo-app:latest
```

---

# DockerHub Repository

Docker Image:

```text id="nh18p7"
ckshetty4/demo-app:latest
```

---

# SonarQube Analysis

Run SonarQube analysis using:

```bash id="6l8c68"
mvn sonar:sonar -Dsonar.projectKey=demo-app
```

---

# Trivy Security Scan

Run vulnerability scan:

```bash id="16fzkq"
trivy image ckshetty4/demo-app:latest
```

---

# AWS EC2 Deployment

Services hosted on EC2:

| Service         | Port |
| --------------- | ---- |
| Jenkins         | 8080 |
| SonarQube       | 9000 |
| Spring Boot App | 8081 |

---

# GitHub Webhook Integration

GitHub webhook automatically triggers Jenkins pipeline whenever code is pushed.

Webhook URL:

```text id="8o9k92"
http://<EC2-IP>:8080/github-webhook/
```

---

# Application Output

Final deployed application output:

```text id="4gwzjf"
DevOps CI/CD Pipeline is Working!
```

---

# Features Implemented

* CI/CD Pipeline Automation
* Jenkins Pipeline as Code
* GitHub Webhook Trigger
* Docker Containerization
* SonarQube Integration
* Trivy Security Scanning
* Automated Deployment on AWS EC2

---

# Challenges Solved

* Docker executable JAR issue
* GitHub authentication using PAT
* Jenkins branch configuration
* SonarQube token configuration
* DockerHub access token issue
* Webhook automation setup
* Elastic IP configuration for stable access

---

# Future Enhancements

* Kubernetes Deployment
* Helm Charts
* Prometheus Monitoring
* Grafana Dashboards
* ArgoCD GitOps
* Terraform Infrastructure Automation

---

# Author

## Chinmay K Shetty

DevOps CI/CD Pipeline Proof of Concept using Jenkins, Docker, SonarQube, Trivy & AWS EC2.

---

# License

This project is created for learning and demonstration purposes.
