#!/bin/bash
echo "Compiling SmartDailyPlanner..."
javac -cp ".:libs/json-20240303.jar" mini_projects/SmartDailyPlanner/*.java
echo "Compilation complete."

