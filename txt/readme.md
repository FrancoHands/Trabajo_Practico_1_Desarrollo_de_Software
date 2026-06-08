1.  ¿Qué responsabilidades asignaste a cada objeto? 
    - A la clase "Paquete" le asigné las responsabilidades de: id, descripción y estado. Este objeto puede manejar sus propios cambios de estado a través del void "avanzarEstado()".
    - A la clase "Envio" le asigné un mínimo de 1 paquete y un máximo de 3 paquetes, también una propiedad para confirmar cuándo un envío se inicia y cuándo termina. Por último calcula cuánto pesa cada envío y cuál es el costo dependiendo del peso del mismo con un máximo de 100kg.
    - Por último, a las clases "EnvioEstandar", "EnvioExpress" y "EnvioInternacional", les heredé las propiedades de "Envio" y les cambié las tarifas según el tipo de envío.

2.  ¿Qué decisiones te resultaron difíciles? 
    - Se me complicó la validación de los envíos y cambiar el estado del paquete según el proceso.

3.  ¿Qué métodos decidiste hacer privados y por qué? 
    - Los métodos privados son "validarPeso" y "validarEnvioConPaquetes" y decidí que sean así porque están relacionados con el funcionamiento de Envio, no se usa en otras clases.

4.  ¿Qué setters evitaste implementar y por qué?
    - Evité usar setters para id, descripción y estado del Paquete porque estas propiedades se tienen que controlar por el objeto y no por el código externo para preservar los cambios de estado.

5.  ¿Qué código tuviste que cambiar al incorporar herencia?
    - Cambié el código de la herencia de Envio en "EnvioEstandar", "EnvioExpress" y "EnvioInternacional" para calcular mejor el precio de cada paquete en función del tipo de Envío.
