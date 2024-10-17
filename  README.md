
# CamelConnect

**CamelConnect** — bu Apache Camel, Apache Kafka va Hawtio yordamida integratsiyalashgan xizmatlar to'plami. Ushbu loyiha foydalanuvchilar, to'lovlar va xabarlar o'rtasida samarali ma'lumot almashish imkoniyatini taqdim etadi.

## Texnologiyalar

- **Spring Boot**: Java asosida tez va oson web ilovalar yaratishga yordam beruvchi freymvork.
- **Apache Camel**: Tizimlar o'rtasida integratsiyani osonlashtiruvchi mashhur dasturiy kutubxona.
- **Apache Kafka**: Oqim ma'lumotlari va voqealarni boshqarish uchun kuchli va samarali platforma.
- **Hawtio**: Java dasturlarini boshqarish va monitoring qilish uchun web interfeys.

## Loyiha Tuzilishi

Ushbu loyiha 3 ta asosiy xizmatdan iborat:

1. **User Service**: Foydalanuvchi ma'lumotlarini boshqaradi.
2. **Payment Service**: To'lovlarni boshqaradi va foydalanuvchi ma'lumotlarini oladi.
3. **Notification Service**: Foydalanuvchilarga xabarlar yuboradi.

## O'rnatish

### Talablar

- JDK 17 yoki undan yuqori versiya
- Maven
- Docker va Docker Compose

### 1. Docker Compose bilan Kafka va Zookeeper o'rnatish

Docker Compose faylini yaratib, quyidagi tarkibni qo'shing:

```yaml
version: '3'
services:
  zookeeper:
    image: wurstmeister/zookeeper
    ports:
      - "2181:2181"

  kafka:
    image: wurstmeister/kafka
    ports:
      - "9092:9092"
    environment:
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
      KAFKA_BROKER_ID: 1
```

Keyin Docker Compose'ni ishga tushiring:

```bash
docker-compose up -d
```

### 2. Loyiha manzilini klonlash

```bash
git clone https://github.com/username/camelconnect.git
cd camelconnect
```

### 3. Har bir xizmatni o'rnatish

Har bir xizmat uchun quyidagi buyruqni bajarish:

```bash
cd user-service
mvn spring-boot:run
```

```bash
cd payment-service
mvn spring-boot:run
```

```bash
cd notification-service
mvn spring-boot:run
```

## Foydalanish

1. **Foydalanuvchi yaratish**: User Service ga POST so'rovi yuboring:

```bash
curl -X POST http://localhost:8081/users -H "Content-Type: application/json" -d '{"name": "John Doe", "email": "john.doe@example.com"}'
```

2. **To'lovni amalga oshirish**: Payment Service ga POST so'rovi yuboring:

```bash
curl -X POST http://localhost:8082/payments/process -H "Content-Type: application/json" -d '{"amount": 100, "currency": "USD"}'
```

3. **Xabar yuborish**: Notification Service ga POST so'rovi yuboring:

```bash
curl -X POST http://localhost:8083/notifications -H "Content-Type: application/json" -d '{"message": "Welcome to CamelConnect!"}'
```

## Monitoring

Hawtio yordamida xizmatlarni monitoring qilish uchun brauzeringizda quyidagi manzilga o'ting:

```
http://localhost:8080
```

## Mualliflar

- [Ixtiyor](https://github.com/ixtiyorxaitov)

## Licensiya

Bu loyiha [MIT License](LICENSE) ostida.

## Qo'shimcha Ma'lumot

Ushbu loyiha haqida batafsil ma'lumot va qo'llanmalar uchun [Wiki](https://github.com/username/camelconnect/wiki) sahifasiga o'ting.
