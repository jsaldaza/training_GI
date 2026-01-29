Feature: Login en The Internet

  Scenario: Login exitoso con credenciales válidas
    Given el usuario abre la página de login
    When ingresa credenciales válidas
    Then debería ver el mensaje de login exitoso
