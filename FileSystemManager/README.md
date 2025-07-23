📁 FileSystemManager
A Java-based command-line file management tool that mimics basic shell operations such as listing files, navigating directories, creating/deleting files and folders, renaming, and more.
🎯 Features

ls – List all files and directories with details (type, size, modified date)

cd <dir> – Navigate to subdirectories or parent using ..

pwd – Show current directory path

mkdir <name> – Create a new directory

touch <name> – Create a new file

rm <name> – Delete a file or directory (with confirmation for non-empty dirs)

rename <old> <new> – Rename files or folders

find <pattern> – Search for files/folders by name

info <name> – Show detailed metadata about a file or directory

exit – Exit the program

🛠 Technologies Used
Java java.io.File

Java Scanner for user input

SimpleDateFormat for timestamp formatting

Object-Oriented Programming (OOP)
🚀 How to Run
Compile:
javac FileSystemManager.java
Run:
java FileSystemManage
📸 Sample Usage
/home/user/JavaProjects/FileSystemManager> ls
Type | Size (bytes) | Last Modified       | Name
-------------------------------------------------
 d   |         4096 | 2025-07-23 11:15:00 | myFolder
 -   |           58 | 2025-07-23 11:16:45 | notes.txt

/home/user/JavaProjects/FileSystemManager> cd myFolder
/home/user/JavaProjects/FileSystemManager/myFolder> touch demo.txt
✅ Requirements
Java 8 or later

Terminal/Command prompt
