#!/bin/bash
cd ../frontend
npm run build

cd ../backend
mvn clean package
