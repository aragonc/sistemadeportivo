# Sistema Deportivo
Sistema Deportivo para la gestión de campeonatos entre equipos, con diversas disciplinas por categorias

## Pasos para su instalación.

1. Descargar el proyecto del repositorio de github.

<pre> git clone https://github.com/aragonc/sistemadeportivo </pre>

2. Importar el proyecto a Eclipse (Mars o Superior), configurarlo con Apache Tomcat 8 y Java SDK 8
3. Instalar Node.js y bower

<pre>sudo apt-get update
sudo apt-get install nodejs-legacy</pre>

Verificar la instalacion de Node.js

<pre>node -v</pre>

Luego instalar el npm

<pre>sudo apt-get install npm</pre>

Instalar Bower como gestor de paquetes

<pre>sudo npm install bower -g</pre>

El proyecto depende de bower para usar las dependencias, debera ingresar a la raiz del proyecto y en la linea de comandos usar.

<pre>bower install</pre>
