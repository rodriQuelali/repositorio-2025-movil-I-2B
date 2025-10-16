package com.example.myapplicationempleado.data

class Empleado(
    private var nombre: String,
    private var salario: Double,
    private var fechaIngreso: String
) {

    // Getter y Setter para nombre
    fun getNombre(): String {
        return nombre
    }

    fun setNombre(nombre: String) {
        this.nombre = nombre
    }

    // Getter y Setter para salario
    fun getSalario(): Double {
        return salario
    }

    fun setSalario(salario: Double) {
        this.salario = salario
    }

    // Getter y Setter para fechaIngreso
    fun getFechaIngreso(): String {
        return fechaIngreso
    }

    fun setFechaIngreso(fechaIngreso: String) {
        this.fechaIngreso = fechaIngreso
    }
}
