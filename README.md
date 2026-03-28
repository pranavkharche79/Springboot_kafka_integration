# Spring Boot & Apache Kafka Integration

[![GitHub repository](https://img.shields.io/badge/GitHub-Repository-blue?logo=github)](https://github.com/pranavkharche79/Springboot_kafka_integration)

An event-driven microservices architecture integrating Apache Kafka for asynchronous messaging. This project demonstrates high-performance message streaming between decoupled Spring Boot applications.

## 🚀 Architecture

![Architecture Diagram](images/kafka-springboot-integration.png)

The system consists of two distinct microservices:

1. **Producer Microservice:** Publishes streaming data/events to a designated Kafka topic.
2. **Consumer Microservice:** Listens to the Kafka topic and processes the incoming messages asynchronously.

## ✨ Key Features & Highlights

- **Asynchronous Communication:** Enables true decoupling of services via event streams.
- **High Throughput & Reliability:** Successfully load-tested by publishing and consuming **500,000 (5 lakh) messages** without message loss or bottleneck latency.
- **Fault-Tolerant:** Leverages Kafka's distributed commit log to ensure message resilience even during consumer failures.
- **Scalable Design:** Consumer group architecture allows horizontal scaling for increased processing power.

## 🛠️ Technology Stack

- **Java**
- **Spring Boot**
- **Apache Kafka**
- **Kafka UI** (for cluster monitoring & topic management)
- **Maven**

## ⚙️ Prerequisites

- Java 17+
- Maven
- Apache Kafka & Kafka UI downloaded and extracted locally (or run via Docker).

## 🚀 Getting Started

### 1. Start Kafka Server (Windows)

Open your terminal in the Kafka installation directory and run the following commands (refer to the `windows commands for kafka start .txt` for specific paths):

```cmd
# Start Kafka Server
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

#### Run Kafka UI

To run UI for Apache Kafka, you can use either a pre-built Docker image or build it (or a jar file) yourself.

Quick start (Demo run):
```bash
docker run -it -p 8080:8080 -e DYNAMIC_CONFIG_ENABLED=true provectuslabs/kafka-ui
```
Then access the web UI at http://localhost:8080

YT video for Kafka UI connection:
[https://youtu.be/2Xwy_LZZQ9w?si=U_-kSLZlGKBN4VIW](https://youtu.be/2Xwy_LZZQ9w?si=U_-kSLZlGKBN4VIW)

### 2. Run the Microservices

Start both the Producer and Consumer microservices in separate terminals.

**Producer:**

```bash
cd producer
mvn spring-boot:run
```

**Consumer:**

```bash
cd consumer
mvn spring-boot:run
```

### 3. Testing the Integration

Once both applications are running, you can trigger the producer to send **500,000 (5 Lakh) messages** to the Kafka topic (`pranav-topic`) at once by making a single POST request.

**Endpoint details:**
- **URL:** `http://localhost:8081/kafka/message`
- **Method:** `POST`

**Example using cURL:**
```bash
curl -X POST http://localhost:8081/kafka/message
```

The consumer service (running on port `8082`) will automatically pick up these messages from the topic and log their receipt and processing in real-time.

Watch the consumer's console logs to observe the high-throughput processing power of Apache Kafka as it handles the massive event stream smoothly.

### 🎥 Demonstration

Here is a quick demonstration of the integration and high-throughput processing:

<video src="images/springboot-kafka-integration.mp4" controls="controls" style="max-width: 100%;">
  Your browser does not support the video tag.
</video>

*(If the video doesn't play directly in your viewer, you can find it in the [`images` folder](images/springboot-kafka-integration.mp4).)*
