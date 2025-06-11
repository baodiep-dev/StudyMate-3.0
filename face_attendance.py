import cv2
import face_recognition
import os
import numpy as np
from database import insert_attendance
from datetime import datetime

# Load known faces
KNOWN_FACES_DIR = 'known_faces'
images = []
classNames = []

# Only load files ending in these extensions:
IMAGE_EXTS = {'.jpg', '.jpeg', '.png', '.bmp'}

for file in os.listdir(KNOWN_FACES_DIR):
    ext = os.path.splitext(file)[1].lower()
    if ext not in IMAGE_EXTS:
        continue

    img_path = os.path.join(KNOWN_FACES_DIR, file)
    img = cv2.imread(img_path)
    if img is None:
        print(f'⚠️ Warning: couldn’t load image {img_path}, skipping.')
        continue

    images.append(img)
    classNames.append(os.path.splitext(file)[0])

def find_encodings(images):
    encode_list = []
    for img in images:
        # convert to RGB for face_recognition
        rgb = cv2.cvtColor(img, cv2.COLOR_BGR2RGB)
        encs = face_recognition.face_encodings(rgb)
        if encs:
            encode_list.append(encs[0])
        else:
            print('⚠️ Warning: no face found in one of the known images.')
    return encode_list

known_encodings = find_encodings(images)
print('✅ Face encodings completed.')

logged_names = []

# Start webcam
cap = cv2.VideoCapture(0)

while True:
    success, frame = cap.read()
    if not success:
        print('⚠️ Failed to grab frame from webcam, exiting.')
        break

    # resize & RGB-convert
    small_frame = cv2.resize(frame, (0, 0), fx=0.25, fy=0.25)
    small_frame = cv2.cvtColor(small_frame, cv2.COLOR_BGR2RGB)

    faces = face_recognition.face_locations(small_frame)
    encodings = face_recognition.face_encodings(small_frame, faces)

    for encodeFace, faceLoc in zip(encodings, faces):
        matches = face_recognition.compare_faces(known_encodings, encodeFace)
        face_dist = face_recognition.face_distance(known_encodings, encodeFace)
        best_match = np.argmin(face_dist)

        if matches[best_match]:
            name = classNames[best_match].capitalize()
            if name not in logged_names:
                insert_attendance(name)
                logged_names.append(name)
                print(f'📝 Logged: {name} at {datetime.now()}')

            # scale face locations back up, draw box & label
            y1, x2, y2, x1 = faceLoc
            y1, x2, y2, x1 = y1*4, x2*4, y2*4, x1*4
            cv2.rectangle(frame, (x1, y1), (x2, y2), (0, 255, 0), 2)
            cv2.putText(frame, name, (x1+6, y2+25),
                        cv2.FONT_HERSHEY_SIMPLEX, 1, (255, 255, 255), 2)

    cv2.imshow('Face Attendance System', frame)
    if cv2.waitKey(1) == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
