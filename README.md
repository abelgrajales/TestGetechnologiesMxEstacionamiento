## Prueba backend
A continuación adjunto capturas del funcionamiento de los casos de uso utilizando postman
El proyecto se creó con Spring Boot

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/6c4d9a5b-7ad6-40a3-914e-a7c09a7530da)

El importe cobrado depende del tipo de vehículo:
•	Los vehículos oficiales no pagan, pero se registran sus estancias para llevar el control. (Una estancia consiste en una hora de entrada y una de salida)
•	Los residentes pagan a final de mes a razón de MXN$0.05 el minuto. La aplicación irá acumulando el tiempo (en minutos) que han permanecido estacionados.
•	Los no residentes pagan a la salida del estacionamiento a razón de MXN$0.5 por minuto. Se prevé que en el futuro puedan incluirse nuevos tipos de vehículos, por lo que la aplicación desarrollada deberá ser fácilmente extensible en ese aspecto.

Los tipos de vehiculos tienen su propia tabla, por lo que en el futuro seria facilmente agregar nuevos tipos de vehiculos

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/046d1930-d9a3-4ffd-a58f-f8eb2a4a0939)

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/a6f84b5e-f8a4-4f4c-a491-622a38779dc8)

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/e98b98bb-aaad-41c1-903d-91c4e1169fa0)

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/dc783b21-8646-48bd-89a9-4d70691c3deb)

Caso de uso "Da de alta vehículo de residente"
1.	El empleado elige la opción "dar de alta vehículo de residente" e introduce su número de placa.
2.	La aplicación añade el vehículo a la lista de vehículos de residentes.

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/e192526f-7154-4c8b-87bf-01aa52e8a534)

Caso de uso "Da de alta vehículo de residente"
1.	El empleado elige la opción "dar de alta vehículo de residente" e introduce su número de placa.
2.	La aplicación añade el vehículo a la lista de vehículos de residentes.

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/d67cdcea-e669-4ed6-a200-fe8deef1021c)

Caso de uso "Registra entrada"
1.	El empleado elige la opción "registrar entrada" e introduce el número de placa del coche que entra.
2.	La aplicación apunta la hora de entrada del vehículo.

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/f2c7e9d7-d747-4282-ab59-c819816e7333)

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/e37cdb92-3b36-4944-88ff-bb94f847ec06)

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/000c0773-e2c1-4f31-a733-aaa27cb169bf)

Caso de uso "Registra salida"
1.	El empleado elige la opción "registrar salida" e introduce el número de placa del coche que sale.
2.	La aplicación realiza las acciones correspondientes al tipo de vehículo:
-	Oficial: asocia la estancia (hora de entrada y hora de salida) con el vehículo

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/354d8557-6e53-4ae0-9c18-766708be3c5b)

- Residente: suma la duración de la estancia al tiempo total acumulado

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/bbf43875-6265-4a8d-a3e5-9bc2943f47c9)

- o	No residente: obtiene el importe a pagar

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/6292c807-8378-4218-b65d-6cd67ccbe54b)

Se imprime el importe en consola

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/a18d717b-0b4d-41c9-a1d7-98d38c48b4bd)

Caso de uso "Pagos de residentes"
1.	El empleado elige la opción "genera informe de pagos de residentes" e introduce el nombre del archivo en el que quiere generar el informe.
2.	La aplicación genera un archivo que detalla el tiempo estacionado y el dinero a pagar por cada uno de los vehículos de residentes. El formato del archivo será el mostrado a continuación:

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/8db982f5-698a-4977-96d1-c354ba7e0d7c)

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/0ec6df0f-adeb-4874-8a29-d17ebb574485)

Se imprime el reporte en consola

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/156d7448-b2b8-416b-8c8a-67e1d2c48d27)

Caso de uso "Comienza mes"
1.	El empleado elige la opción "comienza mes".
2.	La aplicación elimina las estancias registradas en los coches oficiales y pone a cero el tiempo estacionado por los vehículos de residentes.

Se observa una estancia de vehiculo "Oficial" y una estancia de vehiculo residente con 6 minutos acumulados

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/53b726e3-a5af-4221-ad4f-eb59f5287d64)

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/4fd49907-cefa-4add-8a1d-98f67fda0da1)

Se observa eliminada la estancia de vehiculo oficial y en 0 los minutos acumulados del vehiculo residente

![image](https://github.com/abelgrajales/TestGetechnologiesMxEstacionamiento/assets/158242303/1f2dd90c-b610-420e-a245-bb6ea90413e1)
