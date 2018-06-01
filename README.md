# Free Ecosistemas
En este GitHub existen tres carpetas en las cuales se divide el código de la siguie.nte manera:
 - Código apliación Android.
 - Código Java en Eclipse que data del servidor que comunica el serial al Firebase.
 - Código Arduino, código que controla la comunicación serial entre los sensores y el código java.
 
Aplicación Android:
  Dentro de este código se encuentra:
        - Conexión a Firebase - Database
        - Conexión a Firebase - Autenticación 
    
Aplicación Java Eclipse:
  Dentro de este código se encuentra:
    - Conexión a Firebase - Database
    - Conexión serial entre Arduino y el java, cumpliendo funciones de servidor y recolección de datos provenientes de los sensores.
    - Realización del tratamiento de los datos crudos provenientes de la comunicación serial.
    - Envío a Arduino de métodos de procedimiento para Arduino.
    
Aplicación Arduino:
  Se ocupa de:
    - A través de librería obtener los datos del sensor DTH11, sensor encargado de la temperatura y humedad.
    - Recolectas los datos de forma digital de:
      - Sensor temperatura
      - Sensor de presencia
    - Se encarga de realizar la comunicació serial de los datos crudos provenientes de los sensores.
    - Recepción de métodos de procedimiento y ejecución de actuadores como los LED's.
        
