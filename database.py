import sqlite3

def create_table():
    conn = sqlite3.connect('attendance.db')
    c = conn.cursor()
    c.execute('''
        CREATE TABLE IF NOT EXISTS attendance (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            timestamp DATETIME DEFAULT CURRENT_TIMESTAMP
        )
    ''')
    conn.commit()
    conn.close()

def insert_attendance(name):

    conn = sqlite3.connect('attendance.db')
    c = conn.cursor()
    c.execute("INSERT INTO attendance (name) VALUES (?)", (name,))
    conn.commit()
    conn.close()

if __name__ == "__main__":
    create_table()
    print("✅ Table created successfully.")
