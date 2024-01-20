FROM node:18.10.0-alpine as builder
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

FROM nginx:alpine
COPY --from=builder /app/dist/fuse  /usr/share/nginx/html
