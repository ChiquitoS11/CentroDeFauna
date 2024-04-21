-- Active: 1712506431166@@127.0.0.1@3306
DROP DATABASE IF EXISTS veterinaria;
CREATE DATABASE veterinaria CHARSET utf8mb4;
USE veterinaria;
CREATE TABLE ave (
  dni VARCHAR(9) PRIMARY KEY NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  tratamiento TEXT,
  fechaEntrada DATE NOT NULL,
  tipoAnimal ENUM('Ave', 'Mamifero', 'Reptil') NOT NULL,
  peso DOUBLE(5,2) NOT NULL,
  gravedad ENUM('LOW', 'MEDIUM', 'HIGH') NOT NULL,
  fechaSalida DATE,
  motivoSalida ENUM('MUERTE', 'LIBERACION'),
  veterinario VARCHAR(50),
  cazaFurtiva BOOLEAN NOT NULL
);
CREATE TABLE mamifero (
  dni VARCHAR(9) PRIMARY KEY NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  tratamiento TEXT,
  fechaEntrada DATE NOT NULL,
  tipoAnimal ENUM('Ave', 'Mamifero', 'Reptil') NOT NULL,
  peso DOUBLE(5,2) NOT NULL,
  gravedad ENUM('LOW', 'MEDIUM', 'HIGH') NOT NULL,
  fechaSalida DATE,
  motivoSalida ENUM('MUERTE', 'LIBERACION'),
  veterinario VARCHAR(50),
  atropello BOOLEAN NOT NULL
);
CREATE TABLE reptil ( 
  dni VARCHAR(9) PRIMARY KEY NOT NULL,
  nombre VARCHAR(100) NOT NULL,
  tratamiento TEXT,
  fechaEntrada DATE NOT NULL,
  tipoAnimal ENUM('Ave', 'Mamifero', 'Reptil') NOT NULL,
  peso DOUBLE(5,2) NOT NULL,
  gravedad ENUM('LOW', 'MEDIUM', 'HIGH') NOT NULL,
  fechaSalida DATE,
  motivoSalida ENUM('MUERTE', 'LIBERACION'),
  veterinario VARCHAR(50),
  infeccionBacteriana BOOLEAN NOT NULL
);