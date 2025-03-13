# Usa a imagem do Node.js para construir a aplicação
FROM node:12 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do frontend
COPY package*.json ./
RUN npm install

# Copia o restante do código e gera a build
COPY . .
RUN npm run build --prod

# Usa uma imagem Nginx para servir a aplicação Angular
FROM nginx:alpine

# Copia a build gerada para a pasta padrão do Nginx
COPY --from=build /app/dist /usr/share/nginx/html

# Expondo a porta do Nginx
EXPOSE 80
