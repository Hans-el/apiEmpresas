// ya lo usamos directamente en el SecurityConfig.java porque es más seguro y
// flexible inyectar la clave desde application.properties usando @Value, en
// lugar de tenerla hardcodeada en el código fuente. Esto permite cambiar la
// clave sin necesidad de recompilar el código y mantenerla fuera del control de
// versiones.