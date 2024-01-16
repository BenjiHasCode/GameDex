#stage 1
#FROM node:latest as node
#WORKDIR /app
#COPY . .
#RUN npm install
#RUN npm run build --prod
#stage 2
#FROM nginx:alpine
#COPY --from=node /app/dist/GameDex /usr/share/nginx/html
#EXPOSE 80*/


# Use an official Node.js image as a base
#FROM node:14 as build

# Set the working directory in the container
#WORKDIR /usr/src/app

# Copy package.json and package-lock.json to the working directory
#COPY package*.json ./

# Install app dependencies
#RUN npm install

# Copy the rest of the application code
#COPY . .

# Build the Angular app for production
#RUN npm run build --prod

# Use a smaller, production-ready image
#FROM nginx:alpine

# Copy the built app from the previous stage
#COPY --from=build /usr/src/app/dist/GameDex /usr/share/nginx/html

# Expose the default port for nginx
#EXPOSE 80

# CMD is not necessary as the default CMD in the nginx image serves the static files



# Stage 1: Build the Angular app
FROM node:18 AS build

WORKDIR /usr/src/app

# Copy only the package.json and package-lock.json first to leverage Docker cache
COPY package*.json ./

# Install app dependencies, including the Angular CLI
RUN npm install -g @angular/cli
RUN npm install --force #TODO fix dependency conflict

# Copy the rest of the application code
COPY . .

# Build the Angular app for production
RUN ng build

# Stage 2: Use a smaller, production-ready image
FROM nginx:alpine

# Copy the built app from the previous stage
COPY --from=build /usr/src/app/dist/GameDex /usr/share/nginx/html

# Expose the default port for nginx
EXPOSE 80
