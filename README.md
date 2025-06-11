# 🎓 StudyMate Pro – Your All-in-One Academic Companion

StudyMate Pro is a Java-based desktop application designed to enhance student productivity with tools for attendance tracking, learning resources, quizzes, assignments, and interactive games—all in one place.

---

## 🎥 Demo

A video demonstration of StudyMate Pro can be found here:  
🔗 [Watch the Demo Video](https://placeholder.link)

---

## 🧠 Project Overview

StudyMate Pro addresses common academic challenges:

- **Manual attendance tracking** → Replaced with AI-powered facial recognition  
- **Scattered learning resources** → Centralized video links & assignments  
- **Lack of engagement** → Interactive quizzes & mini-games for fun learning  

---

## 🎯 Objectives

- ✅ Automate attendance using face recognition (Python + OpenCV)  
- ✅ Centralize study materials (Java, C, Python video tutorials + assignments)  
- ✅ Engage students with quizzes and word/number games  
- ✅ Secure access via login system (Username: `VPN`, Password: `vpn123`)  

---

## ⚙️ Tech Stack

| Component              | Description                                          |
| ---------------------- | ---------------------------------------------------- |
| **Java (Swing GUI)**   | Core application framework with interactive UI       |
| **Python (OpenCV)**    | Facial recognition for attendance marking            |
| **SQLite**             | Local database for storing attendance records        |
| **JVM**                | Cross-platform execution of Java modules             |

---

## 🗃️ Database Design

**SQLite Schema:**  
```sql
CREATE TABLE attendance (
    id        INTEGER PRIMARY KEY AUTOINCREMENT,
    name      TEXT    NOT NULL,
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP
);
```

### 🗃️ Features

- Stores student names and timestamps  
- Timezone-aware logging (e.g., Asia/Kolkata)  

---

## 💡 Key Features

### 🔐 Secure Login System
- Username/password authentication (`VPN` / `vpn123`)  
- Launches the main StudyMate dashboard upon success  

### 🤖 Facial Attendance (AI-Powered)
- Uses OpenCV + `face_recognition` (Python) to detect and log students  
- Real-time webcam feed with bounding boxes  

### 📚 Study Resources
- **Video Links:** Direct YouTube integration for Java/C/Python tutorials  
- **Assignments:** Displays programming tasks with descriptions  

### 🧩 Interactive Quizzes
- Multiple-choice quizzes for Java, C, Python  
- Dynamic scoring and instant feedback  

### 🕹️ Mini-Games
- **Guess the Number:** Math-based challenge (1–10 range)  
- **Word Guesser:** Linear data structure terminology game  

### 🧱 Modular Design
- **Extensible:** Easy to add new subjects or games  
- **OOP Principles:** Abstract `Game` class for reusable game logic  

---

## ✅ Conclusion

StudyMate Pro bridges productivity and engagement for students by combining:

- **Automation** (attendance)  
- **Centralized resources** (videos & assignments)  
- **Interactive learning** (quizzes & games)  

---

## 🔮 Future Upgrades

- Add user profiles (multi-student support)  
- Integrate a cloud database for remote access  

---

## 📬 Contact

For questions or contributions, feel free to reach out:  
📧 **Email:** vipinchoudhary0911@gmail.com  
🔗 **GitHub:** [github.com/VipinChoudhary-dev](https://github.com/VipinChoudhary-dev)
