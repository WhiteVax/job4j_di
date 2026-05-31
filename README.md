## job4j_di

Ознакомление с Spring DI.

---

### Стэк технологий

![java](https://img.shields.io/badge/java-21-red)![Maven](https://img.shields.io/badge/Maven-4.0.0-red)
![java](https://img.shields.io/badge/SpringContext-5.3.3-green)![Maven](https://img.shields.io/badge/SpringBeans-5.3.3-green)
![java](https://img.shields.io/badge/SpringCore-5.3.3-green)

### 🐳 Сборка и запуск

### 1. Сборка образа

```bash
docker build -t job4j_di .
```
### 2. Запуск контейнера

```bash
docker run -it --name job4j_di job4j_di
```

### 3. Проверка контейнера

```bash
docker ps
```

### 4. Полное удаление (контейнер + образ + кеш)

```bash
docker stop job4j_di
```
```bash
docker rm job4j_di
```
```bash
docker rmi job4j_di
```