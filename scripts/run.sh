#!/bin/bash
cd ../
docker compose up -d
xdg-open "http://localhost:8081" &> /dev/null
