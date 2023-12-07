@testKarate
Feature: Validacion del servicio de Autenticacion
  Como usuario de la web necesito realizar pruebas al servicio de login y Registro para validar su correcto funcionamiento

  Background:
    * def baseUrl = "https://api.demoblaze.com"
    * def userAndPassword = {"username": "DimaxQp","password": "dGVzdA=="}

    * def randomUsername = 'nuevoUser' + java.util.UUID.randomUUID().toString().replaceAll("-", "").substring(0, 36)
    * print 'Generated Username:', randomUsername
    * def requestDataUserRandom = { "username": '#(randomUsername)', "password": "test" }

  @testKarate @karate01
  Scenario: Validar creacion de nuevo usuario

    Given url baseUrl
    And path "/signup"
    And request requestDataUserRandom
    When method post
    Then status 200

  @testKarate @karate02
  Scenario: Validar intento de creacion de usuario ya existente
    Given url baseUrl
    And path "/signup"
    And request userAndPassword
    When method post
    Then status 200
    And match $ == {"errorMessage":"This user already exist."}

  @testKarate @karate03
  Scenario: Validar inicio de sesion correcto
    Given url baseUrl
    And path "/login"
    And request userAndPassword
    When method post
    Then status 200
    And match response contains 'Auth_token:'

  @testKarate @karate04
  Scenario: Validar inicio de sesion con password incorrecto
    Given url baseUrl
    And path "/login"
    And request { "username": "test", "password": "testFail2023" }
    When method post
    Then status 200
    And match $ == {"errorMessage": "Wrong password."}

  @testKarate @karate05
  Scenario: Validar inicio de sesion con usuario incorrecto
    Given url baseUrl
    And path "/login"
    And request requestDataUserRandom
    When method post
    Then status 200
    And match $ == {errorMessage: "User does not exist."}



