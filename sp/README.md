# SP - Design Patterns Lab 1

This is a minimal Java project implementing the Book/Section/Element model using the Composite pattern.

To build and run (PowerShell):

mvn -q -DskipTests package
java -cp target/sp-1.0-SNAPSHOT.jar sp.lab.Main

Git push (from `sp`):

git add .
git commit -m "Add composite book model and example"
git push -u origin main

If you get authentication errors, clear stored GitHub credentials (Windows Credential Manager) or switch to SSH as explained earlier.