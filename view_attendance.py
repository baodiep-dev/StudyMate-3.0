import sqlite3
import pytz
from datetime import datetime

# Function to insert attendance with local time
def insert_attendance(name):
    # Get the current UTC time
    utc_now = datetime.utcnow().replace(tzinfo=pytz.utc)
    
    # Convert it to your local timezone (example: 'Asia/Kolkata' for IST)
    local_tz = pytz.timezone('Asia/Kolkata')  
    local_time = utc_now.astimezone(local_tz)
    
    # Format the time as a string
    formatted_time = local_time.strftime('%Y-%m-%d %H:%M:%S')
    
    # Insert the attendance with the corrected timestamp
    conn = sqlite3.connect('attendance.db')
    c = conn.cursor()
    c.execute("INSERT INTO attendance (name, timestamp) VALUES (?, ?)", (name, formatted_time))
    conn.commit()
    conn.close()

# to view all attendance data
def view_attendance():
    conn = sqlite3.connect('attendance.db')
    c = conn.cursor()
    c.execute("SELECT * FROM attendance")
    rows = c.fetchall()

    for row in rows:
        print(row)

    conn.close()

view_attendance()  
